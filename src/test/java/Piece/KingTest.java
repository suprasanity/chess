package Piece;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jeu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        King k = new King(Piece.PieceType.KING, "Color", new Square('A', 10), true);
        assertEquals("Color",k.getColor());
        assertEquals(Piece.PieceType.KING, k.pieceType);
        assertTrue(k.isFirstMove);
        assertEquals('♔', k.getSymbol());
        assertEquals("Roi Color", k.toString());
    }
    /**
     * Method under test: {@link King#legalMovSquares(Square)}
     */
    @Test
    void testLegalMovSquaresWhite() {
        Board p = new Board(new Player(MesConstantes.WHITE,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        legalMove.addAll(Board.lesCase.get(4).getPiece().legalMovSquares(Board.lesCase.get(4)));
        assertEquals(0, legalMove.size());
        // test toutes les positions possible
        Board.lesCase.get(27).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(27),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(27).getPiece().legalMovSquares(Board.lesCase.get(27)));
        assertEquals(8, legalMove.size());
        // test si le roi n'attaque pas le pion
        Board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,Board.p.getColor()
        ,Board.lesCase.get(38),true));
        Board.lesCase.get(39).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(39),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(4, legalMove.size());
        // test si le roi peut attaque le pion
        Board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,Board.p.getOpponnentColor()
        ,Board.lesCase.get(38),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(5, legalMove.size());
        // test si n'est pas en dehors du tableau de la gauche
        Board.lesCase.get(32).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(32),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(32).getPiece().legalMovSquares(Board.lesCase.get(32)));
        assertEquals(5, legalMove.size());
    }
    @Test
    void testLegalMovSquaresBlack() {
        Board p = new Board(new Player(MesConstantes.BLACK,"Yann"));
        List <Move> legalMove = new ArrayList<>();
        legalMove.addAll(Board.lesCase.get(60).getPiece().legalMovSquares(Board.lesCase.get(60)));
        assertEquals(0, legalMove.size());
        // test toutes les positions possible
        Board.lesCase.get(27).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(27),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(27).getPiece().legalMovSquares(Board.lesCase.get(27)));
        assertEquals(8, legalMove.size());
        // test si le roi n'attaque pas le pion
        Board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,Board.p.getColor()
        ,Board.lesCase.get(38),true));
        Board.lesCase.get(39).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(39),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(4, legalMove.size());
        // test si le roi peut attaque le pion
        Board.lesCase.get(38).setPiece(new Pawn(Piece.PieceType.PAWN,Board.p.getOpponnentColor()
        ,Board.lesCase.get(38),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(39).getPiece().legalMovSquares(Board.lesCase.get(39)));
        assertEquals(5, legalMove.size());
        // test si n'est pas en dehors du tableau de la gauche
        Board.lesCase.get(32).setPiece(new King(Piece.PieceType.KING,Board.p.getColor()
        ,Board.lesCase.get(32),true));
        legalMove.clear();
        legalMove.addAll(Board.lesCase.get(32).getPiece().legalMovSquares(Board.lesCase.get(32)));
        assertEquals(5, legalMove.size());
    }
    /**
     * Method under test: {@link King#isColumnExclusionLeft(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionLeft(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        Board.lesCase.get(16).setPiece(new King( Piece.PieceType.KING,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        King k = (King)Board.lesCase.get(16).getPiece();
        int[] nextMove = new int[]{-9,-1,7};
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertFalse(k.isColumnExclusionLeft(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new King(Piece.PieceType.KING, "White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (King)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertTrue(k.isColumnExclusionLeft(1,s,nextMv));
        }
    }
    /**
     * Method under test: {@link King#isColumnExclusionRight(int,Square,int)}
     */
    @Test
    void testIsColumnExclusionRight(){
        Board p = new Board(new Player(MesConstantes.WHITE,"Pascal"));
        int[] nextMove = new int[]{-7,1,9};
        Board.lesCase.get(16).setPiece(new King( Piece.PieceType.KING,"White", Board.lesCase.get(16), true));
        Square s = Board.lesCase.get(16);
        King k = (King)Board.lesCase.get(16).getPiece();
        for(int i : nextMove){
            int nextMv = 16 + i;
            assertTrue(k.isColumnExclusionRight(1,s,nextMv));
        }
        Board.lesCase.get(31).setPiece(new King( Piece.PieceType.KING,"White", Board.lesCase.get(31), true));
        s = Board.lesCase.get(31);
        k = (King)Board.lesCase.get(31).getPiece();
        for(int i : nextMove){
            int nextMv = 31 + i;
            assertFalse(k.isColumnExclusionRight(1,s,nextMv));
        }
    }
}