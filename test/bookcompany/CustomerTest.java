/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookcompany;

import java.sql.Connection;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 *
 * @author Anusheel
 */
public class CustomerTest extends TestCase {
    //private Connection con;
    
    private static DBConnection DB = new DBConnection("C:/Users/Anusheel/Documents/GitHub/2014s2/BookCompany.accdb");
   
    public CustomerTest(String testName) {
        super(testName);
       
    }
    /**
     * Test of add method, of class Customer.
     */
   
    public void testAdd() {
        /* TEST FOR SUCCESSFULL ADD OF DATABASE*/
         System.out.println(" *CustomerJUnit3Test: testAdd");
        //Connection con = null;
        Customer instance = new Customer();
        instance.setFName("Khan");
        instance.setLName("Peter");
        instance.setAddress("Nabua");
        instance.setAge(8);
        instance.setPhone("89767");
        instance.setID(14);
        
        String expected = "The Customer Has Been Added";
        String result = instance.add(DB.con);
        assertEquals(expected,result);
        
        /* TEST FOR EXCEPTION DUE TO ERROR */
        //////////////////////////////////////////////////////////
      /*  Customer instance2 = new Customer();
        Connection con = null;
        instance.setFName("Khan");
        instance.setLName("Peter");
        instance.setAddress("Nabua");
        instance.setAge(8);
        instance.setPhone("89767");
        instance.setID(14);
        
        String expected2 = "Error: java.lang.NullPointerException";
        String result2 = instance2.add(con);
        assertEquals(expected2,result2);*/
      
    }

    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * Test of update method, of class Customer.
     */
    /* TEST FOR SUCCESSFULL UPDATE OF DATABASE*/
    public void testUpdate() {
        System.out.println(" *CustomerJUnit3Test: testUpdate");
        /* TEST FOR SUCCESSFULL UPDATE OF DATABASE*/
        Customer instance = new Customer();
        instance.setID(8);
        String A = instance.find(DB.con);
        instance.setFName("Peter");
        instance.setLName("Khan");
        instance.setAddress("Nabua");
        instance.setAge(23);
        instance.setPhone("89767");
        
        
        String expected = "The Record Was Updated";
        String result = instance.update(DB.con);
        assertEquals(expected,result);
        
    }
    
    /* TEST FOR EXCEPTION DUE TO CONNECTION ERROR*/

    public void testUpdate_2(){
        
        System.out.println(" *CustomerJUnit3Test: testUpdate_2");
        Customer instance2 = new Customer();
        Connection con = null;
        String  B = instance2.find(con);
        instance2.setFName("Khan");
        instance2.setLName("Peter");
        instance2.setAddress("Nabua");
        instance2.setAge(23);
        instance2.setPhone("89767");
        
        String expected2 = "Error: java.lang.NullPointerException";
        String result2 = instance2.update(con);
        assertEquals(expected2,result2);
        
    }
    
    /* TEST FOR INPUT STRING*/
    
    public void testUpdate_3(){
        
         System.out.println(" *CustomerJUnit3Test: testUpdate_3");
        Customer instance = new Customer();
        instance.setID(8);
        String A = instance.find(DB.con);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < 10000000; i++)
        {
            builder.append("W");
        }
        instance.setFName(builder.toString());
        instance.setLName(builder.toString());
        instance.setAddress(builder.toString());
        instance.setAge(23);
        instance.setPhone(builder.toString());
        
        
        String expected = "Error: java.sql.SQLException: [Microsoft][ODBC Microsoft Access Driver] Query is too complex.";
        String result = instance.update(DB.con);
        assertEquals(expected,result);
        
    }
    ///////////////////////////////////////////////////////////////////////////////////
    /**
     * Test of find method, of class Customer.
     */
    public void testFind() {
        System.out.println("*CustomerJUnit3Test: testFind");
        //Connection con = null;
        Customer instance = new Customer();
        instance.setID(5);
        String expResult = "The Above Record Was Found";
        String result = instance.find(DB.con);
        assertEquals(expResult, result);
        
        /* TEST FOR EXCEPTION DUE TO CONNECTION ERROR*/
        //////////////////////////////////////////////////////////
        Customer instance2 = new Customer();
        instance.setID(5);
         Connection con = null;
        String expResult2 = "Error: java.lang.NullPointerException";
        String result2 = instance2.find(con);
        assertEquals(expResult2, result2);
         
    }

    //////////////////////////////////////////////////////////////////////////
    /**
     * Test of delete method, of class Customer.
     */
    public void testDelete() {
        System.out.println("*CustomerJUnit3Test: testDelete");
        
        /*TEST FOR SUCCESSFULL DELETION OF DATA FROM DATABASE*/
        //Connection con = null;
        Customer instance = new Customer();
        instance.setID(1);
        String expResult = "The Record Was Deleted";
        String result = instance.delete(DB.con);
        assertEquals(expResult, result);
       
    }
    
    /* TEST FOR EXCEPTION DUE TO CONNECTION ERROR*/
   
    public void testDelete_2() {
        
        
        System.out.println("*CustomerJUnit3Test: testDelete_2");
        Connection con = null;
        Customer instance2 = new Customer();
        instance2.setID(1);
        String expected2 = "Error: java.lang.NullPointerException";
        String result2 = instance2.delete(con);
        assertEquals(expected2,result2);
        
    }

    
}
