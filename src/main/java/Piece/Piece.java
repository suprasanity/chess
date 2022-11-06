package Piece;

import jeu.Square;

import java.util.List;

public interface Piece {
 void setColor(String color);
 String getColor();
 int getValue();

  List<Square> listCoupPossible = null;
}
