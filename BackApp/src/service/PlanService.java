/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PlanDao;
import java.util.List;
import model.Plan;

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
    
    public Plan find(String sid){
        return planDao.find(sid);
    }
    
    public boolean create(Plan h){
        return planDao.create(h);
    }
    
    public boolean update(Plan h){
        return planDao.update(h);
    }
    
     public boolean delete(Plan h){
        return planDao.delete(h);
    }
    
}
