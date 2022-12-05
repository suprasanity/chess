package Piece;


import jeu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pawn extends Piece {


    public Pawn(PieceType type, String color, Square piecePosition, boolean isFirstMove) {
        super(type, color, piecePosition, isFirstMove);
        super.setSymbol((color.equals(MesConstantes.BLACK)) ? '\u265F' : '\u2659');
    }

    @Override
    public String toString() {
        return "pion " + this.color;
    }

    public List<Move> attackMove(Square square, Board board) {
        List<Move> legalMove = new ArrayList<>();
        int index = 0;
        int directionSide = (MesConstantes.WHITE.equals(board.p.getColor()))
                ? Player.DIRECTION : Player.OPPONENT_DIRECTION;
        int[] listDirection;
        if (square.getPiece() instanceof Pawn) {
            //case if row 7 or row 2
            for (Square findSquare : board.lesCase) {// en trop ? mettre getid pour chaque case ?
                if (square.equals(findSquare)) {
                    index = board.lesCase.indexOf(findSquare);
                }
            }
            // pawn attack piece each side if exist
            // if color of the piece equal to the color assigned for the player then we change the direction
            listDirection = new int[]{7, 9};
            for (int direction : listDirection) {
                int nextPossibleMove = direction * directionSide + index;
                    if (isColumnAcceptableRight(1, square, nextPossibleMove, board) && isColumnAcceptableLeft(1, square, nextPossibleMove, board)&&board.lesCase.get(nextPossibleMove).getPiece() == null) {
                    legalMove.add(new Move(nextPossibleMove, index,square.getPiece()));
                }

            }
        }
        return legalMove;
    }

    public boolean isColumnAcceptableLeft(int step, Square currSquare, int indexNextSquare, Board board) {
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try {
            indexNextLetter = indexCurrLetter - step;
            Board.LETTER.get(indexNextLetter);
            return (board.lesCase.get(indexNextSquare).getLetter()
                    == (Board.LETTER.get(indexNextLetter))) ? true : false;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isColumnAcceptableRight(int step, Square currSquare, int indexNextSquare, Board board) {
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

    public List<Move> legalMovSquares(Square square, Board board) {
        List<Move> legalMove = new ArrayList<>();
        int index = 0;

        int directionSide = (MesConstantes.WHITE.equals(board.p.getColor()))
                ? Player.DIRECTION : Player.OPPONENT_DIRECTION;
        if (square.getPiece() instanceof Pawn) {
            //case if row 7 or row 2
            index = board.lesCase.indexOf(square);
            detectionMangeagePion(square, board, legalMove, index, directionSide);
            // pawn move 2 squares forward
            if (square.getNumber() == 2 && square.getPiece().getColor().equals("White") ||
                    square.getNumber() == 7 && square.getPiece().getColor().equals("Black")) { // isfirst better
                pawnTwoSquare(square,board, legalMove, index, directionSide);
            } else { // move 1 square
                detectionDeplacementStandardPawn(square,board, legalMove, index, directionSide);
            }
        }
        return legalMove;
    }

    private static void detectionDeplacementStandardPawn(Square square,Board board, List<Move> legalMove, int index, int directionSide) {
        int direction = 8;
        int nextPossibleSquare = direction * directionSide + index;
                /*if(nextPossibleSquare + direction<Board.START_INDEX_BOARD){
                    Queen pieceQueen = new Queen(square.getPiece().getColor(),nextPossibleSquare);
                    Pawn currPawn = (Pawn)square.getPiece();
                    legalMove.add(new PawnPromotion(currPawn,
                    pieceQueen,
                    new Move(nextPossibleSquare,index,square.getPiece())));
                    Knight pieceKnight = new Knight(square.getPiece().getColor(),nextPossibleSquare);
                    legalMove.add(new PawnPromotion(currPawn,
                    pieceKnight,
                    new Move(nextPossibleSquare,index,square.getPiece())));
                    Rook pieceRook = new Rook(square.getPiece().getColor(),nextPossibleSquare);
                    legalMove.add(new PawnPromotion(currPawn,
                    pieceRook,
                    new Move(nextPossibleSquare,index,square.getPiece())));
                }*/
        if (board.p.getColor().equals(square.getPiece().getColor())) {
            if (nextPossibleSquare >= Board.START_INDEX_BOARD&&nextPossibleSquare<Board.END_INDEX_BOARD) {
                if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                    legalMove.add(new Move(nextPossibleSquare, index, square.getPiece()));
                }
            }
        }
    }

    private void detectionMangeagePion(Square square, Board board, List<Move> legalMove, int index, int directionSide) {
        int[] listDirection;
        listDirection = new int[]{7, 9};
        for (int direction : listDirection) {
            int nextPossibleMove = direction * directionSide + index;
            if (board.p.getColor().equals(square.getPiece().getColor())) {

                if (isColumnAcceptableRight(1, square, nextPossibleMove, board) && isColumnAcceptableLeft(1, square, nextPossibleMove, board)&&board.lesCase.get(nextPossibleMove).getPiece() != null) {

                    if (!(Objects.equals(board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                            square.getPiece().getColor()))) {
                        legalMove.add(new Move(nextPossibleMove, index,square.getPiece()));
                    }
                }
            }
        }
    }

    private static void pawnTwoSquare(Square square,Board board, List<Move> legalMove, int index, int directionSide) {
        int[] listDirection;
        listDirection = new int[]{8, 16};
        for (int direction : listDirection) {
            int nextPossibleSquare = direction * directionSide + index;
            if (board.p.getColor().equals(square.getPiece().getColor())) {
                if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                    legalMove.add(new Move(nextPossibleSquare, index, square.getPiece()));
                } else {
                    break;
                }
            }

        }
    }

    private static void legalMoveStandard(Square square, List<Move> legalMove, int index, Board board) {
        int[] listDirection;

        int facteur = -1;

        if (board.p.getColor().equals(MesConstantes.WHITE)) {
            if (square.getPiece().getColor().equals(MesConstantes.WHITE)) {
                if (square.getNumber() == 2) {
                    listDirection = new int[]{8, 16};
                    detectMovePossible(square,legalMove, index, listDirection, board);
                } else {
                    int direction = 8;
                    int nextPossibleSquare = direction + index;
                    if (nextPossibleSquare >= Board.START_INDEX_BOARD && nextPossibleSquare <= Board.END_INDEX_BOARD) {
                        if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                            legalMove.add(new Move(nextPossibleSquare, index, square.getPiece()));
                        }
                    }
                }
            }
        } else {
            // je suis le joueur noir
            if (square.getPiece().getColor().equals(MesConstantes.BLACK)) {
                if (square.getNumber() == 7) {
                    listDirection = new int[]{-8, -16};
                    detectMovePossible(square,legalMove, index, listDirection, board);
                } else {
                    int direction = -8;
                    int nextPossibleSquare = direction + index;
                    if (nextPossibleSquare >= Board.START_INDEX_BOARD) {
                        if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                            legalMove.add(new Move(nextPossibleSquare, index, square.getPiece()));
                        }
                    }
                }
            }

        }


    }

    private static void detectMovePossible(Square square,List<Move> legalMove, int index, int[] listDirection, Board board) {
        for (int direction : listDirection) {
            int nextPossibleSquare = direction + index;
            if (board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                legalMove.add(new Move(nextPossibleSquare, index, square.getPiece()));
            }
        }
    }

    private void legalMoveSquareForAttack
            (List<Move> legalMove, int index, Board board) {
        int[] listDirection;
        // pawn attack piece each side if exist

        listDirection = new int[]{-7, -9};
        for (int direction : listDirection) {
            int nextPossibleMove = direction + index;
            if (board.lesCase.get(nextPossibleMove).getPiece() != null
                    && Objects.equals(board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                    board.p.getOpponnentColor())) {
                legalMove.add(new Move(nextPossibleMove, index));
            }
        }
    }

}