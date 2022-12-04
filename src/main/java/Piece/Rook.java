package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class Rook extends Piece {
    private final int[] listDirection = new int[]{-1,1,8,-8};

    public Rook(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals("Black")) ? '\u265C' : '\u2656');
    }

    public boolean isFirstMove(){
        return false;
    }
    public List<Move> legalMovSquares(Square square,Board board) {
        int index=0;
        int buff=1;
        List<Move> legalMove = new ArrayList<>();
        if(square.getPiece() instanceof Rook){
            for(Square findSquare : board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = board.lesCase.indexOf(findSquare);
                }
            }

            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                while(true){
                    if((isColumnExclusionLeft(buff, square, nextPossibleSquare,board) ||
                            isColumnExclusionRight(buff, square, nextPossibleSquare,board)) ||
                            (direction == 8 || direction ==-8)){
                        if(nextPossibleSquare<=Board.END_INDEX_BOARD
                                && nextPossibleSquare>=Board.START_INDEX_BOARD){
                            if(board.lesCase.get(nextPossibleSquare).getPiece()==null){

                                legalMove.add(new Move(nextPossibleSquare,index, square.getPiece()));// move constructor(destination coord, current coord,piece,)
                                nextPossibleSquare+=direction;
                                buff++;
                            }
                            else{
                                if(! board.lesCase.get(nextPossibleSquare).getPiece()
                                        .getColor().equals(this.color)){
                                    legalMove.add(new Move(nextPossibleSquare,index, square.getPiece()));
                                    break;
                                }else{break;}
                            }
                        }else{break;}
                    }else{break;}
                }buff=1;
            }
        }
        return legalMove;
    }
    public boolean isColumnExclusionLeft(int step,Square currSquare,int indexNextSquare,Board board){
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter - step;
            Board.LETTER.get(indexNextLetter);
            return board.lesCase.get(indexNextSquare).getLetter()
                    == (Board.LETTER.get(indexNextLetter));

        }catch(Exception e){
            return false;
        }
    }
    public boolean isColumnExclusionRight(int step, Square currSquare,int indexNextSquare,Board board){
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter + step;
            Board.LETTER.get(indexNextLetter);
            return board.lesCase.get(indexNextSquare).getLetter()
                    == (Board.LETTER.get(indexNextLetter));

        }catch(Exception e){
            return false;
        }
    }
    @Override
    public String toString() {
        return "Tour "+this.color;
    }

}