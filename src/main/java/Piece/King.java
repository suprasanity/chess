package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Move;
import jeu.Square;

public class King extends Piece{
    private String color;
    private final int VALUE = -1;
    private char symbol;

    public King(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
    }

    public boolean isFirstMove(){
        return false;
    }
    public List<Move> legalMovSquares(Square square){
        List<Move> legalMove = new ArrayList<>();

        return legalMove;
    }
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265A': '\u2654';
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
        return "Roi " + this.color;
    }
}