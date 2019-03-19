package jeudego;

import java.util.logging.Level;

public class Jeu {

  private Goban goban;
  private GoGUI gui;
  private InterfaceClavier ui;

  public Jeu(Goban goban, InterfaceClavier ui, GoGUI gui) {
    this.goban = goban;
    this.ui = ui;
    this.gui = gui;
  }

  public void jouer() {
      goban.l.log(Level.INFO,"Bonjour et bienvenue");
      goban.l.log(Level.INFO,"Appuyez sur 'p' pour passer votre tour, cliquez sur le plateau pour jouer");
    while (!goban.partieTerminee()) {
      //ui.tourDeJeu();
    }
  }
}
