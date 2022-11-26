package Piece;

import jeu.Move;
import jeu.Square;

import java.util.List;

public interface Piece {
 void setColor(String color);
 String getColor();
 int getValue();
 void setSymbol(String color);
 char getSymbol();
  List<Move> legalMovSquares(Square square);
  boolean isFirstMove();
}
