package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.Piece;

public class Player {
    //class abstraite/static , settings
    private final String color;
    private final String name;

    public Player(String color, String name) {
        this.color = (color.equals("Black") ? "Black" : "White");
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public String getOpponnentColor() {
       if (this.color.equals("Black")) {
           return "White";
       } else {
           return "Black";
       }
    }

    public List<Piece> getAllPieces(List<Square> board) {
        List<Piece> listOfPiece = new ArrayList<>();
        for (Square square : board) {
            if (square.getPiece() != null) {
                listOfPiece.add(square.getPiece());
            }
        }
        return listOfPiece;
    }

    public List<Move> getLegalMoves() {
        List<Move> legalMoves = new ArrayList<>();
        for (Piece piece : getAllPieces(Board.lesCase)) {
            if (piece.getColor().equals(this.color) && piece.legalMovSquares(piece.getPiecePosition()).size() != 0) {
                legalMoves.addAll(piece.legalMovSquares(piece.getPiecePosition()));
            }

        }
        return legalMoves;
    }

    public MoveTransition makeMove(Move move) {
     return null;
    }

    public boolean isInCheckMate() {
        return false;
    }

    public boolean isCastled() {
        return false;
    }

    public boolean isInCheck() {
        return false;
    }
}
