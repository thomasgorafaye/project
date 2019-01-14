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
import model.Backup;

/**
 *
 * @author thomas
 */
public class BackupDao extends Dao {
    
    public BackupDao(){
        
    }
    
    public List<Backup> findAll(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Backup"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Backup> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Backup h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13)); 
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
    
    public Backup find(long timestamp){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Backup where timestamp = "+timestamp; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Backup h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13));      
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
    
    public boolean create(Backup h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Backup " + "VALUES('"+h.getTimestamp()+"','"+h.getDate()+"','"+h.getTime()+"','"+h.getType()+"','"+h.getMethod()+"','"+h.getObject()+"','"+h.getName()+"','"+h.getStrategy()+"','"+h.getD_repertory()+"','"+h.getLog()+"',"+h.isSuccess()+","+h.isPlanned()+",'"+h.getHost()+"',"+h.getPlan()+")"; 
         
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
    
    public boolean update(Backup h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Update Backup " + "Set date='"+h.getDate()+"' and time='"+h.getTime()+"' and type='"+h.getType()+"' and method='"+h.getMethod()+"' and object='"+h.getObject()+"' and name='"+h.getName()+"' and strategy='"+h.getStrategy()+"' and s_repertory='"+h.getS_repertory()+"' and d_repertory='"+h.getD_repertory()+"' and log='"+h.getLog()+"' and success="+h.isSuccess()+" planned="+h.isPlanned()+" where timestamp="+h.getTimestamp()+""; 
         
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
    
     public boolean delete(Backup h){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Backup " + "where timestamp="+h.getTimestamp()+""; 
         
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
     
     public Backup findByHost(String sid){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Backup where host = '"+sid+"'"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Backup h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13));      
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
     
    public Backup findByPlan(int id){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Backup where plan = "+id; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Backup h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13));      
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
