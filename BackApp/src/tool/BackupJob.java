/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.util.Date;
import model.Backup;
import model.Host;
import model.Plan;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import service.BackupService;

/**
 *
 * @author thomas
 */
public class BackupJob implements Job {

    @Override
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        Host h = (Host)jobDataMap.get("host");
        Plan p = (Plan)jobDataMap.get("plan");
        Date date = new Date();
        String time = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        Backup b = new Backup(date.getTime(),date,time,p.getType(),p.getMethod(),p.getObject(),p.getName(),p.getStrategy(),p.getS_repertory(),p.getD_repertory(),p.getLog(),false,true,h.getSid(),p.getId());
        System.out.println("Execution de mon job");
        BackupService backupService = new BackupService();
        backupService.create(h, b);
        System.out.println("Envoi de l'email");
        Mail mail = new Mail(h,b,p);
        mail.envoyerMailSMTP(h.getEmail());
        
    }
}
