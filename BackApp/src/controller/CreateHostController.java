/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Host;
import service.HostService;

/**
 *
 * @author thomas
 */
public class CreateHostController implements Initializable {
    
    @FXML
    private Label l_sid,l_hostname,l_ownername,l_email,l_osname,l_osuser,l_ospassword,l_dbuser,l_dbpassword,l_version,
            p_sid,p_hostname,p_ownername,p_email,p_osname,p_osuser,p_ospassword,p_dbuser,p_dbpassword,p_version;
    
    @FXML
    private TextField sid,hostname,ownername,email,osname,osuser,ospassword,dbuser,dbpassword,version;
    
    @FXML 
    private ListView<Host> listView;
    
    @FXML
    private AnchorPane anchor1;
    
    private HostService hostService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hostService = new HostService();
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
        Host h = new Host(sid.getText(),hostname.getText(),ownername.getText(),email.getText(),osname.getText(),osuser.getText(),ospassword.getText(),dbuser.getText(),dbpassword.getText(),version.getText());
        hostService.create(h);
        listView.getItems().add(h);
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        sid.clear();hostname.clear();ownername.clear();email.clear();osname.clear();osuser.clear();ospassword.clear();dbuser.clear();dbpassword.clear();version.clear();
    }
    
}
