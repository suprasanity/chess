package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Move;
import jeu.Square;

public class King extends Piece{

    public King(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals("Black")) ? '\u265A': '\u2654');
    }

    public List<Move> legalMovSquares(Square square){
        List<Move> legalMove = new ArrayList<>();

        return legalMove;
    }
    @Override
    public String toString(){
        return "Roi " + this.color;
    }
}