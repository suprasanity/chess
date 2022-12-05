package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RookTest {
    @Test
    void testConstructor(){
        Rook r = new Rook(Piece.PieceType.ROOK,
        "Color", new Square('A', 10), true);
        assertEquals("Tour Color", r.toString());
        assertEquals("Color", r.getColor());
        assertEquals(Piece.PieceType.ROOK, r.pieceType);
        assertTrue(r.isFirstMove);
        assertEquals('♖', r.getSymbol());
    }
    @Test
    void testIsColumnExclusionLeft() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(32).setPiece(new Rook( Piece.PieceType.ROOK,"White", board.lesCase.get(32), true));
        Square s = board.lesCase.get(32);
        Rook r = (Rook)board.lesCase.get(32).getPiece();
        int[] nextMove = new int[]{-1};
        for(int i : nextMove){
            int nextMv = 32 + i;
            assertFalse(r.isColumnExclusionLeft(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Rook(Piece.PieceType.ROOK, "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        r = (Rook)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(r.isColumnExclusionLeft(1,s,nextMv,board));
        }
    }

    @Test
    void testIsColumnExclusionRight() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        board.lesCase.get(32).setPiece(new Rook( Piece.PieceType.ROOK,"White", board.lesCase.get(32), true));
        Square s = board.lesCase.get(32);
        Rook r = (Rook)board.lesCase.get(32).getPiece();
        int[] nextMove = new int[]{1};
        for(int i : nextMove){
            int nextMv = 32 + i;
            assertTrue(r.isColumnExclusionRight(1,s,nextMv,board));
        }
        board.lesCase.get(31).setPiece(new Rook(Piece.PieceType.ROOK, "White", board.lesCase.get(31), true));
        s = board.lesCase.get(31);
        r = (Rook)board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(r.isColumnExclusionRight(1,s,nextMv,board));
        }
    }


    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "White", "Name");
        Player player = new Player(new Board(), "Black", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        //gauche
        board.lesCase.get(32).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(32),true));
        legalMove.addAll(board.lesCase.get(32).getPiece().legalMovSquares(board.lesCase.get(32),board));
        assertEquals(11, legalMove.size());
        //milieu
        legalMove.clear();
        board.lesCase.get(32).setPiece(null);
        board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(35),true));
        legalMove.addAll(board.lesCase.get(35).getPiece().legalMovSquares(board.lesCase.get(35),board));
        assertEquals(12, legalMove.size());  
        //droite
        legalMove.clear();
        board.lesCase.get(35).setPiece(null);
        board.lesCase.get(39).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(39),true));
        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(11, legalMove.size());

    }

    @Test
    void testLegalMovSquaresBlack() {
        Board board = new Board();
        Player firstPlayer = new Player(new Board(), "Black", "Name");
        Player player = new Player(new Board(), "White", "Name");
        board.initPlayeur(firstPlayer, player);

        List <Move> legalMove = new ArrayList<>();
        //gauche
        board.lesCase.get(32).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(32),true));
        legalMove.addAll(board.lesCase.get(32).getPiece().legalMovSquares(board.lesCase.get(32),board));
        assertEquals(11, legalMove.size());
        //milieu
        legalMove.clear();
        board.lesCase.get(32).setPiece(null);
        board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(35),true));
        legalMove.addAll(board.lesCase.get(35).getPiece().legalMovSquares(board.lesCase.get(35),board));
        assertEquals(12, legalMove.size());  
        //droite
        legalMove.clear();
        board.lesCase.get(35).setPiece(null);
        board.lesCase.get(39).setPiece(new Rook(Piece.PieceType.ROOK,board.p.getColor(),
                                        board.lesCase.get(39),true));
        legalMove.addAll(board.lesCase.get(39).getPiece().legalMovSquares(board.lesCase.get(39),board));
        assertEquals(11, legalMove.size());

    }
}
