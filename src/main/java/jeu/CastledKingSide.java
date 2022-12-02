package jeu;

import Piece.King;
import Piece.Piece;
import Piece.Rook;

public class CastledKingSide extends Castled{
    private Rook pieceRook;
    private Player player;
    public CastledKingSide(King pieceKing, 
                           Rook pieceRook,
                           Player player,
                           int currCoord,
                           int destCoord){
    super(pieceKing,pieceRook,player,currCoord,destCoord); 
    }
    
}
