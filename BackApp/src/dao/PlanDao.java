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
            Plan h =  new Plan(rs.getInt(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
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
    
    public Plan find(int id){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Plan where id = "+id; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Plan h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Plan(rs.getInt(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));      
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
         String sql = "INSERT INTO Plan " + "VALUES("+h.getId()+","+h.isActive()+",'"+h.getScript()+"','"+h.getObject()+"','"+h.getName()+"','"+h.getType()+"','"+h.getMethod()+"','"+h.getStrategy()+"','"+h.getS_repertory()+"','"+h.getD_repertory()+"','"+h.getLog()+"','"+h.getHost()+"')"; 
         
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
         String sql = "Update Plan " + "Set active="+h.isActive()+", script='"+h.getScript()+"', object='"+h.getObject()+"', name='"+h.getName()+"', type='"+h.getType()+"', method='"+h.getMethod()+"', strategy='"+h.getStrategy()+"', s_repertory='"+h.getS_repertory()+"', d_repertory='"+h.getD_repertory()+"', log='"+h.getLog()+"', host='"+h.getHost()+"' where id="+h.getId()+""; 
         
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
     
    public boolean deleteByHost(String host){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Plan " + "where host='"+host+"'"; 
         
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
    
     public Plan findByHost(String sid){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Plan where host = '"+sid+"'"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Plan h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Plan(rs.getInt(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));      
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
    
    public int getTotal(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT count(*) FROM Plan"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set
         rs.next();
         int result = rs.getInt(1);
         // STEP 5: Clean-up environment 
         rs.close(); 
         System.out.println("Find Total..."); 
         
         closeConnection();
         return result;
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         closeConnection();
      } //end try  
        return 0;
    }
}
