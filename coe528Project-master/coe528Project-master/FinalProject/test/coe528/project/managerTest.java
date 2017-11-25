/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;
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
public class managerTest {
    
    public managerTest() {
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
     * Test of getUserName method, of class manager.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        manager instance = new manager();
        String expResult = "admin";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdminPassword method, of class manager.
     */
    @Test
    public void testGetAdminPassword() {
        System.out.println("getAdminPassword");
        manager instance = new manager();
        String expResult = "admin";
        String result = instance.getAdminPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccountNum method, of class manager.
     */
    @Test
    public void testGetAccountNum() {
        System.out.println("getAccountNum");
        manager instance = new manager();
        int expResult = 0;
        int result = instance.getAccountNum();
        assertEquals(expResult, result);
    }

    
}
