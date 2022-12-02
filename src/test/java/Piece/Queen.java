package Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class QueenTest {
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
     * Method under test: {@link King#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquares() {
        Board p = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        for(Square s :Board.lesCase){
            if(s.getLetter() == 'A' && s.getNumber() == 3){
                legalMove.addAll(s.getPiece().legalMovSquares(s));
            }
        }
        assertEquals(15, legalMove.size());
    }
}

