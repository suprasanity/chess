package Piece;

import jeu.Case;

public class Roi implements Piece{
    private String couleur;
    private Case aCase;
    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }
    public String toString(){
        return "Roi " + this.couleur;
    }
}
