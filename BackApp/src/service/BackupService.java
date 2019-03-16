/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BackupDao;
import java.util.List;
import model.Backup;
import model.Host;
import tool.CheckArchiveLog;
import tool.Notification;
import tool.Script;

/**
 *
 * @author thomas
 */
public class BackupService {
    
    private BackupDao backupDao;
    
    public BackupService(){
        backupDao = new BackupDao();
    }
    
    public List<Backup> findAll(){
        return backupDao.findAll();
    }
    
    public Backup find(long sid){
        return backupDao.find(sid);
    }
    
    public int create(Host h, Backup b){
        CheckArchiveLog archive = new CheckArchiveLog();
        int result = archive.check(h);
        if((result ==0)||((result==2)&&(b.getMethod().contains("Export")||(b.getMethod().contains("Xcopy")&&b.getType().contains("froid"))))){
            Script script = new Script();
            script.run(h,b);
        }    
        else{
            b.setSuccess(false);
        }
        String path = b.getLog();
        long timestamp = b.getTimestamp();
        String log;
        if(b.getMethod().contains("Export")){
            log = path + "\\export_full.log";
            b.setLog(log);
        }        
        backupDao.create(b);
        return result;
    }
    
    public boolean update(Backup h){
        return backupDao.update(h);
    }
    
     public boolean delete(Backup h){
        return backupDao.delete(h);
    }
    
    public int getTotal(){
        return backupDao.getTotal();
    }
    
    public int getTotalSuccess(){
        return backupDao.getTotalSuccess();
    }
    
    public int getTotalPlanned(){
        return backupDao.getTotalPlanned();
    }
    
    public List<Backup> getTotalGroupBy(){
        return backupDao.getTotalGroupby();
    }
}
