package jeu;

import Piece.Pawn;
import Piece.Piece;

public class PawnPromotion extends Move{
    private Pawn pawn;
    private Piece pawnPromote;
    private Move movePawn;
    public PawnPromotion(Pawn pawn, Piece pawnPromote, Move movePawn){
        super(movePawn.getDestCoord(), movePawn.getCurrCoord()); // need to check
        this.pawn = pawn;
        this.pawnPromote = pawnPromote;
        this.movePawn = movePawn;
    }

}