package Piece;


import jeu.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn implements Piece {
    private String color;
    private final int VALUE = 1;
    private char symbol;
    public void setColor(String color){
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265F' : '\u2659';
    }
    public String getColor(){
        return this.color;
    }
    public int getValue(){
        return this.VALUE;
    }
    @Override
    public String toString() {
        return "pion " +this.color;
    }


}
