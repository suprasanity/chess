package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import Piece.Bishop;
import Piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class BishopTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Bishop#Bishop(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link Bishop#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Bishop b = new Bishop("Color", new Square('A', 10), true);
        assertEquals("Color",b.getColor());
        assertEquals(Piece.PieceType.BISHOP, b.pieceType);
        assertTrue(b.isFirstMove);
        assertEquals('♗', b.getSymbol());
        assertEquals("Fou Color", b.toString());
    }


    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        // aucun move au départ
        for(Square s :board.lesCase){
            if(s.getLetter() == 'C' && s.getNumber() == 1){
                legalMove.addAll(s.getPiece().legalMovSquares(s,board));
            }
            if(s.getLetter()=='E' && s.getNumber() == 1){
                legalMove.addAll(s.getPiece().legalMovSquares(s,board));
            }
        }
        assertEquals(0, legalMove.size());

        board.lesCase.get(16).setPiece(new Bishop( "White", board.lesCase.get(16), true));
        legalMove.addAll(board.lesCase.get(16).getPiece().legalMovSquares(board.lesCase.get(16),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(16).setPiece(null);
        board.lesCase.get(36).setPiece(new Bishop( "White", board.lesCase.get(36), true));
        legalMove.addAll(board.lesCase.get(36).getPiece().legalMovSquares(board.lesCase.get(36),board));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        board.lesCase.get(36).setPiece(null);
        board.lesCase.get(31).setPiece(new Bishop( "White", board.lesCase.get(31), true));
        legalMove.addAll(board.lesCase.get(31).getPiece().legalMovSquares(board.lesCase.get(31),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(31).setPiece(null);
        board.lesCase.get(23).setPiece(new Bishop( "Black", board.lesCase.get(23), true));
        legalMove.addAll(board.lesCase.get(23).getPiece().legalMovSquares(board.lesCase.get(23),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(23).setPiece(null);
        board.lesCase.get(28).setPiece(new Bishop( "Black", board.lesCase.get(28), true));
        legalMove.addAll(board.lesCase.get(28).getPiece().legalMovSquares(board.lesCase.get(28),board));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        board.lesCase.get(28).setPiece(null);
        board.lesCase.get(40).setPiece(new Bishop( "Black", board.lesCase.get(40), true));
        legalMove.addAll(board.lesCase.get(40).getPiece().legalMovSquares(board.lesCase.get(40),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(40).setPiece(null);
        legalMove.clear();
        board.lesCase.get(52).setPiece(null);
        board.lesCase.get(51).setPiece(new Bishop( "White", board.lesCase.get(51), true));
        legalMove.addAll(board.lesCase.get(51).getPiece().legalMovSquares(board.lesCase.get(51),board));
        assertEquals(9, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
    
    
        board.lesCase.get(16).setPiece(new Bishop( "Black", board.lesCase.get(16), true));
        legalMove.addAll(board.lesCase.get(16).getPiece().legalMovSquares(board.lesCase.get(16),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(16).setPiece(null);
        board.lesCase.get(36).setPiece(new Bishop( "Black", board.lesCase.get(36), true));
        legalMove.addAll(board.lesCase.get(36).getPiece().legalMovSquares(board.lesCase.get(36),board));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        board.lesCase.get(36).setPiece(null);
        board.lesCase.get(31).setPiece(new Bishop( "Black", board.lesCase.get(31), true));
        legalMove.addAll(board.lesCase.get(31).getPiece().legalMovSquares(board.lesCase.get(31),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(31).setPiece(null);
        board.lesCase.get(23).setPiece(new Bishop( "White", board.lesCase.get(23), true));
        legalMove.addAll(board.lesCase.get(23).getPiece().legalMovSquares(board.lesCase.get(23),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(23).setPiece(null);
        board.lesCase.get(28).setPiece(new Bishop( "White", board.lesCase.get(28), true));
        legalMove.addAll(board.lesCase.get(28).getPiece().legalMovSquares(board.lesCase.get(28),board));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        board.lesCase.get(28).setPiece(null);
        board.lesCase.get(40).setPiece(new Bishop( "White", board.lesCase.get(40), true));
        legalMove.addAll(board.lesCase.get(40).getPiece().legalMovSquares(board.lesCase.get(40),board));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        board.lesCase.get(40).setPiece(null);
        board.lesCase.get(12).setPiece(new Bishop( "Black", board.lesCase.get(12), true));
        legalMove.addAll(board.lesCase.get(12).getPiece().legalMovSquares(board.lesCase.get(12),board));
        assertEquals(9, legalMove.size());

        legalMove.clear();
        board.lesCase.get(12).setPiece(null);
        board.lesCase.get(11).setPiece(new Bishop( "Black", board.lesCase.get(11), true));
        legalMove.addAll(board.lesCase.get(11).getPiece().legalMovSquares(board.lesCase.get(11),board));
        assertEquals(10, legalMove.size());
    }

    @Test
    void testIsColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(16).setPiece(new Bishop( "White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Bishop b = (Bishop)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(b.isColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Bishop( "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        b = (Bishop)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(b.isColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    @Test
    void testIsColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        int[] nextMove = new int[]{9,-7};
        board.lesCase.get(16).setPiece(new Bishop( "White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Bishop b = (Bishop)board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(b.isColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Bishop( "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        b = (Bishop)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(b.isColumnExclusionRight(1,s,nextMv,board));
        }

        board.lesCase.get(31).setPiece(null);
    }
}
