/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

/**
 *
 * @author IAZERTYUIOPI
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoGUI extends JFrame implements KeyListener{
    
    
    final static int NCORES = 4;
    private AtomicInteger nthreadsfinis = new AtomicInteger(0);
    private ArrayList<Thread> threads;
    private Thread.UncaughtExceptionHandler eHandler;
    
    private JPanel panel;
    final JButton[][] GUIarray;
    final static int tilesize = 30;
    private int width;
    private int height;
    
    private Goban goban;
    
    public GoGUI(int w, int h,Goban g){
        
        width = w;
        height = h;
        goban=g;
        
        eHandler = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
            nthreadsfinis.set(nthreadsfinis.incrementAndGet());
            if(nthreadsfinis.get()==NCORES){
                threads.clear();
                nthreadsfinis.set(0);
                repaint();
            }
        }
        };
        
        //fill the images vector
        
        threads = new ArrayList<>();
        
        //define paint method of JPanel
        panel = new JPanel(){public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }};
        panel.setLayout(new GridLayout(width,height,0,0));
        
        //add mouse listener
        MouseAdapter mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            for(int i=0;i<width;i++){
                for(int j=0;j<width;j++){
                    if(e.getSource()==GUIarray[i][j]){
                        goban.tourDeJeu(i, j);
                        draw();
                    }
                }
            } 
            
            }
        };
        
        //fill panel
        
        GUIarray = new JButton[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<width;j++){
                GUIarray[i][j]=new JButton(new ImageIcon("res/fond.png"));
                GUIarray[i][j].addMouseListener(mouseListener);
                GUIarray[i][j].setFocusable(false);
                GUIarray[i][j].setPreferredSize(new Dimension(30,30));
                panel.add(GUIarray[i][j]);
            }
        }
        
        
        //add Jpanel to view
        add(panel);

        //init view        
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        addKeyListener(this);
    }
    
    public void draw() {

        if(!threads.isEmpty()){
            goban.l.log(Level.INFO,"Calculation in progress... please wait");
            return;
        }
        
        
        for(int i=0; i < 2 ; i++){
            for(int j=0; j < 2 ; j++){
        
                int sx=i*width/2;
                int sy=j*height/2;
                int ex=(i+1)*width/2;
                int ey=(j+1)*height/2;
                
                Thread currentThread = new Thread(new GUIFiller(sx,ex,sy,ey,GUIarray,goban.getPointJoueArray()));
                currentThread.setUncaughtExceptionHandler(eHandler);
                threads.add(i+j, currentThread);
                
                
            }
        }
        
        for(int i=0;i<NCORES;i++){
            threads.get(i).start();
        }
        
    }
    
    public double rdn(double n,int r) {
        return Math.round(Math.pow(10,r)*n)/Math.pow(10, r);
    }
   

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if(ke.getExtendedKeyCode()==80){
            goban.passerTour();
        };
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}

 
