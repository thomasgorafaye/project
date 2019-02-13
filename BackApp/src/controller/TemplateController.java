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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Listcron.fxml"));
    	AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
			anchorPane.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    } 
    
    
    @FXML
    private void Createbackup(ActionEvent event) throws IOException { changeScreen("/view/Createbackup.fxml");}
    
    @FXML
    private void Listbackup(ActionEvent event) throws IOException { changeScreen("/view/Listbackup.fxml");}
    
    @FXML
    private void Createplan(ActionEvent event) throws IOException { changeScreen("/view/Createplan.fxml");}
    
    @FXML
    private void Listplan(ActionEvent event) throws IOException { changeScreen("/view/Listplan.fxml");}
    
    @FXML
    private void Createhost(ActionEvent event) throws IOException { changeScreen("/view/Createhost.fxml");}
    
    @FXML
    private void Listhost(ActionEvent event) throws IOException { changeScreen("/view/Listhost.fxml");}
    
    
    private void changeScreen(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
    	AnchorPane cmdPane;
		try {
			cmdPane = (AnchorPane) fxmlLoader.load();
                        anchorPane.getChildren().remove(0);
			anchorPane.getChildren().add(cmdPane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
}
