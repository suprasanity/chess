package Piece;


import jeu.Board;
import jeu.Square;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn implements Piece {
    private String color;
    private final int VALUE = 1;
    private char symbol;
    private boolean firstMove;
    public void setColor(String color,Boolean firstMove){
        this.color=color;
        this.firstMove = firstMove;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265F' : '\u2659';
    }
    public char getSymbol(){
        return this.symbol;
    }
    public String getColor(){
        return this.color;
    }
    public int getValue(){
        return this.VALUE;
    }
    public boolean isFirstMove(){
        return this.firstMove;
    }
    public List<Square> legalMovSquares(Square square, List<Square> Board){
        if(this.color.equals("Black")){

        }
            
        
    }
    @Override
    public String toString() {
        return "pion " +this.color;
    }


}
