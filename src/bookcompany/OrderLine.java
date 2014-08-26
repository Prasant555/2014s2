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
public class OrderLine {
    private int orderNumber;
    private int orderLineNumber;
    private int Quantity;
    private String ISBN;
    
    public OrderLine()
    {
        
    }
    
    public void setOrderNumber(int a)
    {
        orderNumber = a;
    }
    
    public void setOrderLineNumber(int a)
    {
        orderLineNumber = a;
    }
    
    public void setQuantiy(int a)
    {
        Quantity = a;
    }
    
    public void setISBN(String a)
    {
        ISBN = a;
    }
    
    public int getOrderNumber()
    {
        return orderNumber;
    }
    
    public int getOrderLineNumber()
    {
        return orderLineNumber;
    }
    
    public int getQuantiy()
    {
        return Quantity;
    }
    
    public String getISBN()
    {
        return ISBN;
    }
    
    public String addOrderLine(Connection con)
    {
        try {
            Statement S = con.createStatement();
            int n = 0;
            
            String Query = "INSERT INTO OrderLine (OrderNumber, Quantity, ISBN) VALUES (" + orderNumber + ", " + Quantity + ", '" + ISBN + "')";
            S.executeUpdate(Query);
            
            return "The Customer Has Been Added";
            
       }catch (Exception e)
       {
           String Error = "Error " + e;
           return Error;
       }
    }
}
