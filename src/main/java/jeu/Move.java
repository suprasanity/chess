package jeu;

import Piece.
*;

public class Move {
    private int destCoord;
    private int currCoord;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    private Piece piece;

    public Move(int destCoord, int currCoord) {
        this.destCoord = destCoord;
        this.currCoord = currCoord;
    }
    public Move(int destCoord, int currCoord, Piece piece) {
        this.destCoord = destCoord;
        this.currCoord = currCoord;
        this.piece = piece;
    }

    public int getCurrCoord() {
        return currCoord;
    }

    public void setCurrCoord(int currCoord) {
        this.currCoord = currCoord;
    }

    public int getDestCoord() {
        return destCoord;
    }

    public void setDestCoord(int destCoord) {
        this.destCoord = destCoord;
    }

    public void makeMove(int destCoord, int currCoord, Piece piece) {
        this.destCoord = destCoord;
        this.currCoord = currCoord;
        this.piece = piece;
    }

    public Board execute(Board b) {

        Board copie = new Board();
        copie.initPlayeur(new Player(copie,b.getWhitePlayer().getColor(),b.getWhitePlayer().getName()),
                new Player(copie,b.getBlackPlayer().getColor(),b.getBlackPlayer().getName()));

        copie.setPlayerToPlay(b.getPlayerToPlay().getColor().equals("White")?copie.getWhitePlayer():copie.getBlackPlayer());

        copie.alterneJoueur();

        copie.lesCase = b.copyCase(b.getLesCase());
        copie.getLesCase().get(destCoord).setPiece(b.getLesCase().get(currCoord).getPiece());
        copie.getLesCase().get(currCoord).setPiece(null);
        return copie;
    }


    public void doMove(Board board) {
        board.lesCase.get(destCoord).setPiece(board.lesCase.get(currCoord).getPiece());
        board.lesCase.get(currCoord).setPiece(null);
        board.p.getBoard().getLesCase().get(destCoord).setPiece(board.lesCase.get(currCoord).getPiece());
        board.p.getBoard().getLesCase().get(currCoord).setPiece(null);

    }

    public void undoMove(Board board) {
        board.lesCase.get(currCoord).setPiece(board.lesCase.get(destCoord).getPiece());
        board.lesCase.get(destCoord).setPiece(piece);
        board.p.getBoard().getLesCase().get(currCoord).setPiece(board.lesCase.get(destCoord).getPiece());
        board.p.getBoard().getLesCase().get(destCoord).setPiece(piece);
    }

    public Piece getPieceAt(int destCoord,Board board) {
        //
        return board.lesCase.get(destCoord).getPiece();
    }

    public int getPieceDestination() {
        return destCoord;
    }



}