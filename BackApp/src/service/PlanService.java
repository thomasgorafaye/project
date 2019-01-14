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
import tool.Planificateur;

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
    
    public boolean create(Host h, Plan p){
        try {
            Planificateur.plan(h, p);
        } catch (ParseException ex) {
            Logger.getLogger(PlanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return planDao.create(p);
    }
    
    public boolean update(Plan h){
        return planDao.update(h);
    }
    
     public boolean delete(Plan h){
        return planDao.delete(h);
    }
    
}
