/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Host;
import model.Plan;
import model.Variant;
import service.PlanService;
import service.HostService;
import service.VariantService;
import tool.Notification;

/**
 *
 * @author thomas
 */
public class CreatePlanController implements Initializable {
    
    @FXML
    private Label l_sid,l_hostname,l_ownername,l_email,l_osname,l_osuser,l_ospassword,l_dbuser,l_dbpassword,l_version,
            p_sid,p_hostname,p_ownername,p_email,p_osname,p_osuser,p_ospassword,p_dbuser,p_dbpassword,p_version;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private ComboBox type,method,object,strategy;
            
    @FXML
    private TextField name,s_repertory,d_repertory,log;
    
    @FXML 
    private ListView<Host> listView;
    
    private final String listType[] = {"Sauvegarde à chaud","Sauvegarde à froid"};
    private final String listMethod[] = {"Xcopy","Rman","Import/Export"};
    private final String listObject[] = {"database","schema","user","tablespace","table"};
    private final String listStrategy[] = {"Saugarde complète","Full sauvegarde","Différentielle niveau 0","Cumulative niveau 0","Différentielle niveau 1","Cumulative niveau 1","Différentielle niveau 2","Cumulative niveau 2"};
    
    private PlanService planService;
    private HostService hostService;
    private VariantService variantService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().addAll((Object[])listType);
        method.getItems().addAll((Object[])listMethod);
        object.getItems().addAll((Object[])listObject);
        strategy.getItems().addAll((Object[])listStrategy);
        planService = new PlanService();
       hostService = new HostService();
       variantService = new VariantService();
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
    }    
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        int id = (int) (Math.random()*1000);
        if(selected!=null){
            Plan b = new Plan(id,true,"script.bat",object.getValue().toString(),name.getText(),type.getValue().toString(),method.getValue().toString(),strategy.getValue().toString(),s_repertory.getText(),d_repertory.getText(),log.getText(),selected.getSid());
            planService.create(b);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Listcron.fxml"));
            AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
                        VBox parent = (VBox) anchorPane.getParent();
                        parent.getChildren().remove(0);
			parent.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
            backapp.BackApp.tabPreviousCurrent.remove(0);
            backapp.BackApp.tabPreviousCurrent.add(7);
            Notification.notifySuccess("Enregistrement avec succès", "La planification été bien enregistrée");
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
    
        private void showErrorAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
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
