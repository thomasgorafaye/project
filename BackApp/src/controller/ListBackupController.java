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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.Backup;
import model.Host;
import service.BackupService;

/**
 *
 * @author thomas
 */
public class ListBackupController implements Initializable {
    
    @FXML
    private TextField filter;
    
    @FXML 
    private TableView tableView;
    
    private BackupService backupService;
    
    private final String listType[] = {"Sauvegarde à chaud","Sauvegarde à froid"};
    private final String listMethod[] = {"Xcopy","Rman","Import/Export"};
    private final String listObject[] = {"database","schema","user","tablespace","table"};
    private final String listStrategy[] = {"Saugarde complète","Full sauvegarde","Différentielle niveau 0","Cumulative niveau 0","Différentielle niveau 1","Cumulative niveau 1","Différentielle niveau 2","Cumulative niveau 2"};
    
    private ObservableList<Backup> BackupList = FXCollections.observableArrayList();
    private ObservableList<Backup> BackupListFilter = FXCollections.observableArrayList();
    
    private Backup selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       backupService = new BackupService();
        BackupList.addAll(backupService.findAll());
        BackupListFilter.addAll(BackupList);
        tableView.setItems(BackupListFilter);
        //planned.setCellFactory(CheckBoxTableCell.forTableColumn(planned));    //it works fine
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Backup>() {
            @Override
            public void changed(ObservableValue<? extends Backup> observable, Backup oldValue, Backup newValue) {
                selected=newValue;
                System.out.println("Selected item: " + newValue);
            }
        });
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        BackupList.addListener(new ListChangeListener<Backup>(){
            @Override
           public void onChanged(ListChangeListener.Change<? extends Backup> change){
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
    private void supprimer(ActionEvent event) {
        System.out.println("You clicked me!");
        if(selected != null){
            backupService.delete(selected);
            backupService.delete(selected);
            tableView.getItems().remove(selected);
        }  
    }
    
    private void updateFilteredData(){
        BackupListFilter.clear();
        for(Backup h : BackupList){
            if(matchesFilter(h)){
                BackupListFilter.add(h);
            }
        }
        ArrayList<TableColumn<Backup,?>> sortOrder = new ArrayList<>(tableView.getSortOrder());
        tableView.getSortOrder().clear();
        tableView.getSortOrder().addAll(sortOrder);
    }

    private boolean matchesFilter(Backup h) {
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
