package jeu;

import Piece.Piece;

public class Move {
    private int destCoord;
    private int currCoord;
    private Piece piece;
    public Move(int destCoord, int currCoor){
        this.destCoord = destCoord;
        this.currCoord = currCoord;
        this.piece = piece;
    }
    public void makeMove(){
        Board.lesCase.get(destCoord).setPiece(this.piece);
        Board.lesCase.get(currCoord).setPiece(null);
    }
    @Override
    public String toString(){
        return Integer.toString(this.destCoord);
    }
    //castling, promotion, pawn attacks,
}