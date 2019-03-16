/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Backup;
import model.Host;
import model.Variant;
import service.BackupService;
import service.HostService;
import service.VariantService;
import tool.Notification;

/**
 *
 * @author thomas
 */
public class CreateBackupController implements Initializable {
    
    @FXML
    private Label l_sid,l_hostname,l_ownername,l_email,l_osname,l_osuser,l_ospassword,l_dbuser,l_dbpassword,l_version,
            p_sid,p_hostname,p_ownername,p_email,p_osname,p_osuser,p_ospassword,p_dbuser,p_dbpassword,p_version;
    
    @FXML
    private ComboBox type,method,object,strategy;
            
    @FXML
    private TextField name,s_repertory,d_repertory,log;
    
    @FXML 
    private ListView<Host> listView;
    
    @FXML
    private VBox flux;
    
    @FXML
    private ProgressIndicator progress;
    
    private final String listType[] = {"Sauvegarde à chaud","Sauvegarde à froid"};
    private final String listMethod[] = {"Xcopy","Rman","Import/Export"};
    private final String listObject[] = {"database","schema","user","tablespace","tables"};
    private final String listStrategy[] = {"Sauvegarde complète","Full sauvegarde","Différentielle niveau 0","Cumulative niveau 0","Différentielle niveau 1","Cumulative niveau 1","Différentielle niveau 2","Cumulative niveau 2"};
    
    private BackupService backupService;
    private HostService hostService;
    private VariantService variantService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       backupService = new BackupService();
       hostService = new HostService();
       variantService = new VariantService();
       type.getItems().addAll((Object[])listType);
       method.getItems().addAll((Object[])listMethod);
       object.getItems().addAll((Object[])listObject);
        strategy.getItems().addAll((Object[])listStrategy);
       listView.getItems().addAll(hostService.findAll());
       listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Host>() {
           @Override
           public void changed(ObservableValue<? extends Host> observable, Host oldValue, Host newValue) {
               selected=newValue;
               p_sid.setText(selected.getSid());
               p_hostname.setText(selected.getHostname());
               p_ownername.setText(selected.getOwnername());
               p_email.setText(selected.getEmail());
               p_osname.setText(selected.getOsname());
               p_osuser.setText(selected.getOsuser());
               p_ospassword.setText(selected.getOspassword());
               p_dbuser.setText(selected.getDbuser());
               p_dbpassword.setText(selected.getDbpassword());
               p_version.setText(selected.getVersion());
               System.out.println("Selected item: " + newValue);
           }
       });
       progress.setVisible(false);
       /*JFXButton button = new JFXButton("Popup!");
       JFXPopup popup = new JFXPopup(button);
       popup.show(button);*/
    }

    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        Date date = new Date();
        String time = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        if(selected!=null){
            Backup b = new Backup(date.getTime(),date,time,type.getValue().toString(),method.getValue().toString(),object.getValue().toString(),name.getText(),strategy.getValue().toString(),s_repertory.getText(),d_repertory.getText(),log.getText(),true,false,selected.getSid(),0);
            b.setHost(selected.getSid());
            try {          
                changeScreen("/view/Flux.fxml");
            } catch (IOException ex) {
                Logger.getLogger(CreateBackupController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Task<Integer> task = new Task<Integer>(){
                @Override
                protected Integer call() throws Exception {
                    progress.setVisible(true);
                    int result = backupService.create(selected, b);             
                    System.out.println("Backup finished");
                    return result;
                }  
                
            };
            task.setOnSucceeded((e)->{
                progress.setVisible(false);
                int result = 0;
                try {
                    result = task.get();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CreateBackupController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(CreateBackupController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(result==0){
                    System.out.println("Succeded");
                    Notification.notifySuccess("Sauvegarde effectuée", "La sauvegarde de la base de données a été effectuée");
                }else if(result ==1) {
                    System.out.println("Failed");
                    Notification.notifyError("Echec de la sauvegarde", "La connexion sur la base de données a échoué");
                }else{
                    System.out.println("Failed");
                    Notification.notifyError("Echec de la sauvegarde", "La base de données n'est pas en mode ARCHIVELOG");
                }
                
            });

            progress.progressProperty().bind(task.progressProperty());        
            new Thread(task).start();
        }else{
            showErrorAlert("Données manquantes","Veuillez d'abord choisir une base de données.");
        }
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        type.setValue(null);method.setValue(null);object.setValue(null);name.clear();strategy.setValue(null);s_repertory.clear();d_repertory.clear();log.clear();
    }
    
    @FXML
    private void logButton(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(new Stage());
        if(selectedDirectory != null)
            log.setText(selectedDirectory.getAbsolutePath());
        
    }
    
    @FXML
    private void sRepertoryButton(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(new Stage());
        if(selectedDirectory != null)
            s_repertory.setText(selectedDirectory.getAbsolutePath());
        
    }
    
    @FXML
    private void dRepertoryButton(ActionEvent event){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(new Stage());
        if(selectedDirectory != null)
            d_repertory.setText(selectedDirectory.getAbsolutePath());
        
    }
    
    @FXML
    private void createVariant(ActionEvent event){
        String description = showTextInputDialog();
        Variant b = new Variant(0,type.getValue().toString(),method.getValue().toString(),object.getValue().toString(),name.getText(),strategy.getValue().toString(),s_repertory.getText(),d_repertory.getText(),log.getText(),description);
        variantService.create(b);
    }
    
    @FXML
    private void selectVariant(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Variantdialog.fxml"));
        Parent parent = fxmlLoader.load();
        VariantDialogController variantDialog = fxmlLoader.<VariantDialogController>getController();
        Variant returned = new Variant();
        variantDialog.setValue(returned);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(false);
        stage.setTitle("Sélection d'une variante");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        fillVariant(returned);
    }
    
    private void changeScreen(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
    	AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
                        flux.getChildren().remove(0);
			flux.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    private void showErrorAlert(String title, String text){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    private String showTextInputDialog(){
        TextInputDialog dialog= new TextInputDialog("description");
        dialog.setTitle("Création Variante");
        dialog.setHeaderText("Entrez la description");
        dialog.setContentText("Description");
        Optional<String> result = dialog.showAndWait();
        return result.get();
    }

    private void fillVariant(Variant returned) {
        type.setValue(returned.getType());
        method.setValue(returned.getMethod());
        object.setValue(returned.getObject());
        name.setText(returned.getName());
        strategy.setValue(returned.getStrategy());
        s_repertory.setText(returned.getS_repertory());
        d_repertory.setText(returned.getD_repertory());
        log.setText(returned.getLog());
    }
    
}
