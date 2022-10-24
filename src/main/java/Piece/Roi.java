package Piece;

public class Roi implements Piece{
    private String couleur;
    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }
    public String toString(){
        return "Roi " + this.couleur;
    }
}
