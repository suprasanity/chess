package Piece;


import jeu.Case;

public class Rook implements Piece {
private String color ;


    @Override
    public String toString() {
        return "Tour "+this.color;
    }
    @Override
    public void setColor(String color) {
        this.color=color;
    }
}
