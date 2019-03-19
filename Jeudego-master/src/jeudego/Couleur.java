/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

/**
 * 
 * @author zhaoshuli
 */
public enum Couleur {
  NOIR, BLANC;

  @Override
  public String toString() {
    return this == NOIR ? "noir" : "blanc";
  }

  public Couleur autre() {
    return this == NOIR ? BLANC : NOIR;
  }
}
