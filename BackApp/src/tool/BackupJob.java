/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import model.Backup;
import model.Host;
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
        Backup b = (Backup)jobDataMap.get("backup");
        BackupService backupService = new BackupService();
        backupService.create(h, b);
        System.out.println("Execution de mon job");
    }
}
