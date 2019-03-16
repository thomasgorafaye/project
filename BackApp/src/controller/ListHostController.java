/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Host;
import service.HostService;
import service.PlanService;
import tool.Notification;
/**
 *
 * @author thomas
 */
public class ListHostController implements Initializable {
    
    @FXML
    private TextField sid,hostname,ownername,email,osname,osuser,ospassword,dbuser,dbpassword,version,filter;
    
    @FXML 
    private TableView<Host> tableView;
    
    @FXML 
    private Label entete;
    
    @FXML 
    private Parent root;
    
    @FXML 
    private SplitPane pane;
    
    private ObservableList<Host> HostList = FXCollections.observableArrayList();
    private ObservableList<Host> HostListFilter = FXCollections.observableArrayList();
    
    private HostService hostService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hostService = new HostService();
        HostList.addAll(hostService.findAll());
        HostListFilter.addAll(HostList);
        tableView.setItems(HostListFilter);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Host>() {
            @Override
            public void changed(ObservableValue<? extends Host> observable, Host oldValue, Host newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        HostList.addListener(new ListChangeListener<Host>(){
            @Override
           public void onChanged(ListChangeListener.Change<? extends Host> change){
               updateFilteredData();
           }
        });
        filter.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateFilteredData();
            }
            
        });
    } 
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        Host h = new Host(sid.getText(),hostname.getText(),ownername.getText(),email.getText(),osname.getText(),osuser.getText(),ospassword.getText(),dbuser.getText(),dbpassword.getText(),version.getText());
        if(entete.getText().equals("Enregistrement")){
        hostService.create(h);
        HostList.add(h);
        Notification.notifySuccess("Enregistrement avec succès", "La base de données été bien enregistrée");
        }else{
           hostService.update(h);
           int index = HostList.indexOf(selected);
           HostList.set(index, h);
           Notification.notifySuccess("Modification avec succès", "La base de données été bien modifiée");
        }
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        sid.clear();hostname.clear();ownername.clear();email.clear();osname.clear();osuser.clear();ospassword.clear();dbuser.clear();dbpassword.clear();version.clear();
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        System.out.println("You clicked me!");
        Host h = new Host(sid.getText(),hostname.getText(),ownername.getText(),email.getText(),osname.getText(),osuser.getText(),ospassword.getText(),dbuser.getText(),dbpassword.getText(),version.getText());
        if(selected != null){
            PlanService planService =  new PlanService();
            planService.deleteByHost(selected.getSid());
            hostService.delete(selected);
            tableView.getItems().remove(selected);
            Notification.notifyNotice("Suppression effectuée", "La base de données a été supprimée avec ses planifications");
        }  
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            //hostService.delete(selected);
            entete.setText("Modification SID:"+selected.getSid());
            sid.setText(selected.getSid());
            hostname.setText(selected.getHostname());
            ownername.setText(selected.getOwnername());
            email.setText(selected.getEmail());
            osname.setText(selected.getOsname());
            osuser.setText(selected.getOsuser());
            ospassword.setText(selected.getOspassword());
            dbuser.setText(selected.getDbuser());
            dbpassword.setText(selected.getDbpassword());
            version.setText(selected.getVersion());
        }  
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        System.out.println("You clicked me!");
        entete.setText("Enregistrement");
    }
    
    @FXML
    private void item(ActionEvent event) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        pane = FXMLLoader.load(getClass().getResource("/view/test.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private void updateFilteredData(){
        HostListFilter.clear();
        for(Host h : HostList){
            if(matchesFilter(h)){
                HostListFilter.add(h);
            }
        }
        ArrayList<TableColumn<Host,?>> sortOrder = new ArrayList<>(tableView.getSortOrder());
        tableView.getSortOrder().clear();
        tableView.getSortOrder().addAll(sortOrder);
    }

    private boolean matchesFilter(Host h) {
        String filterString = filter.getText();
        if((filterString == null)||filterString.isEmpty()){
            return true;
        }
        String lowerCaseFilterString = filterString.toLowerCase();
        if(h.toSearch().toLowerCase().contains(lowerCaseFilterString)){
            return true;
        }
        return false;
    }
}