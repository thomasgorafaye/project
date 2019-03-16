/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
            Backup h = new Backup(rs.getLong(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getInt(15)); 
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
            h = new Backup(rs.getLong(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getInt(15));      
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
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Backup " + "VALUES("+h.getTimestamp()+",CURRENT_DATE(),'"+h.getTime()+"','"+h.getType()+"','"+h.getMethod()+"','"+h.getObject()+"','"+h.getName()+"','"+h.getStrategy()+"','"+h.getS_repertory()+"','"+h.getD_repertory()+"','"+h.getLog()+"',"+h.isSuccess()+","+h.isPlanned()+",'"+h.getHost()+"',"+h.getPlan()+")"; 
         
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
         String sql = "Update Backup " + "Set date='"+h.getDate()+"', time='"+h.getTime()+"', type='"+h.getType()+"', method='"+h.getMethod()+"', object='"+h.getObject()+"', name='"+h.getName()+"', strategy='"+h.getStrategy()+"', s_repertory='"+h.getS_repertory()+"', d_repertory='"+h.getD_repertory()+"', log='"+h.getLog()+"', success="+h.isSuccess()+", planned="+h.isPlanned()+" where timestamp="+h.getTimestamp()+""; 
         
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
            h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getInt(15));      
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
            h = new Backup(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getInt(15));      
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
         String sql = "SELECT count(*) FROM Backup"; 
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
    
    public int getTotalSuccess(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT count(*) FROM Backup where success=true"; 
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
    
    public int getTotalPlanned(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT count(*) FROM Backup where planned=true"; 
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
    
    public List<Backup> getTotalGroupby(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT method,success,planned,type,count(*) FROM Backup group by method,success,planned,type order by method,success,planned,type"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Backup> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Backup h = new Backup();
            h.setMethod(rs.getString(1));
            h.setSuccess(rs.getBoolean(2));
            h.setPlanned(rs.getBoolean(3));
            h.setType(rs.getString(4));
            h.setTimestamp(rs.getLong(5));
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
}
