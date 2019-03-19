package jeudego;

import java.util.ArrayList;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

public class GroupeDePierresTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

  private Goban createGoban() {
    Goban g = new Goban(4);
    /*
      Plateau:
      * + + 
      * + * *
      *     
     */
    int[][] tours = {
        {0,0},
        {1,1},
        {0,1},
        {2,1},
        {1,0}
    };
    for (int[] pos : tours) {
      if (pos != null)
        g.tourDeJeu(pos[0], pos[1]);
    }
    return g;
  }

  @Test
  public void test() {
    Goban g = createGoban();
    Set<PierrePoint> groupeAttendu = new HashSet<>();
    groupeAttendu.add(g.getPierre(0, 0));
    groupeAttendu.add(g.getPierre(0, 1));
    groupeAttendu.add(g.getPierre(1, 0));
    
    GroupeDePierres groupe = new GroupeDePierres(g.getPierre(0, 0), g);
    
    //System.out.print(groupe);
    
    for (int x=0; x<g.getWidth(); x++) {
      for (int y=0; y<g.getWidth(); y++) {
        PierrePoint pierre = g.getPierre(x, y);
        assertEquals(groupeAttendu.contains(pierre), groupe.appartientA(pierre));
      }
    }
  }

    /**
     * Test of iterator method, of class GroupeDePierres.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Goban g = createGoban();
        ArrayList<PierrePoint> groupeAttendu = new ArrayList<>();
        groupeAttendu.add(g.getPierre(0, 0));
        groupeAttendu.add(g.getPierre(0, 1));
        groupeAttendu.add(g.getPierre(1, 0));
        GroupeDePierres groupe = new GroupeDePierres(g.getPierre(0, 0), g);
        
        for( PierrePoint p : groupe)
        {
            assertTrue(groupeAttendu.contains(p));
        }
        
        assertEquals(groupeAttendu.size(),groupe.size());
    }

    /**
     * Test of liberteRestantes method, of class GroupeDePierres.
     */
/*    @Test
    public void testLiberteRestantes() {
        System.out.println("liberteRestantes");
        Goban g = createGoban();
        ArrayList<PierrePoint> groupeAttendu = new ArrayList<>();
        groupeAttendu.add(g.getPierre(0, 0));
        groupeAttendu.add(g.getPierre(0, 1));
        groupeAttendu.add(g.getPierre(1, 0));
        GroupeDePierres groupe = new GroupeDePierres(g.getPierre(0, 0), g);
        assertEquals(groupe.liberteRestantes(), 3);
    }*/
    
        @Test
        public void testGroupeComplet() {
        System.out.println("liberteRestantes");
        Goban g = createGoban();
        ArrayList<PierrePoint> groupeAttendu = new ArrayList<>();
        groupeAttendu.add(g.getPierre(0, 0));
        groupeAttendu.add(g.getPierre(0, 1));
        groupeAttendu.add(g.getPierre(1, 0));
        GroupeDePierres groupe = new GroupeDePierres(g.getPierre(0, 0), g);
        for(PierrePoint p : groupe)
        {
            
        }
        assertEquals(groupe.groupeComplet(), false);
    }

}
