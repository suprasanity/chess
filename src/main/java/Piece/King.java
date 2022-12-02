package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class King extends Piece{
    private final int[] listDirection = new int[]{-9,-8,-7,-1,1,7,8,9};

    public King(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals("Black")) ? '\u265A': '\u2654');

    }



    public List<Move> legalMovSquares(Square square){ // castling ? 
        List<Move> legalMove = new ArrayList<>();
        int[] listDirection;
        int index=0;
        int buff=1;
        if(square.getPiece() instanceof King){
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                    break;
                }
            }
            listDirection = new int[]{-9,-1,9,7,1,-7};
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                if((isColumnExclusionLeft(buff, square, nextPossibleSquare) || isColumnExclusionRight(buff, square, nextPossibleSquare))){
                    if(nextPossibleSquare<=Board.END_INDEX_BOARD && nextPossibleSquare>=Board.START_INDEX_BOARD){
                        if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                        }
                        else{
                            if(!(Board.lesCase.get(nextPossibleSquare).getPiece()
                                    .getColor().equals(square.getPiece().getColor()))){
                                legalMove.add(new Move(nextPossibleSquare,index));
                            }
                        }
                    }
                }

            }
            listDirection = new int[]{8,-8};
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                if(nextPossibleSquare>=Board.START_INDEX_BOARD
                        && nextPossibleSquare<=Board.END_INDEX_BOARD
                ){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare, index));
                    }
                    else{
                        if(!(Board.lesCase.get(nextPossibleSquare).getPiece().getColor()
                                .equals(square.getPiece().getColor()))){
                            legalMove.add(new Move(nextPossibleSquare, index));
                        }
                    }
                }
            }
        }
        return legalMove;
    }

    public boolean isColumnExclusionLeft(int step,Square currSquare,int indexNextSquare){
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter - step;
            Board.LETTER.get(indexNextLetter);
            return (Board.lesCase.get(indexNextSquare).getLetter()
                    ==(Board.LETTER.get(indexNextLetter))) ? true : false;

        }catch(Exception e){
            return false;
        }
    }
    public boolean isColumnExclusionRight(int step, Square currSquare,int indexNextSquare){
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter + step;
            Board.LETTER.get(indexNextLetter);
            return (Board.lesCase.get(indexNextSquare).getLetter()
                    ==(Board.LETTER.get(indexNextLetter))) ? true : false;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString(){
        return "Roi " + this.color;
    }
}