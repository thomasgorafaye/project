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
import model.Cron;

/**
 *
 * @author thomas
 */
public class CronDao extends Dao {
    
    public CronDao(){
        
    }
    
    public List<Cron> findAll(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Cron"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Cron> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Cron h =  new Cron(rs.getInt(1),rs.getString(2),rs.getBoolean(2));
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
    
    public Cron find(int id){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Cron where id = "+id; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Cron h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h =  new Cron(rs.getInt(1),rs.getString(2),rs.getBoolean(2));
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
    
    public boolean create(Cron h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Cron " + "VALUES("+h.getId()+",'"+h.getExpression()+"',"+h.isActive()+","+h.getPlan()+")";
         
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
    
    public boolean update(Cron h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Update Plan " + "Set active="+h.isActive()+" and expression='"+h.getExpression()+"' where id="+h.getId()+""; 
         
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
    
     public boolean delete(Cron h){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Cron " + "where id='"+h.getId()+"'"; 
         
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
    
     public Cron findByPlan(String sid){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Cron where plan = "+sid+""; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Cron h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Cron(rs.getInt(1),rs.getString(2),rs.getBoolean(2));
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
}
