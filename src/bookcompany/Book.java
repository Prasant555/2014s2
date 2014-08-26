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
public class Book {
    private String ISBN;
    private String Title;
    private String Author;
    private String Subject;
    private String Publisher;
    private int Publication_Year;
    private double Price;
    
    public void setISBN(String n)
    {
        ISBN = n;
    }
    
    public void setTitle(String n)
    {
        Title = n;
    }
    
    public void setAuthor(String n)
    {
        Author = n;
    }
            
    public void setSubject(String n)
    {
        Subject = n;
    }
    
    public void setPublisher(String n)
    {
        Publisher = n;
    }
    
    public void setPublicationYear(int n)
    {
        Publication_Year = n;
    }
    
    public void setPrice(Double n)
    {
        Price = n;
    }
    
     public String getISBN()
    {
        return ISBN;
    }
    
    public String getTitle()
    {
        return Title;
    }
    
    public String getAuthor()
    {
        return Author;
    }
            
    public String getSubject()
    {
        return Subject;
    }
    
    public String getPublisher()
    {
        return Publisher;
    }
    
    public  int getPublicationYear()
    {
        return Publication_Year;
    }
    
    public Double getPrice()
    {
        return Price;
    }
    
    public String findBook(Connection con) 
    {
       try {
            Statement S = con.createStatement();
            String Query;
            ResultSet rs;
        
            Query = "SELECT * FROM Book WHERE ISBN = '" + ISBN + "'" ;
            rs = S.executeQuery(Query);    
            while (rs.next())
            {
                Title = rs.getString("Title");
                Author = rs.getString("Author");
                Subject = rs.getString("Subjects");
                Publisher = rs.getString("Publisher");
                Publication_Year = rs.getInt("Publication_Year");
                Price = rs.getDouble("Price");
            }
         
            return "The Above Record Was Found";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
    
    public String updateBook(Connection con) 
    {
        try {
            Statement S = con.createStatement();
            String Query;
            
            Query = "UPDATE Book SET Title = '"+ Title + "', Author = '" + Author +"', Subjects = '" + Subject + "', Publisher ='" + Publisher +"', Publication_Year = " + Publication_Year+ ", Price = " + Price + " WHERE ISBN = '" + ISBN +"'";
            S.executeUpdate(Query);
            
            return "The Record Was Updated";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
    
    public String addBook(Connection con) 
    {
        try {
            Statement S = con.createStatement();
            
            String Query = "INSERT INTO Book VALUES ('" + ISBN + "', '"+ Title + "', '" + Author +"', '" + Subject + "', '" + Publisher +"', " + Publication_Year + ", " + Price + ")" ;
            S.executeUpdate(Query);
               
            return "The Book Has Been Added";
            
       }catch (Exception e)
       {
           String Error = "Error " + e;
           return Error;
       }
    }
    
    public String deleteBook(Connection con)
    {
        try {
            Statement S = con.createStatement();
            String Query;
            
            Query = "DELETE FROM Book WHERE ISBN = '" + ISBN + "'";
            S.executeUpdate(Query);    
            
            return "The Record Was Deleted";
       }catch (Exception e)
       {
           String Error = "Error: " + e;
           return Error;
       }
    }
    
}
