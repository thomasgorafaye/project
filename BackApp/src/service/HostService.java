/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HostDao;
import java.util.List;
import model.Host;

/**
 *
 * @author thomas
 */
public class HostService {
    
    private HostDao hostDao;
    
    public HostService(){
        hostDao = new HostDao();
    }
    
    public List<Host> findAll(){
        return hostDao.findAll();
    }
    
    public Host find(String sid){
        return hostDao.find(sid);
    }
    
    public List<String> findAllSid(){
        return hostDao.findAllSid();
    }
    
    public boolean create(Host h){
        return hostDao.create(h);
    }
    
    public boolean update(Host h){
        return hostDao.update(h);
    }
    
     public boolean delete(Host h){
        return hostDao.delete(h);
    }
     
     public long getTotal(){
        return hostDao.getTotal();
    }
    
}
