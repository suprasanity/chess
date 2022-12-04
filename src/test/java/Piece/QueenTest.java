package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class QueenTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Queen#Queen(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link Queen#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Queen q = new Queen(Piece.PieceType.QUEEN,
        "Color", new Square('A', 10), true);
        assertEquals("Reine Color", q.toString());
        assertEquals("Color", q.getColor());
        assertEquals(Piece.PieceType.QUEEN, q.pieceType);
        assertTrue(q.isFirstMove);
        assertEquals('♕', q.getSymbol());
        
    }
    /**
     * Method under test: {@link Queen#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board board = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        Board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, Board.p.getColor(),
                                       Board.lesCase.get(16),true));
        legalMove.addAll(Board.lesCase.get(16).getPiece().legalMovSquares(Board.lesCase.get(16)));
        assertEquals(15, legalMove.size());
        legalMove.clear();
        Board.lesCase.get(16).setPiece(null);
        Board.lesCase.get(35).setPiece(new Queen(Piece.PieceType.QUEEN, Board.p.getColor(),
                                       Board.lesCase.get(35),true));
        legalMove.addAll(Board.lesCase.get(35).getPiece().legalMovSquares(Board.lesCase.get(35)));
        assertEquals(19, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(35).setPiece(null);
        Board.lesCase.get(52).setPiece(new Queen(Piece.PieceType.QUEEN, "White", Board.lesCase.get(52), true));
        legalMove.addAll(Board.lesCase.get(52).getPiece().legalMovSquares(Board.lesCase.get(52)));
        assertEquals(16, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(52).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", Board.lesCase.get(52), true));
        Board.lesCase.get(51).setPiece(new Queen(Piece.PieceType.QUEEN, "White", Board.lesCase.get(51), true));
        legalMove.addAll(Board.lesCase.get(51).getPiece().legalMovSquares(Board.lesCase.get(51)));
        assertEquals(16, legalMove.size());

    }
    @Test
    void testLegalMovSquaresBlack(){
        Board board = new Board(new Player(MesConstantes.BLACK,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        Board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, Board.p.getColor(),
                                       Board.lesCase.get(16),true));
        legalMove.addAll(Board.lesCase.get(16).getPiece().legalMovSquares(Board.lesCase.get(16)));
        assertEquals(15, legalMove.size());
        legalMove.clear();
        Board.lesCase.get(16).setPiece(null);
        Board.lesCase.get(35).setPiece(new Queen(Piece.PieceType.QUEEN, Board.p.getColor(),
                                       Board.lesCase.get(35),true));
        legalMove.addAll(Board.lesCase.get(35).getPiece().legalMovSquares(Board.lesCase.get(35)));
        assertEquals(19, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(35).setPiece(null);
        Board.lesCase.get(12).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", Board.lesCase.get(12), true));
        legalMove.addAll(Board.lesCase.get(12).getPiece().legalMovSquares(Board.lesCase.get(12)));
        assertEquals(16, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(12).setPiece(new Queen(Piece.PieceType.QUEEN, "White", Board.lesCase.get(12), true));
        Board.lesCase.get(11).setPiece(new Queen(Piece.PieceType.QUEEN, "Black", Board.lesCase.get(11), true));
        legalMove.addAll(Board.lesCase.get(11).getPiece().legalMovSquares(Board.lesCase.get(11)));
        assertEquals(16, legalMove.size());
    }
    /**
     * Method under test: {@link Queen#isColumnExclusionLeft(int,Square,int,int)}
     */
    @Test
    void testIsColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new Queen( Piece.PieceType.QUEEN,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Queen q = (Queen)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,-1,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(q.isColumnExclusionLeft(1,s,nextMv,i));
        }
        Board.lesCase.get(31).setPiece(new Queen( Piece.PieceType.QUEEN,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        q = (Queen)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(q.isColumnExclusionLeft(1,s,nextMv,i));
        }
    }
    /**
     * Method under test: {@link Queen#isColumnExclusionRight(int, Square,int,int)}
     */
    @Test 
    void testIsColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        int[] nextMove = new int[]{9,-7,1};
        Board.lesCase.get(16).setPiece(new Queen(Piece.PieceType.QUEEN, "White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Queen q = (Queen)Board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(q.isColumnExclusionRight(1,s,nextMv,i));
        }
        Board.lesCase.get(31).setPiece(new Queen( Piece.PieceType.QUEEN,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        q = (Queen)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(q.isColumnExclusionRight(1,s,nextMv,i));
        }

        Board.lesCase.get(31).setPiece(null);
        Board.lesCase.get(51).setPiece(new Queen( Piece.PieceType.QUEEN,"White", Board.lesCase.get(51), true));
        s = Board.lesCase.get(51);
        q=(Queen)Board.lesCase.get(51).getPiece();
        assertFalse(q.isColumnExclusionRight(4, s, 15, -9));
    }

}

