package Piece;


import jeu.Case;
import jeu.Plateau;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pion implements Piece {
    private String couleur;
    private Case aCase;
public Pion(Case c){
    this.aCase=c;
}

    @Override
    public String toString() {
        return "pion " +couleur;
    }
    public void setCouleur(String c){this.couleur=c;}


}
