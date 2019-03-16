/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PlanDao;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Host;
import model.Plan;
import backapp.BackApp;

/**
 *
 * @author thomas
 */
public class PlanService {
    
    private PlanDao planDao;
    
    public PlanService(){
        planDao = new PlanDao();
    }
    
    public List<Plan> findAll(){
        return planDao.findAll();
    }
    
    public Plan find(int sid){
        return planDao.find(sid);
    }
    
    public boolean create(Plan p){
        BackApp.planInProc = p;
        return planDao.create(p);
    }
    
    public boolean update(Plan h){
        return planDao.update(h);
    }
    
     public boolean delete(Plan h){
        return planDao.delete(h);
    }
     
    public boolean deleteByHost(String host){
        return planDao.deleteByHost(host);
    }
     
     public int getTotal(){
        return planDao.getTotal();
    }
    
}
