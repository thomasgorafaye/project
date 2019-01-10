/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BackupDao;
import java.util.List;
import model.Backup;

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
    
    public Backup find(String sid){
        return backupDao.find(sid);
    }
    
    public boolean create(Backup h){
        return backupDao.create(h);
    }
    
    public boolean update(Backup h){
        return backupDao.update(h);
    }
    
     public boolean delete(Backup h){
        return backupDao.delete(h);
    }
    
}
