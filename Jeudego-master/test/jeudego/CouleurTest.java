/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marc
 */
public class CouleurTest {
    
    public CouleurTest() {
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
     * Test of values method, of class Couleur.
     */
    @Test
    public void testValues() {
        System.out.println("values");

    }

    /**
     * Test of valueOf method, of class Couleur.
     */ /*
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Couleur expResult = null;
        Couleur result = Couleur.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toString method, of class Couleur.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Couleur cb = Couleur.BLANC;
        Couleur cn = Couleur.NOIR;
        assertEquals(cn.toString(), "noir");
        assertEquals(cb.toString(), "blanc");
    }
        

    /**
     * Test of autre method, of class Couleur.
     */
    @Test
    public void testAutre() {
        System.out.println("autre");
        Couleur cb = Couleur.BLANC;
        Couleur cn = Couleur.NOIR;
        assertEquals(cn.autre(), Couleur.BLANC);
        assertEquals(cb.autre(), Couleur.NOIR);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
