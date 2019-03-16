/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.text.ParseException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cron;
import model.Host;
import model.Plan;
import service.HostService;

/**
 *
 * @author thomas
 */
public class ServiceBackup {
    
    public void loadPlan(){
        HostService hostService = new HostService();
        Iterator<Host> itHost = hostService.findAll().iterator();
        while(itHost.hasNext()){
            Host host = itHost.next();
            Iterator<Plan> itPlan = host.getPlans().iterator();
            while(itPlan.hasNext()){
                Plan plan = itPlan.next();
                Iterator<Cron> itCron = plan.getCrons().iterator();
                while(itPlan.hasNext()){
                    Cron cron = itCron.next();
                    try {
                        Planificateur.plan(host, plan, cron);
                    } catch (ParseException ex) {
                        Logger.getLogger(ServiceBackup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
            }
        }
        
    }
}
