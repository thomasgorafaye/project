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
import model.Variant;

/**
 *
 * @author thomas
 */
public class VariantDao extends Dao{
    
    public VariantDao(){
        
    }
    
    public List<Variant> findAll(){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Variant"; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         List<Variant> list = new ArrayList();
         while(rs.next()) { 
            // Retrieve by column name 
            Variant h = new Variant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)); 
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
    
    public Variant find(int id){
           openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "SELECT * FROM Variant where id = "+id; 
         ResultSet rs = stmt.executeQuery(sql); 
         
         // STEP 4: Extract data from result set 
         Variant h = null;
         while(rs.next()) { 
            // Retrieve by column name 
            h = new Variant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)); 
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
    
    public boolean create(Variant h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "INSERT INTO Variant(type,method,object,name,strategy,s_repertory,d_repertory,log,description) " + "VALUES('"+h.getType()+"','"+h.getMethod()+"','"+h.getObject()+"','"+h.getName()+"','"+h.getStrategy()+"','"+h.getS_repertory()+"','"+h.getD_repertory()+"','"+h.getLog()+"','"+h.getDescription()+"')"; 
         
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
    
    public boolean update(Variant h){
        openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Update Variant " + "Set type='"+h.getType()+"' and method='"+h.getMethod()+"' and object='"+h.getObject()+"' and name='"+h.getName()+"' and strategy='"+h.getStrategy()+"' and s_repertory='"+h.getS_repertory()+"' and d_repertory='"+h.getD_repertory()+"' and log='"+h.getLog()+"' and description='"+h.getDescription()+"'"; 
         
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
    
     public boolean delete(Variant h){
         openConnection();
      try {
         //STEP 3: Execute a query 
         String sql = "Delete Variant " + "where id="+h.getId()+""; 
         
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
