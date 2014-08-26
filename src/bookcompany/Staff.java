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
public class Staff extends Person {
    private String Position;
    private Double Salary;
    
    public void setPosition(String p)
    {
        Position = p;
    }
    
    public void setSalary(double s)
    {
        Salary = s;
    }
    
    public String getPosition()
    {
        return Position;
    }
    
    public double getSalary()
    {
        return Salary;
    }
    
    public String add(Connection con)
    {
        try {
            Statement S = con.createStatement();
            int n = 0;
            
            String Query = "INSERT INTO Person (FName, LName, Age) VALUES ('" + getFName() + "', '"+ getLName() + "', "+ getAge() + ")";
            S.executeUpdate(Query);
            
            Query = "SELECT ID FROM PERSON";
            ResultSet rs = S.executeQuery(Query);
            
            while (rs.next()){
               n = rs.getInt("ID");
            }
            
            Query = "INSERT INTO Staff VALUES ('" + Position + "', '"+ Salary + "' ," + n +")";
            S.executeUpdate(Query);
            
            return "The Staff Has Been Added";
            
       }catch (Exception e)
       {
           String Error = "Error " + e;
           return Error;
       }
        
    }
    
    
    public String update(Connection con)
    {
        try {
            Statement S = con.createStatement();
            String Query;
            
            Query = "UPDATE Person SET FName = '" + getFName() + "', LName = '" + getLName() + "', Age = " + getAge()+ " WHERE ID = " + getID() ;
            S.executeUpdate(Query);    
            
            Query = "UPDATE Staff SET Position = '" + Position + "', Salary = " + Salary + " WHERE ID = " + getID() ;
            S.executeUpdate(Query);
            
            return "The Record Was Updated";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
    
    
    public String find(Connection con)
    { 
        try {
            Statement S = con.createStatement();
            String Query;
            ResultSet rs;
        
            Query = "SELECT * FROM Person WHERE ID = " + getID() + " ;" ;
            rs = S.executeQuery(Query);    
            while (rs.next())
            {
                setFName(rs.getString("FName"));
                setLName(rs.getString("LName"));
                setAge(rs.getInt("Age"));
            }
            
            
            Query = "SELECT * FROM Staff WHERE ID = " +getID() ;
            rs = S.executeQuery(Query);
            while (rs.next())
            {
                Position = rs.getString("Position");
                Salary = rs.getDouble("Salary");
            }
            
            return "The Above Record Was Found";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
    
    
    public String delete(Connection con)
    {
        try {
            Statement S = con.createStatement();
            String Query;
            
            Query = "DELETE FROM Staff WHERE ID = " + getID();
            S.executeUpdate(Query);    
           
            Query = "DELETE FROM Person WHERE ID = " + getID();
            S.executeUpdate(Query);
            
            return "The Record Was Deleted";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
   
}
