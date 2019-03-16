/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 *
 * @author thomas
 */
public class FluxController extends OutputStream implements Initializable {

    @FXML
    private TextArea textField;
    
    @Override
    public void write(int b) throws IOException {
        appendText(String.valueOf((char)b));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.setOut(new PrintStream(this,true));
    }
    
    public void appendText(String str){
        Platform.runLater(()->textField.appendText(str));
    }
    
}
