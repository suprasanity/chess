package Piece;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class Bishop extends Piece {

    private final int[] listDirection = new int[]{-9, 9, -7, 7};

    public Bishop(String color, Square piecePosition, boolean isFirstMove) {
        super(Piece.PieceType.BISHOP, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals("Black")) ? '\u265D' : '\u2657');
    }

    public List<Move> legalMovSquares(Square square, Board board) {
        int index = 0;
        int buff = 1;
        List<Move> legalMove = new ArrayList<>();
        if (square.getPiece() instanceof Bishop) {
            for (Square findSquare : board.lesCase) {// en trop ? mettre getid pour chaque case ?
                if (square.equals(findSquare)) {
                    index = board.lesCase.indexOf(findSquare);
                }
            }

            for (int direction : listDirection) {
                int nextPossibleSquare = direction + index;
                while (1 == 1) {
                    if (isColumnExclusionLeft(buff, square, nextPossibleSquare,board) ||
                            isColumnExclusionRight(buff, square, nextPossibleSquare,board)) {
                        if (nextPossibleSquare <= Board.END_INDEX_BOARD
                                && nextPossibleSquare >= Board.START_INDEX_BOARD) {
                            if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {

                                legalMove.add(new Move(nextPossibleSquare, index,square.getPiece()));// move constructor(destination coord, current coord,piece,)
                                nextPossibleSquare += direction;
                                buff++;
                            } else {
                                if (!board.lesCase.get(nextPossibleSquare).getPiece()
                                        .getColor().equals(square.getPiece().getColor())) {
                                    legalMove.add(new Move(nextPossibleSquare, index,square.getPiece()));
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                buff = 1;
            }
        }
        return legalMove;
    }

    public boolean isColumnExclusionLeft(int step, Square currSquare, int indexNextSquare,Board board) { // static ?
        char currLetter = currSquare.getLetter();// modify
        int indexCurrLetter = board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try {
            indexNextLetter = indexCurrLetter - step;
            board.LETTER.get(indexNextLetter);
            return (board.lesCase.get(indexNextSquare).getLetter()
                    == (board.LETTER.get(indexNextLetter))) ? true : false;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isColumnExclusionRight(int step, Square currSquare, int indexNextSquare,Board board) { // static ?
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);//need modify
        int indexNextLetter;
        try {
            indexNextLetter = indexCurrLetter + step;
            Board.LETTER.get(indexNextLetter);
            return (board.lesCase.get(indexNextSquare).getLetter()
                    == (Board.LETTER.get(indexNextLetter))) ? true : false;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fou " + this.color;
    }


}