/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import model.Backup;
import model.Cron;
import model.Host;
import model.Plan;
import org.quartz.CronExpression;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 *
 * @author thomas
 */
public class Planificateur {
    
    static SchedulerFactory factory = new StdSchedulerFactory();
    
    public static void plan(Host host, Plan plan) throws ParseException{      
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.start();
            Iterator<Cron> it = plan.getCrons().iterator();
            while(it.hasNext()){
                Cron cron = it.next();
                final JobDetailImpl jobDetail = new JobDetailImpl();
                jobDetail.setName("Mon job");
                jobDetail.setJobClass(BackupJob.class);
                Backup backup = new Backup();
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("backup", backup);
                jobDataMap.put("host", host);
                jobDetail.setJobDataMap(jobDataMap);
                final CronTriggerImpl cronTrigger = new CronTriggerImpl();
                cronTrigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
                String cronExpression = CronConvert.toString(cron);
                cronTrigger.setCronExpression(cronExpression);
                cronTrigger.setName("Trigger execution toutes les 5 secondes");
                scheduler.scheduleJob(jobDetail, cronTrigger);
            }
            System.in.read();
            if (scheduler != null) {
                scheduler.shutdown();
            }
        } catch (final SchedulerException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
