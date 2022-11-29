package Piece;


import jeu.Board;
import jeu.MesConstantes;
import jeu.Move;
import jeu.Square;

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

    public List<Move> legalMovSquares(Square square) {
        List<Move> legalMove = new ArrayList<>();
        int index = 0;
        int[] listDirection;
        if (square.getPiece() instanceof Pawn) {
            //case if row 7 or row 2
//            for(Square carre : Board.lesCase){// en trop ? mettre getid pour chaque case ?
//                if(square.equals(carre)){
//                    index = Board.lesCase.indexOf(carre);
//                }
//            }
            // La méthode equals de la classe Square a été redéfini pour comparer les coordonnées des cases
            // on peut donc utiliser la méthode indexOf de la classe ArrayList
            index = Board.lesCase.indexOf(square);

            //pawn attack
            //TODO faire le test pour savoir si on est blanc ou noir
            //legalMoveSquareForAttack(legalMove, index);
            // pawn just move
            legalMoveStandard(square, legalMove, index);
        }
        return legalMove;
    }

    private static void legalMoveStandard(Square square, List<Move> legalMove, int index) {
        int[] listDirection;

        int facteur = -1;

        if (Board.p.getColor().equals(MesConstantes.WHITE)){
            if (square.getPiece().getColor().equals(MesConstantes.WHITE)) {
                if (square.getNumber() == 2){
                    listDirection = new int[]{8, 16};
                    detectMovePossible(legalMove, index, listDirection);
                }else {
                    int direction = 8;
                    int nextPossibleSquare = direction + index;
                    if (nextPossibleSquare >= Board.START_INDEX_BOARD) {
                        if (Board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                            legalMove.add(new Move(nextPossibleSquare, index));
                        }
                    }
                }
            }else{
                System.out.println("Ba mon pote t'esaie de bouger un pion" + Board.p.getOpponnentColor()+ "alors que t'es le joueur " +Board.p.getColor());

            }
        }else{
            // je suis le joueur noir
            if (square.getPiece().getColor().equals(MesConstantes.BLACK)) {
                if (square.getNumber() == 7){
                    listDirection = new int[]{-8, -16};
                    detectMovePossible(legalMove, index, listDirection);
                }else {
                    int direction = -8;
                    int nextPossibleSquare = direction + index;
                    if (nextPossibleSquare >= Board.START_INDEX_BOARD) {
                        if (Board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                            legalMove.add(new Move(nextPossibleSquare, index));
                        }
                    }
                }
            }else{
                //Ba mon pote t'esaie de bouger un pion noir alors que t'es le joueur noir
            }

        }




    }

    private static void detectMovePossible(List<Move> legalMove, int index, int[] listDirection) {
        for (int direction : listDirection) {
            int nextPossibleSquare = direction + index;
            if (Board.lesCase.get(nextPossibleSquare).getPiece() == null) {
                legalMove.add(new Move(nextPossibleSquare, index));
            }
        }
    }

    private  void legalMoveSquareForAttack
            (List<Move> legalMove, int index) {
        int[] listDirection;
        // pawn attack piece each side if exist

        listDirection = new int[]{-7, -9};
        for (int direction : listDirection) {
            int nextPossibleMove = direction + index;
            if (Board.lesCase.get(nextPossibleMove).getPiece() != null
                    && Objects.equals(Board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                    Board.p.getOpponnentColor())) {
                legalMove.add(new Move(nextPossibleMove, index));
            }
        }
    }

}