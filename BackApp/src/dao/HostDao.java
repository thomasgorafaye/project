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
import model.Host;

/**
 *
 * @author thomas
 */
public class HostDao extends Dao {
    
    public HostDao(){
        
    }
    
    public List<Host> findAll(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Host"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Host> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Host h = new Host(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
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
    
    public Host find(String sid){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Host where sid = '"+sid+"'"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Host h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Host(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));      
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
    
    public boolean create(Host h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Host " + "VALUES('"+h.getSid()+"','"+h.getHostname()+"','"+h.getOwnername()+"','"+h.getEmail()+"','"+h.getOsname()+"','"+h.getOsuser()+"','"+h.getOspassword()+"','"+h.getDbuser()+"','"+h.getDbpassword()+"','"+h.getVersion()+"')"; 
         
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
    
    public boolean update(Host h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Update Host " + "Set hostname='"+h.getHostname()+"' and ownername='"+h.getOwnername()+"' and email='"+h.getEmail()+"' and osname='"+h.getOsname()+"' and osuser='"+h.getOsuser()+"' and ospassword='"+h.getOspassword()+"' and dbuser='"+h.getDbuser()+"' and dbpassword='"+h.getDbpassword()+"' and version='"+h.getVersion()+"' where sid='"+h.getSid()+"'"; 
         
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
    
     public boolean delete(Host h){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Host " + "where sid='"+h.getSid()+"'"; 
         
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
