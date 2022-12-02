package jeu;

import Piece.Piece;

public class AttacksPiece extends Move{
    private Piece piece;
    private Move movePiece;
    public AttacksPiece(Piece piece, Move movePiece){
        super(movePiece.getDestCoord(),movePiece.getCurrCoord(),piece); // need to fix incorrect parameters
        this.piece = piece;
        this.movePiece = movePiece;
    }
    @Override
    public void makeMove(){
        Board.lesCase.get(movePiece.getDestCoord()).setPiece(piece);
        Board.lesCase.get(movePiece.getCurrCoord()).setPiece(null);
        // could add other things 
    }

}
