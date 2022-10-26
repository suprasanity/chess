package Piece;


import jeu.Case;

public class Rook implements Piece {
private String couleur ;
private Case aCase;

    @Override
    public String toString() {
        return "Tour "+this.couleur;
    }



    @Override
    public void setCouleur(String c) {
this.couleur=c;
    }
}
