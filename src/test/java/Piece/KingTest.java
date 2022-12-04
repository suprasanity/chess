package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.Square;
import org.junit.jupiter.api.Test;

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
        assertEquals("Roi Color", (new King(Piece.PieceType.PAWN, "Color", new Square('A', 10), true)).toString());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor2() {
        King actualKing = new King(Piece.PieceType.PAWN, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.PAWN, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor3() {
        King actualKing = new King(Piece.PieceType.PAWN, (String) "Black", new Square('A', 10), true);

        assertEquals("Black", actualKing.getColor());
        assertEquals(Piece.PieceType.PAWN, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♚', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor4() {
        King actualKing = new King(Piece.PieceType.KNIGHT, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.KNIGHT, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor5() {
        King actualKing = new King(Piece.PieceType.BISHOP, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.BISHOP, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor6() {
        King actualKing = new King(Piece.PieceType.ROOK, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.ROOK, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor7() {
        King actualKing = new King(Piece.PieceType.QUEEN, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.QUEEN, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#King(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor8() {
        King actualKing = new King(Piece.PieceType.KING, "Color", new Square('A', 10), true);

        assertEquals("Color", actualKing.getColor());
        assertEquals(Piece.PieceType.KING, actualKing.pieceType);
        assertTrue(actualKing.isFirstMove);
        assertEquals('♔', actualKing.getSymbol());
    }

    /**
     * Method under test: {@link King#legalMovSquares(Square)}
     */
   /* @Test
    void testLegalMovSquares() {
        King king = new King(Piece.PieceType.PAWN, "Color", new Square('A', 10), true);
        assertTrue(king.legalMovSquares(new Square('A', 10)).isEmpty());
    }*/
}

