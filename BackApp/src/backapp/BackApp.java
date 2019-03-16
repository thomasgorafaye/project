/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backapp;

import dao.Dao;
import java.util.ArrayList;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Host;
import model.Plan;
import org.apache.log4j.PropertyConfigurator;
import tool.Mail;

/**
 *
 * @author thomas
 */
public class BackApp extends Application {
    
    public static ArrayList<Integer> tabPreviousCurrent = new ArrayList<Integer>();
    public static Plan planInProc;
    
    @Override
    public void start(Stage stage) throws Exception {
      
        String log4jConfPath = "C:\\Users\\thomas\\Documents\\NetBeansProjects\\project\\BackApp\\src\\properties\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        
        Dao dao = new Dao();
        dao.init();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Template.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("BackApp");    
        //stage.getIcons().add(new Image("/image/imagesE1BJM8VZ.jpg"));
        stage.getIcons().add(new Image("/image/database-backup-icon-512.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
