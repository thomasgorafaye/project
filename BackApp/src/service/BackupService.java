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
    
    public boolean create(Host h, Backup b){
        Script script = new Script();
        script.run(h,b);
        return backupDao.create(b);
    }
    
    public boolean update(Backup h){
        return backupDao.update(h);
    }
    
     public boolean delete(Backup h){
        return backupDao.delete(h);
    }
}
