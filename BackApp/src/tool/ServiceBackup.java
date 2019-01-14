/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Iterator;
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
                Planificateur.plan(host, plan);
            }
        }
        
    }
}
