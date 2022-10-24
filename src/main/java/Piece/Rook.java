package Piece;

import Piece.Piece;
import jeu.Case;

public class Rook implements Piece {
private String couleur ;

    @Override
    public String toString() {
        return "Tour";
    }



    @Override
    public void setCouleur(String c) {
this.couleur=c;
    }
}
