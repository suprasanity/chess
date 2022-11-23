package Piece;



import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jeu.Board;
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
    public List<Move> legalMovSquares(Square square){
        int index=0;
        List<Move> legalMove = new ArrayList<>();
        if(square.getPiece() instanceof Bishop){
            for(Square findSquare : Board.lesCase){// en trop ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                if(!(nextPossibleSquare>Board.END_INDEX_BOARD) 
                && !(nextPossibleSquare<Board.START_INDEX_BOARD)){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                        legalMove.add(Move());// move constructor(destination coord, current coord,piece,) 
                    }
                    if(Board.lesCase.get(nextPossibleSquare).getPiece().getColor().equals(getOpponnentColor)){

                    }
                }
            }
        }
        return null;
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
