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
abstract public class Person {
   private int ID;
   private String LName;
   private String FName;
   private int Age;
   
   abstract public String add(Connection C);
   abstract public String update(Connection con);
   abstract public String find(Connection con);
   abstract public String delete(Connection con);
   
   public void setID(int A)
   {
       ID = A;
   }
   
   public void setFName(String A)
   {
       FName = A;
   }
   
   public void setLName(String A)
   {
       LName = A;
   }
   
   public void setAge(int A)
   {
       Age = A;
   }
   
   public int getID()
   {
       return ID;
   }
   
   public String getFName()
   {
       return FName;
   }
   
   public String getLName()
   {
       return LName;
   }
   
   public int getAge()
   {
       return Age;
   }
}
