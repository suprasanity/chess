package jeu;

import Piece.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public static Player playerToPlay;
    public static List<Square> lesCase = new ArrayList<>();
    public static final List<Character> LETTER = arrayToListChar("ABCDEFGH".toCharArray());
    public static final int START_INDEX_BOARD = 0;
    public static final int END_INDEX_BOARD = 63;
    public static Player p;

    public Board(Player player) {
        this.p = player;
        initCase();
        initPiece();


    }
    private static List<Character> arrayToListChar(char[] array){
        List<Character> listOfChar = new ArrayList<>();
        for(char i : array){
            listOfChar.add((Character)i);
        }
        return listOfChar;
    }

    public static List <Piece> getActivePieces(Player player) {
        List<Piece> activePieces = new ArrayList<>();
        for (Square square : lesCase) {
            if (square.getPiece() != null && square.getPiece().getColor().equals(player.getColor())) {
                activePieces.add(square.getPiece());
            }
        }
        return activePieces;
    }

    public void initCase() {
        for (int i = 1; i <= 8; i++) {
            for (char c : Board.LETTER)
                lesCase.add(new Square(c, i));
        }
    }

    public void initPiece() {
        for (Square c : lesCase) {
            if(c.getNumber()>4){
                if(c.getNumber()==7){
                    c.setPiece(new Pawn(Piece.PieceType.PAWN, "Black", c, true));
                }
                if(c.getNumber()==8){
                    if(c.getLetter()=='A' || c.getLetter()=='H'){
                        c.setPiece(new Rook(Piece.PieceType.ROOK, "Black", c, true));
                    }
                    if(c.getLetter()=='B' || c.getLetter()=='G'){
                        c.setPiece(new Knight(Piece.PieceType.KNIGHT, "Black", c, true));
                    }
                    if(c.getLetter()=='C' || c.getLetter()=='F'){
                        c.setPiece(new Bishop( "Black", c, true));
                    }
                    if(c.getLetter()=='D'){
                        c.setPiece(new Queen(Piece.PieceType.QUEEN, "Black", c, true));
                    }
                    if(c.getLetter()=='E'){
                        c.setPiece(new King(Piece.PieceType.KING, "Black", c, true));
                    }
                }
            }
            else if (c.getNumber()==2){
                c.setPiece(new Pawn(Piece.PieceType.PAWN, "White", c, true));
            }
            if(c.getNumber()==1){
                if(c.getLetter()=='A' || c.getLetter()=='H'){
                    c.setPiece(new Rook(Piece.PieceType.ROOK, "White", c, true));
                }
                if(c.getLetter()=='B' || c.getLetter()=='G'){
                    c.setPiece(new Knight(Piece.PieceType.KNIGHT, "White", c, true));
                }
                if(c.getLetter()=='C' || c.getLetter()=='F'){
                    c.setPiece(new Bishop( "White", c, true));
                }
                if(c.getLetter()=='D'){
                    c.setPiece(new Queen(Piece.PieceType.QUEEN, "White", c, true));
                }
                if(c.getLetter()=='E'){
                    c.setPiece(new King(Piece.PieceType.KING, "White", c, true));
                }
            }
        }


    }

    public void afficherPlateau() {
        int buff = 0;
        System.out.println("");
        for(int i=0;i<lesCase.size();i++){
            if(i%8==0){
                System.out.print(lesCase.get(i).getNumber());
                buff = i;
                for(int y=0;y<=(lesCase.size()/8)*2;y++){
                    if(y%2==0){
                        System.out.print(" |");
                    }
                    else{
                        if(lesCase.get(buff).getPiece() != null){
                            System.out.print(lesCase.get(buff).getPiece().getSymbol());
                        }
                        else{
                            System.out.print("_");
                        }
                        buff++;
                    }
                }
                System.out.println("");
            }
        }
    }

    public List <Player> getPlayers() {
        return null;
    }

    public Player getWhitePlayer() {
        for (Player p : getPlayers()) {
            if (p.getColor().equals("White")) {
                return p;
            }
        }

        return null;
    //todo should not be there
         }


    public Player getBlackPlayer() {
        for (Player p : getPlayers()) {
            if (p.getColor().equals("Black")) {
                return p;
            }
        }
        return null;
        //todo should not be there
    }

    public Player getPlayerToPlay() {
        return null;
    }
}
