package Piece;


import jeu.Board;
import jeu.Move;
import jeu.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pawn extends Piece {


    public Pawn(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals("Black")) ? '\u265F' : '\u2659');
    }
    @Override
    public String toString() {
        return "pion " +this.color;
    }

    public List<Move> legalMovSquares(Square square){
        List<Move> legalMove = new ArrayList<>();
        int index =0;
        int[] listDirection;
        if(square.getPiece() instanceof Pawn){
            //case if row 7 or row 2
            for(Square carre : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(carre)){
                    index = Board.lesCase.indexOf(carre);
                }
            }
            // pawn attack piece each side if exist

            listDirection = new int[]{-7,-9};
            for(int direction : listDirection){
                int nextPossibleMove = direction + index;
                if(Board.lesCase.get(nextPossibleMove).getPiece() != null
                        && Objects.equals(Board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                        Board.p.getOpponnentColor()))
                {
                    legalMove.add(new Move(nextPossibleMove, index));
                }
            }
            // pawn just move
            if(square.getNumber() == 2 && Board.p.getColor().equals("White") ||
                    square.getNumber()== 7 && Board.p.getColor().equals("Black")){
                listDirection = new int[]{-8,-16};
                for(int direction : listDirection){
                    int nextPossibleSquare = direction + index;
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare,index));
                    }
                }
            }
            else{
                int direction = -8;
                int nextPossibleSquare = direction + index;
                if(nextPossibleSquare>=Board.START_INDEX_BOARD){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare, index));
                    }
                }
            }
        }
        return legalMove;
    }

}