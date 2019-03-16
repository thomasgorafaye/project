/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VariantDao;
import java.util.List;
import model.Variant;

/**
 *
 * @author thomas
 */
public class VariantService {
    
    private VariantDao variantDao;
    
    public VariantService(){
        variantDao = new VariantDao();
    }
    
    public List<Variant> findAll(){
        return variantDao.findAll();
    }
    
    public Variant find(int id){
        return variantDao.find(id);
    }
    
    public boolean create(Variant h){
        return variantDao.create(h);
    }
    
    public boolean update(Variant h){
        return variantDao.update(h);
    }
    
     public boolean delete(Variant h){
        return variantDao.delete(h);
    }
    
}
