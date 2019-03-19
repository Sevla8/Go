/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author IAZERTYUIOPI
 */
public class GUIFiller implements Runnable{
int sx;
int ex;
int sy;
int ey;
JButton[][] GUIarr;
PierrePoint[][] logicArr;
    
    GUIFiller(int sx, int ex, int sy, int ey, JButton[][] GUIarr, PierrePoint[][] logicArr) {
    
        this.sx = sx;
        this.ex = ex;
        this.sy = sy;
        this.ey = ey;
        this.GUIarr = GUIarr;
        this.logicArr = logicArr;
        
    }

    @Override
    public void run() {
        
        
        for (int i = sx; i < ex; i++){
            for(int j = sy; j < ey; j++){
                if(logicArr[i][j]==null){
                    GUIarr[i][j].setIcon(new ImageIcon("res/fond.png"));
                }
                else {
                    if("N".equals(logicArr[i][j].toString())){
                        GUIarr[i][j].setIcon(new ImageIcon("res/Noir/30.png"));
                    }
                    if(logicArr[i][j].toString().equals("B")){
                        GUIarr[i][j].setIcon(new ImageIcon("res/Blanc/30.png"));
                    }
                }
            }
        }
        throw new RuntimeException();
    }
    
}
