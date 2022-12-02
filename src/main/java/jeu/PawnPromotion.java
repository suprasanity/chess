package jeu;

import Piece.Pawn;
import Piece.Piece;

public class PawnPromotion extends Move{
    private Pawn pawn;
    private Piece pawnPromote;
    private Move movePawn;
    public PawnPromotion(Pawn pawn, Piece pawnPromote, Move movePawn){
        super(movePawn.getDestCoord(), movePawn.getCurrCoord(), pawn); // need to check
        this.pawn = pawn;
        this.pawnPromote = pawnPromote;
        this.movePawn = movePawn;
    }
    @Override
    public void makeMove(){
        Board.lesCase.get(movePawn.getCurrCoord()).setPiece(null);
        Board.lesCase.get(movePawn.getDestCoord()).setPiece(pawnPromote);
        // impl first move
    }
}
