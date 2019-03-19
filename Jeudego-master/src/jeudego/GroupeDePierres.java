/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author marc
 */
public class GroupeDePierres implements Iterable<PierrePoint> {
    
    Couleur c;
    Goban plateau;
    List<PierrePoint> groupe;
    
    @Override
    public Iterator<PierrePoint> iterator(){
        return groupe.iterator();
    }
    
    public GroupeDePierres(PierrePoint p, Goban g){
        c = p.couleur;
        plateau = g;
        groupe = new ArrayList<>();
        groupe.add(p);
        ajouter(p);
        

    }
    
    private void ajouter(PierrePoint p){
        for (PierrePoint k : plateau.getPierresAutourDe(p.x, p.y)){
            if(k != null && k.couleur == c && !groupe.contains(k)){
                groupe.add(k);
                ajouter(k);
            }
        }
    }
    

    
    public Boolean appartientA(PierrePoint p){
        return groupe.contains(p);
    }
    
    
    public int size(){
        return groupe.size();
    }
    public Boolean groupeComplet(){
       
        for(PierrePoint p : groupe){
            for( PierrePoint n : plateau.getPierresAutourDeNull(p.x, p.y)){
                if(n == null){
                    return false;
                }
            }
        }
        return true;
    }
}
