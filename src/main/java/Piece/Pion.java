package Piece;

import Piece.Piece;
import jeu.Case;

public class Pion implements Piece {
    private String couleur;
public Pion(){}

    @Override
    public String toString() {
        return "pion";
    }
    public void setCouleur(String c){this.couleur=c;}
}
