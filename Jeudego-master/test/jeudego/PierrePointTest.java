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
 * @author IAZERTYUIOPI
 */
public class PierrePointTest {
    
    public PierrePointTest() {
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
     * Test of equals method, of class PierrePoint.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        PierrePoint pierre1 =new PierrePoint(2, 3, Couleur.NOIR);
        PierrePoint pierre2 =new PierrePoint(3, 3, Couleur.NOIR);
        PierrePoint instance = new PierrePoint(2, 3, Couleur.NOIR);
        assertEquals(true, instance.equals(pierre1));
        assertEquals(false, instance.equals(pierre2));

    }
    
    @Test
    public void testtoString()
    {
        System.out.println("toString");
        PierrePoint pierre1 =new PierrePoint(2, 3, Couleur.NOIR);
        PierrePoint pierre2 =new PierrePoint(3, 3, Couleur.BLANC);
        assertEquals("B", pierre2.toString());
        assertEquals("N", pierre1.toString());
    }
    
}
