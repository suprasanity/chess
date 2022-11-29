package jeu;

import Piece.Piece;

import java.util.Objects;

public class Square {
    private char letter;
    private int number;
    private Piece piece;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return letter == square.letter && number == square.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, number, piece);
    }

    public Square(char letter, int number){
        this.letter=letter;
        this.number=number;
    }

    public void setPiece(Piece p){this.piece=p;}
    public int getNumber(){return this.number;}
    public char getLetter() {
        return letter;
    }
    public Piece getPiece(){
        return this.piece;
    }

    //override not on parameters, function below delete 
    public boolean equalSquare(Square other){
        return (other.letter==this.letter && other.number==this.number);
    }
    public static boolean isValidSquare(Square other){
        return false;
    }
    public static boolean isOccupied(Square other){return false;}

    @Override
    public String toString() {
        return "jeu.Case{" +
                "lettre=" + letter +
                ", number=" + number +
                ", piece=" + piece +
                '}';
    }
}
