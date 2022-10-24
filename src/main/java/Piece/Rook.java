package Piece;


public class Rook implements Piece {
private String couleur ;

    @Override
    public String toString() {
        return "Tour "+this.couleur;
    }



    @Override
    public void setCouleur(String c) {
this.couleur=c;
    }
}
