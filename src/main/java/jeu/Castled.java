package jeu;
import Piece.King;
import Piece.Piece;
import Piece.Rook;
import jeu.Move;
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
        super(moveKing.getDestCoord(),moveRook.getCurrCoord(), pieceKing);// change all parameters
        this.pieceKing = pieceKing;
        this.player = player;
        this.pieceRook = pieceRook;
        this.moveRook = moveRook;
        this.moveKing = moveKing;
    }
    
    @Override
    public void makeMove(){
        // move call method makeMove also work, choose which one is better
        King k =(King)Board.lesCase.get(moveKing.getCurrCoord()).getPiece();
        Board.lesCase.get(moveKing.getDestCoord()).setPiece(k);
        Rook r = (Rook)Board.lesCase.get(moveRook.getCurrCoord()).getPiece();
        Board.lesCase.get(moveRook.getDestCoord()).setPiece(r);
        pieceKing.setFirstMove();
        Board.p.setCastled(true);
    }
}
