/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import backapp.BackApp;
import dao.CronDao;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cron;
import model.Host;
import model.Plan;
import tool.Planificateur;

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
    
    public List<Cron> findByPlan(int plan){
        return cronDao.findByPlan(plan);
    }
    
    public boolean create(Host h, Plan p, Cron c){
        try {
            Planificateur.plan(h, p, c);
        } catch (ParseException ex) {
            Logger.getLogger(CronService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cronDao.create(c);
    }
    
    public boolean update(Cron h){
        return cronDao.update(h);
    }
    
     public boolean delete(Cron h){
        return cronDao.delete(h);
    }
     
    public boolean deleteByPlan(int plan){
        return cronDao.deleteByPlan(plan);
    }
    
    public int getTotal(){
        return cronDao.getTotal();
    }
    
}
