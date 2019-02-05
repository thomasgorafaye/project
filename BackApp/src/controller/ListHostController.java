/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Host;
import service.HostService;

/**
 *
 * @author thomas
 */
public class ListHostController implements Initializable {
    
    @FXML
    private TextField sid,hostname,ownername,email,osname,osuser,ospassword,dbuser,dbpassword,version;
    
    @FXML 
    private TableView<Host> tableView;
    
    @FXML 
    private Label entete;
    
    @FXML 
    private Parent root;
    
    private ObservableList<Host> HostList = FXCollections.observableArrayList();
    
    private HostService hostService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hostService = new HostService();
        HostList.addAll(hostService.findAll());
        tableView.getItems().addAll(HostList);
        tableView.getItems().add(new Host("Rose","Rose","Rose","Rose","Rose","Rose","Rose","Rose","Rose","Rose"));
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Host>() {
            @Override
            public void changed(ObservableValue<? extends Host> observable, Host oldValue, Host newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
    } 
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        Host h = new Host(sid.getText(),hostname.getText(),ownername.getText(),email.getText(),osname.getText(),osuser.getText(),ospassword.getText(),dbuser.getText(),dbpassword.getText(),version.getText());
        if(entete.getText().equals("Enregistrement")){
        //hostService.create(h);
        tableView.getItems().add(h);
        }else{
           int index = tableView.getItems().indexOf(selected);
           tableView.getItems().set(index, h);
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
            //hostService.delete(selected);
            tableView.getItems().remove(selected);
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
        root = FXMLLoader.load(getClass().getResource("/view/Createhost.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
