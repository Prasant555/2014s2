/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookcompany;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author user
 */
public class Order {
    private int OrderNumber;
    private String OrderDateTime;
    private double totalCost;
    private int CustomerID;
    private int StaffID;
    
    
    public Order()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        OrderDateTime = dateFormat.format(date);
    }
    
    public void setOrderNumber(int a)
    {
        OrderNumber = a;
    }
    
    public void setTotalcost(double a)
    {
        totalCost = a;
    }
    
    public void setCustomerID(int a)
    {
        CustomerID = a;
    }
    
    public String getDate()
    {
        return OrderDateTime;
    }
    
    public int getOrderNumber()
    {
        return OrderNumber;
    }
    
    public Double getTotalcost()
    {
        return totalCost;
    }
    
    public int getCustomerID()
    {
        return CustomerID;
    }
    
    public String addOrder(Connection con)
    {
        try {
            Statement S = con.createStatement();
            int n = 0;
            
            String Query = "INSERT INTO Order (CustomerID, OrderDate) VALUES(" + CustomerID +" '" + OrderDateTime + "')" ;
            S.executeUpdate(Query);
            
            Query = "SELECT OrderNumber FROM Order1 WHERE CustomerID = " + CustomerID ;
            ResultSet rs = S.executeQuery(Query);
            
            while (rs.next())
            {
                OrderNumber = Integer.parseInt(rs.getString("OrderNumber"));
            }
            
            return "The Order Has Been Added";
            
       }catch (Exception e)
       {
           String Error = "Error " + e;
           return Error;
       }
    }
    
    public String updateOrder(Connection con)
    {
        try {
            Statement S = con.createStatement();
            int n = 0;
            
            String Query = "INSERT INTO Order1 (CustomerID, OrderDate) VALUES(" + CustomerID +" '" + OrderDateTime + "')" ;
            S.executeUpdate(Query);
            
            Query = "SELECT OrderNumber FROM Order1 WHERE CustomerID = " + CustomerID ;
            ResultSet rs = S.executeQuery(Query);
            
            while (rs.next())
            {
                OrderNumber = Integer.parseInt(rs.getString("OrderNumber"));
            }
            
            return "The Order Has Been Added";
            
       }catch (Exception e)
       {
           String Error = "Error " + e;
           return Error;
       }
    }
     
    public void findOrder(){;}
    public void getOrderList(){;}
    public void deleteOrder(){;}
    public void calculateTotalCost(){;}
    public void exportSalesData(){;}
    
}
