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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author thomas
 */
public class ListPlanController implements Initializable {
    
    @FXML
    private TextField type,method,object,name,strategy,s_repertory,d_repertory,log;
    
    @FXML 
    private TableView tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        type.clear();method.clear();object.clear();name.clear();strategy.clear();s_repertory.clear();d_repertory.clear();log.clear();
    }
}