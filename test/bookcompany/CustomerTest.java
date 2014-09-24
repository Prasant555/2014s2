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
    }

    /**
     * Test of update method, of class Customer.
     */
    public void testUpdate() {
        System.out.println(" *CustomerJUnit3Test: testUpdate");
        
       // Connection con = null;
        Customer instance = new Customer();
        instance.setID(8);
        String A = instance.find(DB.con);
        instance.setFName("Khan");
        instance.setLName("Peter");
        instance.setAddress("Nabua");
        instance.setAge(23);
        instance.setPhone("89767");
        
        
        String expected = "The Record Was Updated";
        String result = instance.update(DB.con);
        assertEquals(expected,result);
    }

    /**
     * Test of find method, of class Customer.
     */
    public void testFind() {
        System.out.println("find");
        //Connection con = null;
        Customer instance = new Customer();
        instance.setID(5);
        String expResult = "The Above Record Was Found";
        String result = instance.find(DB.con);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class Customer.
     */
    public void testDelete() {
        System.out.println("delete");
        //Connection con = null;
        Customer instance = new Customer();
        instance.setID(1);
        String expResult = "The Record Was Deleted";
        String result = instance.delete(DB.con);
        assertEquals(expResult, result);
       
    }

    
}
