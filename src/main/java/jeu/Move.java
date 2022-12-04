package jeu;

import Piece.Piece;

public class Move {
    private int destCoord;
    private int currCoord;
    private Piece piece;
    public Move(int destCoord, int currCoord, Piece piece){
        this.destCoord = destCoord;
        this.currCoord = currCoord;
        this.piece = piece;
    }
    public void makeMove(){
        Board.lesCase.get(destCoord).setPiece(this.piece);
        Board.lesCase.get(currCoord).setPiece(null);
    }
    public void undo(){
        Board.lesCase.get(currCoord).setPiece(this.piece);
        Board.lesCase.get(destCoord).setPiece(null);
    }
    public Piece getPiece(){
        return this.piece;
    }
    public int getCurrCoord(){
        return this.currCoord;
    }
    public int getDestCoord(){
        return this.destCoord;
    }
    @Override 
    public String toString(){
        return Integer.toString(this.destCoord);
    }
    //castling, promotion, pawn attacks,  
}
/* 
public class AttacksPiece implements Move{
    public AttacksPiece(){

    }
}
public class PawnPromotion implements Move{
    public PawnPromotion(){

    }
}*/




