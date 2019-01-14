/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import model.Cron;
import model.Elements;

/**
 *
 * @author thomas
 */
public class CronConvert {
    
    public static String toString(Cron cron){
        return "* */5 * * * ?";
    }
    
    public static Elements toElements(Cron cron){
        return null;
    }
    
}
