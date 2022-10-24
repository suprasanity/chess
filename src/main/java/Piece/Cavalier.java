package Piece;

public class Cavalier implements Piece{
   private String couleur;
    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }

    public String toString(){
        return "Cavalier "+this.couleur;
    }
}
