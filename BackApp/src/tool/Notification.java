/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author thomas
 */
public class Notification {
    
    public static void notifySuccess(String title, String message){
        NotificationType notification = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification(title,message,notification);
        tray.showAndDismiss(Duration.seconds(5));
    }
    
    public static void notifyNotice(String title, String message){
        NotificationType notification = NotificationType.INFORMATION;
        TrayNotification tray = new TrayNotification(title,message,notification);
        tray.showAndDismiss(Duration.seconds(5));
    }
    
    public static void notifyError(String title, String message){
        NotificationType notification = NotificationType.ERROR;
        TrayNotification tray = new TrayNotification(title,message,notification);
        tray.showAndDismiss(Duration.seconds(5));
    }
    
}
