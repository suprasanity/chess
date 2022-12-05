package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import jeu.*;
import org.junit.jupiter.api.Test;

import Piece.Piece;
import Piece.Queen;

import java.util.ArrayList;
import java.util.List;

public class QueenTest {
    @Test 
    void testConstructor(){
        Queen q = new Queen(Piece.PieceType.QUEEN,
        "Color", new Square('A', 10), true);
        assertEquals("Reine Color", q.toString());
        assertEquals("Color", q.getColor());
        assertEquals(Piece.PieceType.QUEEN, q.pieceType);
        assertTrue(q.isFirstMove);
        assertEquals('♕', q.getSymbol());
    }
    @Test
    void testIsColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(16).setPiece(new Queen( Piece.PieceType.QUEEN,"White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Queen q = (Queen)board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,-1,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(q.isColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Queen( Piece.PieceType.QUEEN,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        q = (Queen)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(q.isColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    @Test
    void testIsColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        int[] nextMove = new int[]{9,-7,1};
        board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, "White", board.lesCase.get(16), true));
        Square s = board.lesCase.get(16);
        Queen q = (Queen)board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(q.isColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Queen( Piece.PieceType.QUEEN,"White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        q = (Queen)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(q.isColumnExclusionRight(1,s,nextMv,board));
        }

        board.lesCase.get(31).setPiece(null);
    }

    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, board.p.getColor(),
                                       board.lesCase.get(16),true));
        legalMove.addAll(board.lesCase.get(16).getPiece().legalMovSquares(board.lesCase.get(16),board));
        assertEquals(15, legalMove.size());
        legalMove.clear();
        board.lesCase.get(16).setPiece(null);
        board.lesCase.get(35).setPiece(new Queen(Piece.PieceType.QUEEN, board.p.getColor(),
                                       board.lesCase.get(35),true));
        legalMove.addAll(board.lesCase.get(35).getPiece().legalMovSquares(board.lesCase.get(35),board));
        assertEquals(20, legalMove.size());

        legalMove.clear();
        board.lesCase.get(35).setPiece(null);
        board.lesCase.get(52).setPiece(new Queen(Piece.PieceType.QUEEN, "White",board.lesCase.get(52), true));
        legalMove.addAll(board.lesCase.get(52).getPiece().legalMovSquares(board.lesCase.get(52),board));
        assertEquals(17, legalMove.size());

        legalMove.clear();
        board.lesCase.get(52).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", board.lesCase.get(52), true));
        board.lesCase.get(51).setPiece(new Queen(Piece.PieceType.QUEEN, "White", board.lesCase.get(51), true));
        legalMove.addAll(board.lesCase.get(51).getPiece().legalMovSquares(board.lesCase.get(51),board));
        assertEquals(16, legalMove.size());
    }

    @Test
    void testLegalMovSquaresBlack() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, board.p.getColor(),
                                       board.lesCase.get(16),true));
        legalMove.addAll(board.lesCase.get(16).getPiece().legalMovSquares(board.lesCase.get(16),board));
        assertEquals(15, legalMove.size());
        legalMove.clear();
        board.lesCase.get(16).setPiece(null);
        board.lesCase.get(35).setPiece(new Queen(Piece.PieceType.QUEEN, board.p.getColor(),
                                       board.lesCase.get(35),true));
        legalMove.addAll(board.lesCase.get(35).getPiece().legalMovSquares(board.lesCase.get(35),board));
        assertEquals(20, legalMove.size());

        legalMove.clear();
        board.lesCase.get(35).setPiece(null);
        board.lesCase.get(12).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", board.lesCase.get(12), true));
        legalMove.addAll(board.lesCase.get(12).getPiece().legalMovSquares(board.lesCase.get(12),board));
        assertEquals(16, legalMove.size());

        legalMove.clear();
        board.lesCase.get(12).setPiece(new Queen(Piece.PieceType.QUEEN, "White", board.lesCase.get(12), true));
        board.lesCase.get(11).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", board.lesCase.get(11), true));
        legalMove.addAll(board.lesCase.get(11).getPiece().legalMovSquares(board.lesCase.get(11),board));
        assertEquals(17, legalMove.size());
    }
}
