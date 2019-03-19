/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhaoshuli
 */
public class GobanTest {
  
  public GobanTest() {
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
   * Test of ajouterPierre method, of class Goban.
   */
  @Test
  public void testAjouterPierre() {
    System.out.println("ajouterPierre");
    int x = 0;
    int y = 0;
    PierrePoint pierre= new PierrePoint(x, y, Couleur.NOIR);
    Goban instance = new Goban(9);
    instance.ajouterPierre(x, y);
    assertTrue(instance.getPierre(x, y).equals(pierre));
  }

  /**
   * Test of getPierre method, of class Goban.
   */
  @Test
  public void testGetPierre() {
    System.out.println("getPierre");
    int x = 2;
    int y = 3;
    Goban instance = new Goban(9);
    PierrePoint expResult =null;
    PierrePoint result = instance.getPierre(x, y);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testGetPierresAutourDe() {
    System.out.println("getPierreAutourDe");
    int x = 2;
    int y = 3;
    Goban instance = new Goban(9);
    instance.ajouterPierre(1,3);
    instance.ajouterPierre(2,4);
    ArrayList<PierrePoint> expResult = new ArrayList<>();
    expResult.add(instance.getPierre(1,3));
    expResult.add(instance.getPierre(2,4));
    ArrayList<PierrePoint> result=instance.getPierresAutourDe(x, y);
    assertEquals(expResult, result);
  }

    /**
     * Test of estSurPlateau method, of class Goban.
     */
    @Test
    public void testEstSurPlateau() {
        System.out.println("testEstSurPlateau");
        
        Goban g = new Goban(5);
        assertEquals(g.estSurPlateau(6, 6),false);
        assertEquals(g.estSurPlateau(0, 0),true);
        assertEquals(g.estSurPlateau(-1, 3),false);
        assertEquals(g.estSurPlateau(3, 3),true);
    }

    /**
     * Test of getTour method, of class Goban.
     */
    @Test
    public void testGetTour() {
        System.out.println("getTour");
        Goban instance = new Goban(5);
        assertEquals("Ce sont toujours les noirs qui commencent", Couleur.NOIR, instance.getTour());
        instance.tourDeJeu(2, 2);
        assertEquals("Après un coup valide des noirs, c'est aux blancs de jouer", Couleur.BLANC, instance.getTour());
        instance.tourDeJeu(20, 2);
        assertEquals("Après un coup invalide des blancs, c'est toujours aux blancs de jouer", Couleur.BLANC, instance.getTour());
    }

    /**
     * Test of tourDeJeu method, of class Goban.
     */
    @Test
    public void testTourDeJeu() {
        System.out.println("tourDeJeu");
        Goban instance = new Goban(5);
        assertEquals("Mouvement valide", true, instance.tourDeJeu(1, 2));
        assertEquals("Mouvement invalide", false, instance.tourDeJeu(11, 2));
        assertEquals("Mouvement valide après un mouvement invalide", true, instance.tourDeJeu(2, 2));
    }

    /**
     * Test of passerTour method, of class Goban.
     */
    @Test
    public void testPasserTour() {
        System.out.println("passerTour");
        Goban gob = new Goban(2);
        gob.passerTour();
        assertEquals("Si les noirs passent leur tour, c'est aux blancs de jouer", Couleur.BLANC, gob.getTour());
        gob.passerTour();
        assertEquals("Si les blancs passent leur tour, c'est aux noirs de jouer", Couleur.NOIR, gob.getTour());
    }

    /**
     * Test of partieTerminee method, of class Goban.
     */
    @Test
    public void testPartieTerminee() {
        System.out.println("partieTerminee");
        Goban instance = new Goban(5);
        assertEquals("La partie n'est pas terminée au début", false, instance.partieTerminee());
        instance.passerTour();
        instance.tourDeJeu(1,1);
        assertEquals("La partie n'est pas terminée après un tour", false, instance.partieTerminee());
        instance.passerTour();
        assertEquals("La partie n'est pas terminée après un tour passé", false, instance.partieTerminee());
        instance.passerTour();
        assertEquals("La partie est terminée après deux tours passés", true, instance.partieTerminee());
        instance.tourDeJeu(2, 3); // Le tour n'est pas possible
        assertEquals("La partie reste terminée même quand on essaie de continuer à jouer", true, instance.partieTerminee());
    }

    /**
     * Test of getWidth method, of class Goban.
     */
    @Test
    public void testGetWidth() {
		int widths[] = {1, 5, 50, 10000};
		for (int w: widths) assertEquals(w, new Goban(w).getWidth());
    }

    /**
     * Test of getPointJoueArray method, of class Goban.
     */
    @Test
    public void testGetPointJoueArray() {
        System.out.println("getPointJoueArray");
        Goban instance = null;
        PierrePoint[][] expResult = null;
        PierrePoint[][] result = instance.getPointJoueArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
