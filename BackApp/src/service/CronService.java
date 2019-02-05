/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CronDao;
import java.text.ParseException;
import java.util.List;
import model.Cron;
import model.Plan;

/**
 *
 * @author thomas
 */
public class CronService {
    private CronDao cronDao;
    
    public CronService(){
        cronDao = new CronDao();
    }
    
    public List<Cron> findAll(){
        return cronDao.findAll();
    }
    
    public Cron find(int sid){
        return cronDao.find(sid);
    }
    
    public boolean create(Plan h, Cron p){
        return cronDao.create(p);
    }
    
    public boolean update(Cron h){
        return cronDao.update(h);
    }
    
     public boolean delete(Cron h){
        return cronDao.delete(h);
    }
    
}
