/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angeev
 */
public class customerTest {
    
    public customerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class customer.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        customer instance = new customer("sean", "pass", 1, 34);
        String expResult = "sean";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class customer.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        customer instance = new customer("sean", "pass", 1, 34);
        int expResult = 34;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class customer.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 37;
        customer instance = new customer("sean", "pass", 1, 34);
        instance.setAge(age);
        assertEquals(age, instance.getAge());
    }

    /**
     * Test of getPassword method, of class customer.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        customer instance = new customer("sean", "pass", 1, 34);
        String expResult = "pass";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccnum method, of class customer.
     */
    @Test
    public void testGetAccnum() {
        System.out.println("getAccnum");
        customer instance = new customer("sean", "pass", 1, 34);;
        int expResult = 1;
        int result = instance.getAccnum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class customer.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        movies instance = new movies("movieame", 22, 12.50);
        String expResult = "movieame";
        String result = instance.getMovie();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTotalprice method, of class customer.
     */
    @Test
    public void testGetTotalprice() {
        System.out.println("getTotalprice");
        movies instance = new movies("movieame", 22, 12.50);
        double expResult = 12.50;
        double result = instance.getTicketPrice();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of purchaseTicket method, of class customer.
     */
    @Test
    public void testPurchaseTicket() {
        System.out.println("purchaseTicket");
        customer instance = new customer("sean", "pass", 1, 34);
        int age = 34;
        int seats = 3;
        String movieName = "movieame";
        movies movies1 = new movies("movieame", 22, 12.50);
        int status = 1;
        instance.purchaseTicket(age, seats, movieName, movies1, status);
        assertEquals(age, instance.getAge());
        assertEquals(seats, instance.getSeatnum());
        assertEquals(movieName, instance.getTitle());
    }

}
