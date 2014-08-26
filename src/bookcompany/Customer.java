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
public class Customer extends Person {
    
    private String Address;
    private String Phone;
   
    public void setAddress(String ad)
    {
        Address = ad;
    }
    
    public void setPhone(String ph)
    {
        Phone = ph;
    }
    
    public String getAddress()
    {
        return Address ;
    }
    
    public String getPhone()
    {
        return Phone;
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
            
            Query = "INSERT INTO Customer VALUES ('" + Address + "', '"+ Phone + "' ," + n +")";
            S.executeUpdate(Query);
            
            return "The Customer Has Been Added";
            
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
            
            Query = "UPDATE Customer SET Address = '" + Address + "', Phone = '" + Phone + "' WHERE ID = " + getID() ;
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
            
            Query = "SELECT * FROM Customer WHERE ID = " +getID() ;
            rs = S.executeQuery(Query);
            while (rs.next())
            {
                Address = rs.getString("Address");
                Phone = rs.getString("Phone");
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
            
            Query = "DELETE FROM Customer WHERE ID = " + getID();
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
   
    public void createNewOrder()
           {;}
    public void showAllOrders()
           {;}
}
