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
import model.Backup;
import model.Host;
import service.BackupService;
import service.HostService;

/**
 *
 * @author thomas
 */
public class CreateBackupController implements Initializable {
    
    @FXML
    private Label l_sid,l_hostname,l_ownername,l_email,l_osname,l_osuser,l_ospassword,l_dbuser,l_dbpassword,l_version,
            p_sid,p_hostname,p_ownername,p_email,p_osname,p_osuser,p_ospassword,p_dbuser,p_dbpassword,p_version;
    
    @FXML
    private TextField type,method,object,name,strategy,s_repertory,d_repertory,log;
    
    @FXML 
    private ListView<Host> listView;
    
    private BackupService backupService;
    private HostService hostService;
    
    private Host selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       backupService = new BackupService();
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
        Backup b = new Backup();
        backupService.create(selected, b);
        
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        type.clear();method.clear();object.clear();name.clear();strategy.clear();s_repertory.clear();d_repertory.clear();log.clear();
    }
    
}
