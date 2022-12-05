package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.*;

import org.apache.camel.main.Main;

public class Player {


    private final String color;

    public String getName() {
        return name;
    }

    private final String name;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private Board board;
    public Boolean castled = false;
    public static final int DIRECTION = 1;
    public static final int OPPONENT_DIRECTION = -1;

    public Player(Board board, String color, String name) {
        this.board = board;
        this.color = (color.equals("Black") ? "Black" : "White");
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public String getOpponnentColor() {
        return (this.color.equals("Black") ? "Black" : "White");
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
        List<Move> legalMoves2 = new ArrayList<>();
        for (Piece piece : getAllPieces(board.lesCase)) {
            if (piece.getColor().equals(this.color)){
                 if (piece.legalMovSquares(piece.getPiecePosition(board), board).size() != 0){
                    legalMoves.addAll(piece.legalMovSquares(piece.getPiecePosition(board), board));
                }
            }

        }
        if (this.isInCheck(board)){
            for (Move move : legalMoves) {
                move.doMove(board);
                if (!this.inCheckMate()){
                    legalMoves2.add(move);
                }
                move.undoMove(board);
            }
            return legalMoves2;
        }
        return legalMoves;
    }

//     public List<Move> getLegalMoves() {
    public boolean isInCheckMate() {
        return false;
    }

    public boolean isInCheck() {
        return false;
    }

    public MoveTransition makeMove(Move move, Board board) {
        final Board transitionedBoard = move.execute(board);
        return new MoveTransition(board, transitionedBoard, move);
    }

    public boolean isCastled() {
        return this.castled;
    }

    public void setCastled(boolean set) {
        this.castled = set;
    }


    public boolean inCheckMate() {
        return this.isInCheck() && this.getLegalMoves().isEmpty();
    }


    public boolean inStaleMate() {
        return getLegalMoves().isEmpty();
    }

    public List<Piece> getPieceOnBoard() {
        List<Piece> pieces = new ArrayList<>();
        for (Square square : board.lesCase) {
            if (square.getPiece() != null && square.getPiece().getColor().equals(this.color)) {
                pieces.add(square.getPiece());
            }
        }
        return pieces;
    }

    public Piece getKing() {
        for (Square square : board.lesCase) {
            if (square.getPiece() != null && square.getPiece().getColor().equals(this.color) && square.getPiece().getType().equals(Piece.PieceType.KING)) {
                return square.getPiece();
            }
        }
        return null;
    }


    public List<Move> getAttacksOnSquare(Board b){ // le cas du pat 
        List<Move> allOpponentMove = new ArrayList<>();
        for(Square square : b.lesCase){
            if(square.getPiece() instanceof Pawn){
                Pawn pawn = (Pawn)square.getPiece();
                if(square.getPiece().getColor().equals(b.p.getColor())){
                    for(Move move : pawn.attackMove(square,b)){//need check
                        allOpponentMove.add(move);
                    }
                }
            }
            else{
                if(square.getPiece() instanceof Piece){
                    if(square.getPiece().getColor().equals(b.p.getColor())){
                        for(Move move : square.getPiece().legalMovSquares(square,b)){//need check
                            allOpponentMove.add(move);
                        }
                    }
                }

            }
        }
        return allOpponentMove;
    }

    public List<Move> getOpponentAttacksOnSquare(Board b){ // board
        List<Move> allOpponentMove = new ArrayList<>();
        for(Square square : b.lesCase){
            if(square.getPiece() instanceof Pawn){
                Pawn pawn = (Pawn)square.getPiece();
                if(square.getPiece().getColor().equals(getOpponnentColor())){
                    for(Move move : pawn.attackMove(square,b)){//need check
                        allOpponentMove.add(move);
                    }
                }
            }
            else{

                if(square.getPiece() instanceof Piece){
                    if(square.getPiece().getColor().equals(getOpponnentColor())){
                        for(Move move : square.getPiece().legalMovSquares(square,b)){//need check
                            allOpponentMove.add(move);
                        }
                    }
                }

            }
        }
        return allOpponentMove;
    }
    public boolean isInCheck(Board b){
        for(Move move : getOpponentAttacksOnSquare(b)){
            if(move.getPieceAt(move.getDestCoord(),b) instanceof King){
                return true;
            }
        }
        return false;
    }

    public Piece getQueen() {
        return null;
    }
}
