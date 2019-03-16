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
    
    final static SchedulerFactory factory = new StdSchedulerFactory();
    private static Scheduler scheduler = null;
    
    public static void plan(Host host, Plan plan, Cron cron) throws ParseException{    
        try {
            if (scheduler == null) {
                scheduler = factory.getScheduler();
                scheduler.start();
            }
                final JobDetailImpl jobDetail = new JobDetailImpl();
                jobDetail.setName("Mon job");
                jobDetail.setJobClass(BackupJob.class);
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("plan", plan);
                jobDataMap.put("host", host);
                jobDetail.setJobDataMap(jobDataMap);
                final CronTriggerImpl cronTrigger = new CronTriggerImpl();
                cronTrigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
                //cronTrigger.setCronExpression(cron.getExpression());
                cronTrigger.setCronExpression("0 0/2 * * * ?");
                cronTrigger.setName("Trigger execution toutes les 5 secondes");
                /*final SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
                simpleTrigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
                simpleTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
                simpleTrigger.setEndTime(new Date(System.currentTimeMillis() + 650000));
                simpleTrigger.setRepeatInterval(200000);
                simpleTrigger.setName("Trigger execution toutes les 4 minutes");*/
                scheduler.scheduleJob(jobDetail, cronTrigger);
            //System.in.read();
            if (scheduler != null) {
                //scheduler.shutdown();
            }
        } catch (final SchedulerException e) {
            e.printStackTrace();
        } /*catch (final IOException e) {
            e.printStackTrace();
        }*/
    }
}
