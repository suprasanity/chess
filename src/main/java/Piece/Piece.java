package Piece;

import jeu.Board;
import jeu.Move;
import jeu.Square;

import java.util.List;
import java.util.Objects;

public abstract class Piece {

 final PieceType pieceType;
  final String color;
  final boolean isFirstMove;
    private Square piecePosition;
 private char symbol;


 public int getPieceValue() {
  return this.pieceType.getPieceValue();
 }

 Piece(final PieceType type,
       final String color,
        Square piecePosition,
        boolean isFirstMove) {
  this.pieceType = type;;
  this.color = color;
  this.isFirstMove = isFirstMove;
  this.piecePosition = piecePosition;
 }

 public char getSymbol() {
  return this.symbol;
 }

 protected void setSymbol(char symb) {
  this.symbol = symb;
 }

 public String getColor() {
  return this.color;
 }

public abstract List<Move> legalMovSquares(Square piecePosition) ;

 public Square getPiecePosition() {
  for (Square square : Board.lesCase) {
   if (square.getPiece() == this) {
    return square;
   }
  }
    return null;
 }

 public enum PieceType {

  PAWN(100, "P"),
  KNIGHT(300, "N"),
  BISHOP(330, "B"),
  ROOK(500, "R"),
  QUEEN(900, "Q"),
  KING(10000, "K");

  private final int value;
  private final String pieceName;

  public int getPieceValue() {
   return this.value;
  }

  @Override
  public String toString() {
   return this.pieceName;
  }

  PieceType(final int val,
            final String pieceName) {
   this.value = val;
   this.pieceName = pieceName;
  }

 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  Piece piece = (Piece) o;
  return  symbol == piece.symbol && pieceType == piece.pieceType && Objects.equals(color, piece.color) && Objects.equals(piecePosition, piece.piecePosition);
 }

 @Override
 public int hashCode() {
  return Objects.hash(pieceType, color, isFirstMove, piecePosition, symbol);
 }
}
