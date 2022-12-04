package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KnightTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Knight#Knight(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link Knight#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Knight k = new Knight(Piece.PieceType.KNIGHT, "Color", new Square('A', 10), true);
        assertEquals("Cavalier Color", k.toString());
        assertEquals("Color", k.getColor());
        assertEquals(Piece.PieceType.KNIGHT, k.pieceType);
        assertTrue(k.isFirstMove);
        assertEquals('♘', k.getSymbol());
    }
    /**
     * Method under test: {@link Knight#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board p1 = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        // test si les prochains move du cavalier ne sont pas en dehors du board et n'attaque pas ses propres pièces
        legalMove.addAll(Board.lesCase.get(1).getPiece().legalMovSquares(Board.lesCase.get(1)));
        assertEquals(2, legalMove.size());

        // test si cavalier mange les pions 
        legalMove.clear();
        Board.lesCase.get(35).setPiece(new Knight(Piece.PieceType.KNIGHT,
         Board.p.getColor(), Board.lesCase.get(35), true));
         legalMove.addAll(Board.lesCase.get(35).getPiece().legalMovSquares(Board.lesCase.get(35)));
         assertEquals(8, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack(){
        Board p1 = new Board(new Player(MesConstantes.BLACK,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        // test si les prochains move du cavalier ne sont pas en dehors du board et n'attaque pas ses propres pièces
        legalMove.addAll(Board.lesCase.get(57).getPiece().legalMovSquares(Board.lesCase.get(57)));
        assertEquals(2, legalMove.size());

        // test si cavalier mange les pions 
        legalMove.clear();
        Board.lesCase.get(27).setPiece(new Knight(Piece.PieceType.KNIGHT,
         Board.p.getColor(), Board.lesCase.get(27), true));
         legalMove.addAll(Board.lesCase.get(27).getPiece().legalMovSquares(Board.lesCase.get(27)));
         assertEquals(8, legalMove.size());
    }
     /**
     * Method under test: {@link Knight#isColumnExclusionLeft(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Knight k = (Knight)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-17,15};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isColumnExclusionLeft(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Knight(Piece.PieceType.KNIGHT, "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (Knight)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isColumnExclusionLeft(1,s,nextMv));
        }
    }
    /**
     * Method under test: {@link Knight#isColumnExclusionRight(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        int[] nextMove = new int[]{-15,17};
        Board.lesCase.get(16).setPiece(new Knight(Piece.PieceType.KNIGHT, "White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Knight k = (Knight)Board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isColumnExclusionRight(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (Knight)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isColumnExclusionRight(1,s,nextMv));
        }
    }
    /**
     * Method under test: {@link Knight#isSecondColumnExclusionLeft(int,Square,int)}
     */
    @Test
    void testIsSecondColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Knight k = (Knight)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-10,6};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isSecondColumnExclusionLeft(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (Knight)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isSecondColumnExclusionLeft(1,s,nextMv));
        }
    }
    /**
     * Method under test: {@link Knight#isSecondColumnExclusionRight(int,Square,int)}
     */
    @Test
    void testIsSecondColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        Knight k = (Knight)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{10,-6};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isSecondColumnExclusionRight(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new Knight( Piece.PieceType.KNIGHT,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (Knight)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isSecondColumnExclusionRight(1,s,nextMv));
        }
    }

}

