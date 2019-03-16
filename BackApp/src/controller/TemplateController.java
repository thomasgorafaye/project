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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Host;
import service.HostService;

/**
 *
 * @author thomas
 */
public class TemplateController implements Initializable {
    
    @FXML 
    private Parent root;
    
    @FXML 
    private VBox anchorPane;
    
    @FXML
    private Button back,next;
    
    private ArrayList<Integer> tabPreviousCurrent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
    	AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
			anchorPane.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        tabPreviousCurrent = backapp.BackApp.tabPreviousCurrent;
        tabPreviousCurrent.add(0);
        tabPreviousCurrent.add(0);
        back.setDisable(true);
        next.setDisable(true);
    } 
    
    
    @FXML
    private void Dashboard(ActionEvent event) throws IOException { changeScreen("/view/Dashboard.fxml",0);}
    
    @FXML
    private void Createbackup(ActionEvent event) throws IOException { changeScreen("/view/Createbackup.fxml",1);}
    
    @FXML
    private void Listbackup(ActionEvent event) throws IOException { changeScreen("/view/Listbackup.fxml",2);}
    
    @FXML
    private void Createplan(ActionEvent event) throws IOException { changeScreen("/view/Createplan.fxml",3);}
    
    @FXML
    private void Listplan(ActionEvent event) throws IOException { changeScreen("/view/Listplan.fxml",4);}
    
    @FXML
    private void Createhost(ActionEvent event) throws IOException { changeScreen("/view/Createhost.fxml",5);}
    
    @FXML
    private void Listhost(ActionEvent event) throws IOException { changeScreen("/view/Listhost.fxml",6);}
    
    @FXML
    private void Back(ActionEvent event) throws IOException { if(tabPreviousCurrent.get(0)==3)
            changeScreen("/view/Createplan.fxml",3);
        if(tabPreviousCurrent.get(0)==4)
            changeScreen("/view/Listplan.fxml",4);
    }
    
    @FXML
    private void Listcron(ActionEvent event) throws IOException {
        if(backapp.BackApp.planInProc != null)
            changeScreen("/view/Listcron.fxml",7);
        else
            showErrorAlert("Choix manquant","Veuillez d'abord sélectionner une ligne.");
    }
    
    
    private void changeScreen(String name, int num) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
    	AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
                        anchorPane.getChildren().remove(0);
			anchorPane.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        tabPreviousCurrent.remove(0);
        tabPreviousCurrent.add(num);
        if(num==7)
            back.setDisable(false);
        else
            back.setDisable(true);
        if(num==4)
            next.setDisable(false);
        else
            next.setDisable(true);
    }
    
    private void showErrorAlert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    
}
