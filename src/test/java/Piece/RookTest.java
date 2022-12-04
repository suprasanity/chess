package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RookTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Rook#Rook(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link Rook#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Rook r = new Rook(Piece.PieceType.ROOK,
        "Color", new Square('A', 10), true);
        assertEquals("Tour Color", r.toString());
        assertEquals("Color", r.getColor());
        assertEquals(Piece.PieceType.ROOK, r.pieceType);
        assertTrue(r.isFirstMove);
        assertEquals('♖', r.getSymbol());
        
    }
    /**
     * Method under test: {@link Rook#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board p = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        //gauche
        Board.lesCase.get(32).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(32),true));
        legalMove.addAll(Board.lesCase.get(32).getPiece().legalMovSquares(Board.lesCase.get(32)));
        assertEquals(11, legalMove.size());
        //milieu
        legalMove.clear();
        Board.lesCase.get(32).setPiece(null);
        Board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(35),true));
        legalMove.addAll(Board.lesCase.get(35).getPiece().legalMovSquares(Board.lesCase.get(35)));
        assertEquals(11, legalMove.size());  
        //droite
        legalMove.clear();
        Board.lesCase.get(35).setPiece(null);
        Board.lesCase.get(39).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(39),true));
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(11, legalMove.size());                              
    }
    @Test
    void testLegalMovSquaresBlack(){
        Board p = new Board(new Player(MesConstantes.BLACK,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        //gauche
        Board.lesCase.get(32).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(32),true));
        legalMove.addAll(Board.lesCase.get(32).getPiece().legalMovSquares(Board.lesCase.get(32)));
        assertEquals(11, legalMove.size());
        //milieu
        legalMove.clear();
        Board.lesCase.get(32).setPiece(null);
        Board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(35),true));
        legalMove.addAll(Board.lesCase.get(35).getPiece().legalMovSquares(Board.lesCase.get(35)));
        assertEquals(11, legalMove.size());  
        //droite
        legalMove.clear();
        Board.lesCase.get(35).setPiece(null);
        Board.lesCase.get(39).setPiece(new Rook(Piece.PieceType.ROOK,Board.p.getColor(),
                                        Board.lesCase.get(39),true));
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(11, legalMove.size());
    }
     /**
     * Method under test: {@link Rook#isColumnExclusionLeft(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(32).setPiece(new Rook( Piece.PieceType.ROOK,"White", Board.lesCase.get(32), true));
        Square s = Board.lesCase.get(32);
        Rook r = (Rook)Board.lesCase.get(32).getPiece();
        int[] nextMove = new int[]{-1};
        for(int i : nextMove){
            int nextMv = 32 + i;
            assertFalse(r.isColumnExclusionLeft(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Rook(Piece.PieceType.ROOK, "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        r = (Rook)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(r.isColumnExclusionLeft(1,s,nextMv));
        }
        // test si la position 31 est sur la même ligne ou non à la 4 ieme case
        Board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK, "White", Board.lesCase.get(35), true));
        r = (Rook)Board.lesCase.get(35).getPiece();
        s = Board.lesCase.get(35);
        assertFalse(r.isColumnExclusionLeft(4,s,31));
    }
    /**
     * Method under test: {@link Rook#isColumnExclusionRight(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(32).setPiece(new Rook( Piece.PieceType.ROOK,"White", Board.lesCase.get(32), true));
        Square s = Board.lesCase.get(32);
        Rook r = (Rook)Board.lesCase.get(32).getPiece();
        int[] nextMove = new int[]{1};
        for(int i : nextMove){
            int nextMv = 32 + i;
            assertTrue(r.isColumnExclusionRight(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Rook(Piece.PieceType.ROOK, "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        r = (Rook)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(r.isColumnExclusionRight(1,s,nextMv));
        }
        // test si la position 31 est sur la même ligne ou non à la 4 ieme case
        Board.lesCase.get(35).setPiece(new Rook(Piece.PieceType.ROOK, "White", Board.lesCase.get(35), true));
        r = (Rook)Board.lesCase.get(35).getPiece();
        s = Board.lesCase.get(35);
        assertFalse(r.isColumnExclusionRight(4,s,31));

    }
}

