/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Plan;
import service.PlanService;

/**
 *
 * @author thomas
 */
public class ListPlanController implements Initializable {
    
    @FXML
    private TextField type,method,object,name,strategy,s_repertory,d_repertory,log;
    
    @FXML 
    private TableView tableView;
    
    private PlanService planService;
    
    @FXML 
    private Label entete;
    
    private ObservableList<Plan> PlanList = FXCollections.observableArrayList();
    
    private Plan selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planService = new PlanService();
        PlanList.addAll(planService.findAll());
        tableView.getItems().addAll(PlanList);
        tableView.getItems().add(new Plan(1,true,"Rose","Rose","Rose","Rose","Rose","Rose","Rose","Rose","Rose"));
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Plan>() {
            @Override
            public void changed(ObservableValue<? extends Plan> observable, Plan oldValue, Plan newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
    }    
    
    @FXML
    private void enregistrer(ActionEvent event) {
        System.out.println("You clicked me!");
        Plan b = new Plan();
        if(entete.getText().equals("Enregistrement")){
        //hostService.create(h);
        tableView.getItems().add(b);
        }else{
           int index = tableView.getItems().indexOf(selected);
           tableView.getItems().set(index, b);
        }
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        type.clear();method.clear();object.clear();name.clear();strategy.clear();s_repertory.clear();d_repertory.clear();log.clear();
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        System.out.println("You clicked me!");
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
            entete.setText("Modification SID:"+selected.getId());
            type.setText(selected.getType());
            method.setText(selected.getMethod());
            object.setText(selected.getObject());
            name.setText(selected.getName());
            strategy.setText(selected.getStrategy());
            s_repertory.setText(selected.getS_repertory());
            d_repertory.setText(selected.getD_repertory());
            log.setText(selected.getLog());
        }  
    }
    
    @FXML
    private void ajouter(ActionEvent event) {
        System.out.println("You clicked me!");
        entete.setText("Enregistrement");
    }
}
