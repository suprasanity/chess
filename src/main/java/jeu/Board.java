package jeu;

import Piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    static int NB_FREQ_MAX=3;

    private HashMap<String, Integer> mapsFrequence = new HashMap<String, Integer>();

    public List<Square> getLesCase() {
        return lesCase;
    }


    public void setLesCase(List<Square> lesCase) {
        this.lesCase = lesCase;
    }

    public List<Square> lesCase = new ArrayList<>();
    public static final List<Character> LETTER = arrayToListChar("ABCDEFGH".toCharArray());
    public static final int START_INDEX_BOARD = 0;
    public static final int END_INDEX_BOARD = 63;
    public Player p;


    public Player whitePlayer;


    public Player blackPlayer;
    public Player opponentPlayer;


    public Board() {
        initCase();
        initPiece();
    }

    public void initPlayeur(Player firstPlayer, Player secondPlayer) {
        this.p = firstPlayer;
        //on considère que le premier player est le blanc
        this.whitePlayer = firstPlayer;
        this.blackPlayer = secondPlayer;

        this.opponentPlayer = secondPlayer;
    }

    private static List<Character> arrayToListChar(char[] array) {
        List<Character> listOfChar = new ArrayList<>();
        for (char i : array) {
            listOfChar.add((Character) i);
        }
        return listOfChar;
    }

    public static List<Piece> getActivePieces(Player player) {
        List<Piece> activePieces = new ArrayList<>();
        for (Square square : player.getBoard().lesCase) {
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
            if (c.getNumber() > 4) {
                if (c.getNumber() == 7) {
                    c.setPiece(new Pawn(Piece.PieceType.PAWN, "Black", c, true));
                }
                if (c.getNumber() == 8) {
                    if (c.getLetter() == 'A' || c.getLetter() == 'H') {
                        c.setPiece(new Rook(Piece.PieceType.ROOK, "Black", c, true));
                    }
                    if (c.getLetter() == 'B' || c.getLetter() == 'G') {
                        c.setPiece(new Knight(Piece.PieceType.KNIGHT, "Black", c, true));
                    }
                    if (c.getLetter() == 'C' || c.getLetter() == 'F') {
                        c.setPiece(new Bishop("Black", c, true));
                    }
                    if (c.getLetter() == 'D') {
                        c.setPiece(new Queen(Piece.PieceType.QUEEN, "Black", c, true));
                    }
                    if (c.getLetter() == 'E') {
                        c.setPiece(new King(Piece.PieceType.KING, "Black", c, true));
                    }
                }
            } else if (c.getNumber() == 2) {
                c.setPiece(new Pawn(Piece.PieceType.PAWN, "White", c, true));
            }
            if (c.getNumber() == 1) {
                if (c.getLetter() == 'A' || c.getLetter() == 'H') {
                    c.setPiece(new Rook(Piece.PieceType.ROOK, "White", c, true));
                }
                if (c.getLetter() == 'B' || c.getLetter() == 'G') {
                    c.setPiece(new Knight(Piece.PieceType.KNIGHT, "White", c, true));
                }
                if (c.getLetter() == 'C' || c.getLetter() == 'F') {
                    c.setPiece(new Bishop("White", c, true));
                }
                if (c.getLetter() == 'D') {
                    c.setPiece(new Queen(Piece.PieceType.QUEEN, "White", c, true));
                }
                if (c.getLetter() == 'E') {
                    c.setPiece(new King(Piece.PieceType.KING, "White", c, true));
                }
            }
        }


    }

    public void afficherPlateau(boolean affichagePlateau) {
        if (affichagePlateau) {
            afficherPlateau();
        }
    }

    public void afficherPlateau() {
        int buff = 0;
        System.out.println("");
        for (int i = 0; i < lesCase.size(); i++) {
            if (i % 8 == 0) {
                System.out.print(lesCase.get(i).getNumber());
                buff = i;
                for (int y = 0; y <= (lesCase.size() / 8) * 2; y++) {
                    if (y % 2 == 0) {
                        System.out.print(" |");
                    } else {
                        if (lesCase.get(buff).getPiece() != null) {
                            System.out.print(lesCase.get(buff).getPiece().getSymbol());
                        } else {
                            System.out.print('\u260F');
                        }
                        buff++;
                    }
                }
                System.out.println("");
            }
        }
    }

    public List<Player> getPlayers() {
        return null;
    }

    public Player getWhitePlayer() {

        return whitePlayer;

    }

    public void alterneJoueur() {
        if (this.p == this.getBlackPlayer()) {
            this.p = this.getWhitePlayer();
            this.opponentPlayer = this.getBlackPlayer();
        } else {
            this.p = this.getBlackPlayer();
            this.opponentPlayer = this.getWhitePlayer();
        }
    }


    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getPlayerToPlay() {
        return this.p;
    }

    public void setPlayerToPlay(Player player) {
        this.p = player;
    }

    public List<Square> copyCase(List<Square> lesCase) {
        List<Square> copyCase = new ArrayList<>();
        for (Square c : lesCase) {
            copyCase.add(new Square(c.getLetter(), c.getNumber()));
            if (c.getPiece() != null) {


                switch (c.getPiece().getType()) {
                    case PAWN:
                        copyCase.get(copyCase.size() - 1).setPiece(new Pawn(Piece.PieceType.PAWN, c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    case ROOK:
                        copyCase.get(copyCase.size() - 1).setPiece(new Rook(Piece.PieceType.ROOK, c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    case KNIGHT:
                        copyCase.get(copyCase.size() - 1).setPiece(new Knight(Piece.PieceType.KNIGHT, c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    case BISHOP:
                        copyCase.get(copyCase.size() - 1).setPiece(new Bishop(c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    case QUEEN:
                        copyCase.get(copyCase.size() - 1).setPiece(new Queen(Piece.PieceType.QUEEN, c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    case KING:
                        copyCase.get(copyCase.size() - 1).setPiece(new King(Piece.PieceType.KING, c.getPiece().getColor(), copyCase.get(copyCase.size() - 1), c.getPiece().isFirstMove()));
                        break;
                    default:
                        return null;
                }
            }
        }
        return copyCase;
    }

    public void incrementeFrequence(Move move) {
        String moveString = move.getPiece().getColor() + move.getPiece().toString() + move.getCurrCoord() + move.getDestCoord();
        if (this.mapsFrequence.containsKey(moveString)) {
            this.mapsFrequence.put(moveString, this.mapsFrequence.get(moveString).intValue() + 1);
        } else {
            this.mapsFrequence.put(moveString, 1);
        }
    }
    public HashMap<String, Integer> getMapsFrequence() {
        return mapsFrequence;
    }
    public  boolean  detectTropDeFoisLeMemeMove(){
        for (String key : this.mapsFrequence.keySet()) {

            if (this.mapsFrequence.get(key)>=NB_FREQ_MAX){
                return true;
            }
        }
        return false;
    }
    public  boolean detectRoiMange(){
        int nbRoi=0;
        for (Square square : this.getLesCase()) {
            if (square.getPiece()!=null && square.getPiece().getType()== Piece.PieceType.KING){
                nbRoi++;
            }
            if (nbRoi>1){
                return false;
            }
        }
        return nbRoi<2;
    }
}
