package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BishopTest {
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
        Bishop b = new Bishop(
            "Color",
            new Square('A', 10), true);
        assertEquals("Fou Color",b.toString());
        assertEquals("Color",b.getColor());
        assertEquals(Piece.PieceType.BISHOP, b.pieceType);
        assertTrue(b.isFirstMove);
        assertEquals('♗', b.getSymbol());
    }
    /**
     * Method under test: {@link Bishop#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board p = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        // aucun move au départ
        for(Square s :Board.lesCase){
            if(s.getLetter() == 'C' && s.getNumber() == 1){
                legalMove.addAll(s.getPiece().legalMovSquares(s));
            }
            if(s.getLetter()=='E' && s.getNumber() == 1){
                legalMove.addAll(s.getPiece().legalMovSquares(s));
            }
        }
        assertEquals(0, legalMove.size());
        Board.lesCase.get(16).setPiece(new Bishop( "White", Board.lesCase.get(16), true));
        legalMove.addAll(Board.lesCase.get(16).getPiece().legalMovSquares(Board.lesCase.get(16)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(16).setPiece(null);
        Board.lesCase.get(36).setPiece(new Bishop( "White", Board.lesCase.get(36), true));
        legalMove.addAll(Board.lesCase.get(36).getPiece().legalMovSquares(Board.lesCase.get(36)));
        assertEquals(8, legalMove.size());
        legalMove.clear();
        Board.lesCase.get(36).setPiece(null);
        Board.lesCase.get(31).setPiece(new Bishop( "White", Board.lesCase.get(31), true));
        legalMove.addAll(Board.lesCase.get(31).getPiece().legalMovSquares(Board.lesCase.get(31)));
        assertEquals(4, legalMove.size());
        legalMove.clear();
        Board.lesCase.get(31).setPiece(null);
        Board.lesCase.get(23).setPiece(new Bishop( "Black", Board.lesCase.get(23), true));
        legalMove.addAll(Board.lesCase.get(23).getPiece().legalMovSquares(Board.lesCase.get(23)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(23).setPiece(null);
        Board.lesCase.get(28).setPiece(new Bishop( "Black", Board.lesCase.get(28), true));
        legalMove.addAll(Board.lesCase.get(28).getPiece().legalMovSquares(Board.lesCase.get(28)));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(28).setPiece(null);
        Board.lesCase.get(40).setPiece(new Bishop( "Black", Board.lesCase.get(40), true));
        legalMove.addAll(Board.lesCase.get(40).getPiece().legalMovSquares(Board.lesCase.get(40)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(40).setPiece(null);
        Board.lesCase.get(52).setPiece(new Bishop( "White", Board.lesCase.get(52), true));
        legalMove.addAll(Board.lesCase.get(52).getPiece().legalMovSquares(Board.lesCase.get(52)));
        assertEquals(9, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(52).setPiece(null);
        Board.lesCase.get(51).setPiece(new Bishop( "White", Board.lesCase.get(51), true));
        legalMove.addAll(Board.lesCase.get(51).getPiece().legalMovSquares(Board.lesCase.get(51)));
        assertEquals(9, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack(){
        Board p = new Board(new Player(MesConstantes.BLACK,"Yann"));
        List <Move> legalMove = new ArrayList<>();
    
    
        Board.lesCase.get(16).setPiece(new Bishop( "Black", Board.lesCase.get(16), true));
        legalMove.addAll(Board.lesCase.get(16).getPiece().legalMovSquares(Board.lesCase.get(16)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(16).setPiece(null);
        Board.lesCase.get(36).setPiece(new Bishop( "Black", Board.lesCase.get(36), true));
        legalMove.addAll(Board.lesCase.get(36).getPiece().legalMovSquares(Board.lesCase.get(36)));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(36).setPiece(null);
        Board.lesCase.get(31).setPiece(new Bishop( "Black", Board.lesCase.get(31), true));
        legalMove.addAll(Board.lesCase.get(31).getPiece().legalMovSquares(Board.lesCase.get(31)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(31).setPiece(null);
        Board.lesCase.get(23).setPiece(new Bishop( "White", Board.lesCase.get(23), true));
        legalMove.addAll(Board.lesCase.get(23).getPiece().legalMovSquares(Board.lesCase.get(23)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(23).setPiece(null);
        Board.lesCase.get(28).setPiece(new Bishop( "White", Board.lesCase.get(28), true));
        legalMove.addAll(Board.lesCase.get(28).getPiece().legalMovSquares(Board.lesCase.get(28)));
        assertEquals(8, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(28).setPiece(null);
        Board.lesCase.get(40).setPiece(new Bishop( "White", Board.lesCase.get(40), true));
        legalMove.addAll(Board.lesCase.get(40).getPiece().legalMovSquares(Board.lesCase.get(40)));
        assertEquals(4, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(40).setPiece(null);
        Board.lesCase.get(12).setPiece(new Bishop( "Black", Board.lesCase.get(12), true));
        legalMove.addAll(Board.lesCase.get(12).getPiece().legalMovSquares(Board.lesCase.get(12)));
        assertEquals(9, legalMove.size());

        legalMove.clear();
        Board.lesCase.get(12).setPiece(null);
        Board.lesCase.get(11).setPiece(new Bishop( "Black", Board.lesCase.get(11), true));
        legalMove.addAll(Board.lesCase.get(11).getPiece().legalMovSquares(Board.lesCase.get(11)));
        assertEquals(9, legalMove.size());
    }
    /**
     * Method under test: {@link Bishop#isColumnExclusionLeft(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new Bishop( "White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Bishop b = (Bishop)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(b.isColumnExclusionLeft(1,s,nextMv,i));
        }
        Board.lesCase.get(31).setPiece(new Bishop( "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        b = (Bishop)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(b.isColumnExclusionLeft(1,s,nextMv,i));
        }
    }
     /**
     * Method under test: {@link Bishop#isColumnExclusionRight(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        int[] nextMove = new int[]{9,-7};
        Board.lesCase.get(16).setPiece(new Bishop( "White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Bishop b = (Bishop)Board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(b.isColumnExclusionRight(1,s,nextMv,i));
        }
        Board.lesCase.get(31).setPiece(new Bishop( "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        b = (Bishop)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(b.isColumnExclusionRight(1,s,nextMv,i));
        }

        Board.lesCase.get(31).setPiece(null);
        Board.lesCase.get(51).setPiece(new Bishop( "White", Board.lesCase.get(51), true));
        s = Board.lesCase.get(51);
        b=(Bishop)Board.lesCase.get(51).getPiece();
        assertFalse(b.isColumnExclusionRight(4, s, 15, -9));
    }
    
}

