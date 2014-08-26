/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcompany;
import java.sql.*;

/**
 *
 * @author user
 */
public class DBConnection {
    
    public static Connection con;
    
    public DBConnection(String filename)
    {
        try{
            sun.jdbc.odbc.JdbcOdbcDriver db1 = new sun.jdbc.odbc.JdbcOdbcDriver();
            String username = "";
            String password = "";
            String connectionString;
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
            database+= filename.trim() + ";DriverID=22;READONLY=true}";
            connectionString = database;
            con = DriverManager.getConnection(connectionString, username, password);
        }
        catch(Exception e){
            // Display error message
            System.err.println("\tError: " + e);
        }
    }
    
    public void terminateConnection ()
    {
        try{
        con.close();
        }
        catch (Exception e)
        {
            System.err.println("\tError: " + e);
        }
    }
}
