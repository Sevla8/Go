/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.Scanner;
import java.util.logging.Level;

/**
 * 
 * @author zhaoshuli
 */
public class InterfaceClavier {
  private Goban goban;
  private Scanner sc;

  public InterfaceClavier(Goban goban) {
    this.goban = goban;
  }

  /*public boolean tourDeJeu() {
    if (sc == null) {
      sc = new Scanner(System.in);
    }
    System.out.println(goban.toString());
    System.out.println("Au tour de " + goban.getTour() + " de jouer.");
    System.out.println("Entrer l'abscisse, ou -1 pour passer votre tour");
    int x = sc.nextInt();
    if (x == -1) {
      return goban.passerTour();
    }
    System.out.println("Entrer l'ordonnée");
    int y = sc.nextInt();
    return goban.tourDeJeu(x, y);
  }*/

  public void avertirMouvementInvalide() {
    goban.l.log(Level.INFO,"Mouvement invalide");
  }

  public void close() {
    sc.close();
    sc = null;
  }
}
