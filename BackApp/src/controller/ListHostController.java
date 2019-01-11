/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
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
    private TableView tableView;
    
    private HostService hostService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hostService = new HostService();
        //listView.getItems().addAll(hostService.findAll());
    } 
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        Host h = new Host(sid.getText(),hostname.getText(),ownername.getText(),email.getText(),osname.getText(),osuser.getText(),ospassword.getText(),dbuser.getText(),dbpassword.getText(),version.getText());
        hostService.create(h);
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        sid.clear();hostname.clear();ownername.clear();email.clear();osname.clear();osuser.clear();ospassword.clear();dbuser.clear();dbpassword.clear();version.clear();
    }
    
}
