package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import Piece.King;
import Piece.Pawn;
import Piece.Piece;

import java.util.ArrayList;
import java.util.List;

class KingTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link King#King(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link King#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        King k = new King(Piece.PieceType.KING, "Color", new Square('A', 10), true);
        assertEquals("Color",k.getColor());
        assertEquals(Piece.PieceType.KING, k.pieceType);
        assertTrue(k.isFirstMove);
        assertEquals('♔', k.getSymbol());
        assertEquals("Roi Color", k.toString());
    }

    /**
     * Method under test: {@link King#legalMovSquares(Square square,Board b)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);
        
        List <Move> legalMove = new ArrayList<>();
        legalMove.addAll(board.lesCase.get(4).getPiece().legalMovSquares(board.lesCase.get(4),board));
        assertEquals(0, legalMove.size());

        board.lesCase.get(27).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(27),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(27).getPiece().legalMovSquares(board.lesCase.get(27),board));
        assertEquals(8, legalMove.size());

        // test si le roi n'attaque pas le pion
        board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,board.p.getColor()
        ,board.lesCase.get(38),true));
        board.lesCase.get(39).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(39),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(4, legalMove.size());

        // test si le roi peut attaque le pion
        board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,board.p.getOpponnentColor()
        ,board.lesCase.get(38),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(4, legalMove.size());

        // test si n'est pas en dehors du tableau de la gauche

        board.lesCase.get(32).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(32),true));

        legalMove.clear();
        legalMove.addAll(board.lesCase.get(32).getPiece().legalMovSquares(board.lesCase.get(32),board));
        assertEquals(5, legalMove.size());
    }

    /**
     * Method under test: {@link King#legalMovSquares(Square square,Board b)}
     */
    @Test
    void testLegalMovSquaresBlack() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        legalMove.addAll(board.lesCase.get(60).getPiece().legalMovSquares(board.lesCase.get(60),board));
        assertEquals(0, legalMove.size());
        // test toutes les positions possible
        board.lesCase.get(27).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(27),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(27).getPiece().legalMovSquares(board.lesCase.get(27),board));
        assertEquals(8, legalMove.size());
        // test si le roi n'attaque pas le pion
        board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,board.p.getColor()
        ,board.lesCase.get(38),true));
        board.lesCase.get(39).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(39),true));

        legalMove.clear();

        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(4, legalMove.size());
        // test si le roi peut attaque le pion
        board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,board.p.getOpponnentColor()
        ,board.lesCase.get(38),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(4, legalMove.size());
        // test si n'est pas en dehors du tableau de la gauche

        board.lesCase.get(32).setPiece(new King(Piece.PieceType.KING,board.p.getColor()
        ,board.lesCase.get(32),true));
        legalMove.clear();
        legalMove.addAll(board.lesCase.get(32).getPiece().legalMovSquares(board.lesCase.get(32),board));
        assertEquals(5, legalMove.size());
    }

    /**
     * Method under test: {@link King#isColumnExclusionLeft(int,Square,int,Board)}
     */
    @Test
    void testIsColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);


        board.lesCase.get(16).setPiece(new King( Piece.PieceType.KING,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        King k = (King)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,-1,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new King(Piece.PieceType.KING, "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (King)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    /**
     * Method under test: {@link King#isColumnExclusionRight(int, Square,int,Board)}
     */
    @Test
    void testIsColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        int[] nextMove = new int[]{-7,1,9};
        board.lesCase.get(16).setPiece(new King( Piece.PieceType.KING,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        King k = (King)board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new King( Piece.PieceType.KING,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (King)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isColumnExclusionRight(1,s,nextMv,board));
        }
    }
}


