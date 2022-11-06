package jeu;

import Piece.Piece;

public class Square {
    private char letter;
    private int number;
    private Piece piece;
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
    @Override
    public String toString() {
        return "jeu.Case{" +
                "lettre=" + letter +
                ", number=" + number +
                ", piece=" + piece +
                '}';
    }
}
