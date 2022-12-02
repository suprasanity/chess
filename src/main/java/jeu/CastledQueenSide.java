package jeu;

import Piece.King;
import Piece.Piece;
import Piece.Rook;

public class CastledQueenSide extends Castled{
    public CastledQueenSide(King pieceKing, 
                            Rook pieceRook,
                            Player player,
                            Move moveRook,
                            Move moveKing){
        super(pieceKing,pieceRook,player,moveRook,moveKing); 
    }
}
