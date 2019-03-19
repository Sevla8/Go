/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import static jeudego.Couleur.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zhaoshuli
 */


public class Goban {
  public int width=9;
  private PierrePoint pointJoueArray[][];//liste des pierres poses sur le plateau
  private Couleur tour; // qui a son tour
  private int nbrToursPasses = 0; // Le nombre de fois successives qu'un joueur a passé son tour
  protected Logger l;
  
  
  
  public Goban(int width){
    l = Logger.getLogger("JEU");
    pointJoueArray=new PierrePoint[width][width];
    tour=NOIR;
    this.width = width;
  }
  
  /**
   * Ajoute une pierre de la couleur du joueur dont c'est le tour
   * @param x  abscisse de la pierre a ajouter
   * @param y  ordonee de la pierre a ajouter
  */
  public void ajouterPierre(int x, int y){
    pointJoueArray[x][y]=new PierrePoint(x, y, tour);
  }
  
  public boolean estSurPlateau(int x, int y) {
    return (x>=0 && y>=0 && x<width && y<width);
  }
  
  public PierrePoint getPierre(int x,int y){
    return estSurPlateau(x, y) ? pointJoueArray[x][y] : null;
  }
  
  public ArrayList<PierrePoint> getPierresAutourDe(int x, int y) {
    ArrayList<PierrePoint> pierres = new ArrayList<>();
    int[][] positions = {{-1,0},{1,0},{0,-1},{0,1}};
    for (int[] pos : positions){
      PierrePoint pierre = getPierre(x+pos[0], y+pos[1]);
      if (pierre != null) 
          pierres.add(pierre);
    }
    return pierres;
  }
  
    public ArrayList<PierrePoint> getPierresAutourDeNull(int x, int y) {
    ArrayList<PierrePoint> pierres = new ArrayList<>();
    int[][] positions = {{-1,0},{1,0},{0,-1},{0,1}};
    for (int[] pos : positions){
      PierrePoint pierre = getPierre(x+pos[0], y+pos[1]);
      if (x+pos[0] < 0 || x+pos[0] > this.width || y+pos[1] < 0 || y+pos[1] > this.width ) 
          continue;
      pierres.add(pierre);
    }
    return pierres;
  }

  /**
   * Permet de savoir de quel joueur c'est le tour
   * @return la couleur du joueur dont  c'est le tour
   */
  public Couleur getTour() {
    return tour;
  }

  /**
   * @param x
   * @param y
   * @return true si la pierre a bien pu être posée 
   */
  public boolean tourDeJeu(int x, int y) {
    if (estMouvementValide(x,y)) {
      l.log(Level.INFO,tour+" joue en ("+x+","+y+")");
      nbrToursPasses = 0;
      ajouterPierre(x, y);
      tour = tour.autre();
      return true;
    } else {
        l.log(Level.INFO,"Mouvement invalide; réessayez svp");
      return false;
    }
  }

  private boolean estMouvementValide(int x, int y) {
    if (!estSurPlateau(x,y)) return false;
    if (partieTerminee()) return false; // On ne peut plus jouer après la fin de la partie
    
    PierrePoint pierre=new PierrePoint(x, y);
    for (PierrePoint[] ligne : pointJoueArray){
      for (PierrePoint p: ligne){
        if(pierre.equalsPosition(p)){
          return false;
        }  
      }   
    }
    return true;
  }

  /**
   * Passe le tour du joueur actuel
   * @return
   */
  public boolean passerTour() {
    l.log(Level.INFO,tour+" passe son tour !");
    nbrToursPasses ++;
    tour = tour.autre();
    return true;
  }

  public boolean partieTerminee() {
    // La partie se termine lorsque deux joueurs passent leur tour successivement
    return nbrToursPasses == 2;
  }
  
  public int getWidth() {
    return this.width;
  }

  public PierrePoint[][] getPointJoueArray() {
    return this.pointJoueArray;
  }
  
  public String toString() {
      String result = "Plateau : ";
      
      for (int i=0;i<width;i++){
          for(int j=0;j<width;j++){
              if(pointJoueArray[j][i]!=null){
                  result+= pointJoueArray[j][i].toString()+" ";
              }
              else{
                  result+= " ";
              }
          }
        result += "\n";
      }
            
      return result;
      
  }
  
  
}