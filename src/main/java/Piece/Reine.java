package Piece;

public class Reine implements Piece{
    private String couleur;
    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }
    public String toString(){return "Reine "+couleur;}
}
