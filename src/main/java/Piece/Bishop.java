package Piece;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jeu.Move;
import jeu.Square;

public class Bishop implements Piece{
    private String color;
    private final int VALUE = 3;
    private char symbol;
    private final int[] listDirection = new int[] {-9,9,-7,7}; 
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265D': '\u2657';
    }
    public List<Move> legalMovSquares(Square square, List<Square> Board){
        if(square.getPiece() instanceof Bishop){
            for(Square findSquare : Board){
                if(square.){

                }
            }
        }
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
    @Override
    public String toString(){
        return "Fou " +this.color;
    }


}
