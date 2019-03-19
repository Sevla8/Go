/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import static jeudego.Couleur.NOIR;

/**
 * 
 * @author zhaoshuli
 */
public class PierrePoint {
  public int x;
  public int y;
  public Couleur couleur;

  PierrePoint(PierrePoint p) {
    this.x = p.x;
    this.y = p.y;
    this.couleur = p.couleur;
  }
  
  PierrePoint(int x, int y, Couleur c) {
    this.x = x;
    this.y = y;
    this.couleur = c;
  }
  
  PierrePoint(int x, int y){
    this.x = x;
    this.y = y;
  }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof PierrePoint)){
            return false;
        }
        PierrePoint pierre = (PierrePoint) o;
    return (pierre.x == this.x && pierre.y == this.y && pierre.couleur == this.couleur);
  }
  
  public int hashCode(){
      return ( Integer.toString(x)+Integer.toString(y)+(couleur == Couleur.NOIR ? "0" : "1") ).hashCode();
  }
  
  public boolean equalsPosition(PierrePoint pierre) {
    if (pierre==null){
      return false;
    }
    else{
      return (pierre.x == this.x && pierre.y == this.y);
    }
    
  }

  public String toString(){
      String res;
      res = this.couleur == NOIR ? "N" : "B";
      return res;
  }
   
  
}
