package jeu;

import Piece.King;
import Piece.Piece;
import Piece.Rook;

public class CastledQueenSide extends Castled{
    public CastledQueenSide(King pieceKing, 
                            Rook pieceRook,
                            Player player,
                            int currCoord,
                            int destCoord){
        super(pieceKing,pieceRook,player,currCoord,destCoord);
    }
}
