/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.Host;
import model.Plan;
import service.CronService;
import service.HostService;
import service.PlanService;
import tool.Notification;

/**
 *
 * @author thomas
 */
public class ListPlanController implements Initializable {
    
    @FXML
    private ComboBox type,method,object,strategy,sid;
            
    @FXML
    private TextField name,s_repertory,d_repertory,log,filter;
    
    @FXML 
    private TableView tableView;
    
    private PlanService planService;
    private HostService hostService;
    
    @FXML 
    private Label entete;
    
    private final String listType[] = {"Sauvegarde à chaud","Sauvegarde à froid"};
    private final String listMethod[] = {"Xcopy","Rman","Import/Export"};
    private final String listObject[] = {"database","schema","user","tablespace","table"};
    private final String listStrategy[] = {"Saugarde complète","Full sauvegarde","Différentielle niveau 0","Cumulative niveau 0","Différentielle niveau 1","Cumulative niveau 1","Différentielle niveau 2","Cumulative niveau 2"};
    
    private ObservableList<Plan> PlanList = FXCollections.observableArrayList();
    private ObservableList<Plan> PlanListFilter = FXCollections.observableArrayList();
    
    private Plan selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planService = new PlanService();
        hostService = new HostService();
        sid.getItems().addAll(hostService.findAllSid());
        type.getItems().addAll((Object[])listType);
        method.getItems().addAll((Object[])listMethod);
        object.getItems().addAll((Object[])listObject);
        strategy.getItems().addAll((Object[])listStrategy);
        PlanList.addAll(planService.findAll());
        PlanListFilter.addAll(PlanList);
        tableView.setItems(PlanListFilter);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Plan>() {
            @Override
            public void changed(ObservableValue<? extends Plan> observable, Plan oldValue, Plan newValue) {
                selected=newValue;
                backapp.BackApp.planInProc = selected;
                System.out.println("Selected item: " + newValue);
            }
        });
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        PlanList.addListener(new ListChangeListener<Plan>(){
            @Override
           public void onChanged(ListChangeListener.Change<? extends Plan> change){
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
        int id = (int) (Math.random()*1000);
        Plan b = new Plan(id,true,"script.bat",object.getValue().toString(),name.getText(),type.getValue().toString(),method.getValue().toString(),strategy.getValue().toString(),s_repertory.getText(),d_repertory.getText(),log.getText(),sid.getValue().toString());
        if(entete.getText().equals("Enregistrement")){
            planService.create(b);
            PlanList.add(b);
            Notification.notifySuccess("Enregistrement avec succès", "La planification été bien enregistrée");
        }else{
            b.setId(selected.getId());
            planService.update(b);
           int index = PlanList.indexOf(selected);
           PlanList.set(index, b);
           Notification.notifySuccess("Modification avec succès", "La planification été bien modifiée");
        }
    }
    
    @FXML
    private void annuler(ActionEvent event) {
        System.out.println("You clicked me!");
        type.setValue(null);method.setValue(null);object.setValue(null);name.clear();strategy.setValue(null);s_repertory.clear();d_repertory.clear();log.clear();
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            CronService cronService = new CronService();
            cronService.deleteByPlan(selected.getId());
            planService.delete(selected);
            tableView.getItems().remove(selected);
            Notification.notifyNotice("Suppression effectuée", "La planification a été supprimée avec ses déclenchements");
        }  
    }
    
    @FXML
    private void modifier(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            //hostService.delete(selected);
            entete.setText("Modification SID:"+selected.getId());
            sid.setValue(selected.getHost());
            type.setValue(selected.getType());
            method.setValue(selected.getMethod());
            object.setValue(selected.getObject());
            name.setText(selected.getName());
            strategy.setValue(selected.getStrategy());
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
    
    private void updateFilteredData(){
        PlanListFilter.clear();
        for(Plan h : PlanList){
            if(matchesFilter(h)){
                PlanListFilter.add(h);
            }
        }
        ArrayList<TableColumn<Plan,?>> sortOrder = new ArrayList<>(tableView.getSortOrder());
        tableView.getSortOrder().clear();
        tableView.getSortOrder().addAll(sortOrder);
    }

    private boolean matchesFilter(Plan h) {
        String filterString = filter.getText();
        if((filterString == null)||filterString.isEmpty()){
            return true;
        }
        String lowerCaseFilterString = filterString.toLowerCase();
        if(h.toString().toLowerCase().contains(lowerCaseFilterString)){
            return true;
        }
        return false;
    }
}
