/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Plan;

/**
 *
 * @author thomas
 */
public class PlanDao extends Dao {
    
    public PlanDao(){
        
    }
    
    public List<Plan> findAll(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Plan"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Plan> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Plan h =  new Plan(rs.getInt(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
            list.add(h);       
      
         } 
         // STEP 5: Clean-up environment 
         rs.close(); 
         System.out.println("Find all in database..."); 
         
         closeConnection();
         return list;
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try  
        return null;
    }
    
    public Plan find(String sid){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Plan where sid = "+sid; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Plan h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Plan(rs.getInt(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));      
         } 
         
         // STEP 5: Clean-up environment 
         rs.close(); 
         System.out.println("Find one in database..."); 
         
         closeConnection();
         return h;
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try  
        return null;
    }
    
    public boolean create(Plan h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Plan " + "VALUES('"+h.getSid()+"','"+h.getPlanname()+"','"+h.getOwnername()+"','"+h.getEmail()+"','"+h.getOsuser()+"','"+h.getOspassword()+"','"+h.getDbuser()+"','"+h.getDbpassword()+"','"+h.getVersion()+"')"; 
         
         stmt.executeUpdate(sql); 
         System.out.println("Inserted records into the table..."); 
         
         closeConnection();
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try
        return false;
    }
    
    public boolean update(Plan h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Update Plan " + "Set planname='"+h.getPlanname()+"' and ownername='"+h.getOwnername()+"' and email='"+h.getEmail()+"' and osuser='"+h.getOsuser()+"' and ospassword='"+h.getOspassword()+"' and dbuser='"+h.getDbuser()+"' and dbpassword='"+h.getDbpassword()+"' and version='"+h.getVersion()+"' where sid='"+h.getSid()+"'"; 
         
         stmt.executeUpdate(sql); 
         System.out.println("Updated records into the table..."); 
         
         closeConnection();
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try
        return false;
    }
    
     public boolean delete(Plan h){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Plan " + "where id='"+h.getId()+"'"; 
         
         stmt.executeUpdate(sql); 
         System.out.println("Deleted records into the table..."); 
         
         closeConnection();
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try
        return false;
    }
    
}
