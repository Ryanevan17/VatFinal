/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import domainlayer.ShapeType;
import domainlayer.TableCollection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jnmkimpton
 */

public class DatabaseConnection {
    
    private Connection connection = null;
    private Statement statement = null;
    //private PreparedStatement preparedstatement = null;
    private ResultSet resultset = null;
    
    
    
    public boolean openConnection() {
        boolean result = false;

        if (connection == null) {
            try {
                // Try to create a connection with the library database
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/vat", "root", "");

                if (connection != null) {
                    statement = connection.createStatement();  
                    
         }

                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        } else {
            // A connection was already initalized.
            result = true;
        }

        return result;
    }  

    
    public boolean tableExists(String tablename) throws Exception
    {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection with DB
            // Localhost 
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
            
            boolean exists = false;
            
            DatabaseMetaData md = connection.getMetaData();
            resultset = md.getTables(null, null, tablename, null);
            while(resultset.next()) {
                exists = true;
            }
            
            return exists;
            
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public ArrayList readDatabase(String tablename) throws Exception {
        ArrayList shapes = new ArrayList<>();
        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection DB
            // Localhost 
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
            
            
            statement = connection.createStatement();
            
            // The result of SQL Query
            resultset = statement.executeQuery("select * from " + tablename);
            shapes = writeResultSet(resultset);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return shapes;
    }
    
    public void createTable(String tablename) throws Exception {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection with DB
            // Localhost 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
            
            // Statement allow to issue SQL queries to the DB
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tablename + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, shape VARCHAR(50) NOT NULL, property VARCHAR(255) NOT NULL)");          
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public void insertRecord(ShapeType type, String property, String tablename) throws Exception {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection with DB
            // Localhost 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
            
            
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO " + tablename + " (shape, property) VALUES ('" + type + "','" + property + "')");          
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public void deleteTabel(String tablename) throws Exception {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection with DB
            // Localhost 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
          
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE " + tablename);          
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    public void getAllTables(TableCollection tables) throws Exception {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Setup connection with DB
            // Localhost 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?user=root&password=");
            
            DatabaseMetaData md = connection.getMetaData();
            resultset = md.getTables(null, null, "%", null);
            while(resultset.next()) {
                tables.addTable(resultset.getString(3));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private ArrayList writeResultSet(ResultSet resultset) throws SQLException {
        ArrayList shapes = new ArrayList<>();
        // ResultSet is initially before the firste data set
        while(resultset.next()) {
            shapes.add(resultset.getString("shape") + " - " + resultset.getString("property"));
        }
        return shapes;
    }
    
    void close() {
        try { 
            if(resultset != null) {
                resultset.close();
            }
            
            if(statement != null) {
                statement.close();
            }
            
            if(connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            
        }
    }

    ResultSet executeSQLSelectStatement(String select__from_vat) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}