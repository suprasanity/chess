package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import Piece.Knight;
import Piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class KnightTest {
    @Test
    void testConstructor() {
        Knight k = new Knight(Piece.PieceType.KNIGHT, "Color", new Square('A', 10), true);
        assertEquals("Cavalier Color", k.toString());
        assertEquals("Color", k.getColor());
        assertEquals(Piece.PieceType.KNIGHT, k.pieceType);
        assertTrue(k.isFirstMove);
        assertEquals('♘', k.getSymbol());
    }

    @Test
    void testIsColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Knight k = (Knight)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-17,15};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Knight(Piece.PieceType.KNIGHT, "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (Knight)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    @Test
    void testIsColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        int[] nextMove = new int[]{-15,17};
        board.lesCase.get(16).setPiece(new Knight(Piece.PieceType.KNIGHT, "White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Knight k = (Knight)board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (Knight)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isColumnExclusionRight(1,s,nextMv,board));
        }
    }

    @Test
    void testIsSecondColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Knight k = (Knight)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-10,6};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isSecondColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (Knight)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isSecondColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    @Test
    void testIsSecondColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Knight k = (Knight)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{10,-6};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isSecondColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        k = (Knight)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isSecondColumnExclusionRight(1,s,nextMv,board));
        }
    }

    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        // test si les prochains move du cavalier ne sont pas en dehors du board et n'attaque pas ses propres pièces
        legalMove.addAll(board.lesCase.get(1).getPiece().legalMovSquares(board.lesCase.get(1),board));
        assertEquals(2, legalMove.size());

        // test si cavalier mange les pions 
        legalMove.clear();
        board.lesCase.get(35).setPiece(new Knight(Piece.PieceType.KNIGHT,
         board.p.getColor(), board.lesCase.get(35), true));
         legalMove.addAll(board.lesCase.get(35).getPiece().legalMovSquares(board.lesCase.get(35),board));
         assertEquals(8, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack(){
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        // test si les prochains move du cavalier ne sont pas en dehors du board et n'attaque pas ses propres pièces
        legalMove.addAll(board.lesCase.get(57).getPiece().legalMovSquares(board.lesCase.get(57),board));
        assertEquals(2, legalMove.size());

        // test si cavalier mange les pions 
        legalMove.clear();
        board.lesCase.get(27).setPiece(new Knight(Piece.PieceType.KNIGHT,
         board.p.getColor(),board.lesCase.get(27), true));
         legalMove.addAll(board.lesCase.get(27).getPiece().legalMovSquares(board.lesCase.get(27),board));
         assertEquals(8, legalMove.size());
    }
}
