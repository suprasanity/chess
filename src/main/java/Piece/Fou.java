package Piece;

import jeu.Case;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fou implements Piece{
    private String color;

    @Override
    public void setColor(String color) {
        this.color=color;
    }
    public String toString(){
        return "Fou " +this.color;
    }


}
