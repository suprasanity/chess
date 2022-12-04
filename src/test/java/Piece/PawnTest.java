package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.Board;
import jeu.MesConstantes;
import jeu.Player;
import jeu.Square;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PawnTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Pawn#Pawn(Piece.PieceType, String, Square, boolean)}
     *   <li>{@link Pawn#toString()}
     * </ul>
     */

    /**
     * Method under test: {@link Pawn#Pawn(Piece.PieceType, String, Square, boolean)}
     */
    @Test
    void testConstructor2() {
        Pawn actualPawn = new Pawn(Piece.PieceType.PAWN, "Color", new Square('A', 10), true);

        assertEquals("Color", actualPawn.getColor());
        assertEquals(Piece.PieceType.PAWN, actualPawn.pieceType);
        assertTrue(actualPawn.isFirstMove);
        assertEquals('♙', actualPawn.getSymbol());
    }


    @Test
    void testLegalMovSquaresWhite() {
        Board p = new Board();
        p.initPlayeur(new Player(p,MesConstantes.WHITE,"Yann"),new Player(p,MesConstantes.BLACK,"test"));

        Pawn pawn = new Pawn(Piece.PieceType.PAWN, MesConstantes.WHITE, new Square('A', 2), true);
        Square maCaseATester=new Square('A', 2);
        maCaseATester.setPiece(pawn);
        assertTrue(pawn.legalMovSquares(maCaseATester,p).contains(new Square('A', 3)));

    }

    @Test
    void testLegalMovSquaresJoueurBlack() {
        Board p = new Board();
        p.initPlayeur(new Player(p,MesConstantes.WHITE,"Yann"),new Player(p,MesConstantes.BLACK,"test"));


        Pawn pawn = new Pawn(Piece.PieceType.PAWN, MesConstantes.BLACK, new Square('A', 7), true);
        Square maCaseATester=new Square('A', 7);
        maCaseATester.setPiece(pawn);
        assertTrue(pawn.legalMovSquares(maCaseATester,p).contains(new Square('A', 3)));

    }

}

