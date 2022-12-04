package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import jeu.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Method under test: {@link Pawn#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhiteWithAttaque(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        for(Square s :Board.lesCase){
            if(s.getLetter() == 'A' && s.getNumber() == 6){
                legalMove.addAll(s.getPiece().legalMovSquares(s));
            }
        }
        assertEquals(1, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack() {
        Board p = new Board(new Player(MesConstantes.BLACK,"Yann"));

    }

}

