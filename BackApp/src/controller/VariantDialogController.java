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
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Host;
import model.Variant;
import service.VariantService;

/**
 *
 * @author thomas
 */
public class VariantDialogController implements Initializable{

    @FXML 
    private ListView<Variant> listView;
    
    private Variant selected,returned;
    private VariantService variantService;
    
    public VariantDialogController(){
        variantService = new VariantService();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         listView.getItems().addAll(variantService.findAll());
         listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Variant>() {
            @Override
            public void changed(ObservableValue<? extends Variant> observable, Variant oldValue, Variant newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
    }
    
    @FXML
    private void supprimer(ActionEvent event){
        if(selected!=null){
            listView.getItems().remove(selected);
        }
    }
    
    @FXML
    private void selectionner(ActionEvent event){
        if(selected!=null)
            returnValue();
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    
    private void returnValue(){
        returned.setType(selected.getType());
        returned.setMethod(selected.getMethod());
        returned.setObject(selected.getObject());
        returned.setName(selected.getName());
        returned.setStrategy(selected.getStrategy());
        returned.setS_repertory(selected.getS_repertory());
        returned.setD_repertory(selected.getD_repertory());
        returned.setLog(selected.getLog());
    }
    
    public void setValue(Variant returned){       
        this.returned = returned;
    }
}
