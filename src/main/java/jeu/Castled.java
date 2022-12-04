package jeu;
import Piece.King;
import Piece.Piece;
import Piece.Rook;

public class Castled extends Move{
    protected King pieceKing;
    protected Player player;
    protected Rook pieceRook;
    protected Move moveRook;
    protected Move moveKing;
    public Castled( King pieceKing,
                    Rook pieceRook,
                    Player player,
                    Move moveRook,
                    Move moveKing){
        super(moveKing.getDestCoord(),moveRook.getCurrCoord());// change all parameters
        this.pieceKing = pieceKing;
        this.player = player;
        this.pieceRook = pieceRook;
        this.moveRook = moveRook;
        this.moveKing = moveKing;
    }
}