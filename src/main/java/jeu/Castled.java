package jeu;
import Piece.King;
import Piece.Piece;
import Piece.Rook;
import jeu.Move;
public class Castled extends Move{
    protected King pieceKing;
    protected Player player;
    protected Rook pieceRook;
    protected int currCoord;
    protected int destCoord;
    public Castled( King pieceKing, 
                    Rook pieceRook,
                    Player player,
                    int currCoord,
                    int destCoord){
        super(destCoord, currCoord, pieceKing);// change constructor especially piece 
        this.pieceKing = pieceKing;
        this.player = player;
        this.pieceRook = pieceRook;
        this.currCoord = currCoord;
        this.destCoord = destCoord;
    }
    
    @Override
    public void makeMove(){
        
    }
}
