package Piece;

import jeu.Case;

public class Roi implements Piece{
    private String color;
    @Override
    public void setColor(String color) {
        this.color=color;
    }
    public String toString(){
        return "Roi " + this.color;
    }
}
