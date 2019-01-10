/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thomas
 */
public class Dao {
     // JDBC driver name and database URL 
   final String JDBC_DRIVER = "org.h2.Driver";   
   final String DB_URL = "jdbc:h2:~/test";  
   
   //  Database credentials 
   final String USER = "sa"; 
   final String PASS = ""; 
   
   protected Connection conn; 
   protected Statement stmt; 
   
   public void openConnection(){
       try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
         stmt = conn.createStatement();
   } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      }
   }
   
   public void closeConnection(){
       //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
   }
  
   public void init() { 
      openConnection();
      try {
         //STEP 3: Execute a query 
         System.out.println("Creating tables in given database..."); 
         String sql =  "CREATE TABLE HOST " + 
            "(sid VARCHAR(255) not NULL, " + 
            " hostname VARCHAR(255), " +  
            " ownername VARCHAR(255), " +   
            " email VARCHAR(255), " + 
            " osuser VARCHAR(255), " + 
            " ospassword VARCHAR(255), " + 
            " dbuser VARCHAR(255), " + 
            " dbpassword VARCHAR(255), " + 
            " version VARCHAR(255), " + 
            " PRIMARY KEY ( sid ))";  
         stmt.executeUpdate(sql);
         stmt = conn.createStatement(); 
         sql =  "CREATE TABLE PLAN " + 
            "(id INTEGER not NULL, " + 
            " active BOOLEAN, " +  
            " script VARCHAR(255), " +   
            " object VARCHAR(255), " + 
            " name VARCHAR(255), " + 
            " type VARCHAR(255), " + 
            " method VARCHAR(255), " + 
            " strategy VARCHAR(255), " + 
            " s_repertory VARCHAR(255), " + 
            " d_repertory VARCHAR(255), " + 
            " log VARCHAR(255), " + 
            " host VARCHAR(255), " +
            " PRIMARY KEY ( id ))";  
         stmt.executeUpdate(sql);
         stmt = conn.createStatement(); 
         sql =  "CREATE TABLE BACKUP " + 
            "(timestamp INTEGER not NULL, " + 
            " date DATE, " +  
            " time VARCHAR(255), " +
            " type VARCHAR(255), " + 
            " method VARCHAR(255), " +
            " object VARCHAR(255), " + 
            " name VARCHAR(255), " + 
            " strategy VARCHAR(255), " + 
            " s_repertory VARCHAR(255), " + 
            " d_repertory VARCHAR(255), " + 
            " log VARCHAR(255), " + 
            " success BOOLEAN, " +
            " planned BOOLEAN, " +
            " host VARCHAR(255), " +
            " plan INTEGER, " +
            " PRIMARY KEY ( timestamp ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created tables in given database..."); 
         
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
   } 
}
