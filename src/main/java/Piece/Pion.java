package Piece;



public class Pion implements Piece {
    private String couleur;
public Pion(){}

    @Override
    public String toString() {
        return "pion " +couleur;
    }
    public void setCouleur(String c){this.couleur=c;}
}
