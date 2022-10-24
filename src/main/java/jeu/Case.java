package jeu;

import Piece.Piece;

public class Case {


    private char lettre;
    private int number;
    private Piece piece;
    public Case(char lettre, int number){
        this.lettre=lettre;
        this.number=number;
    }

    public void setPiece(Piece p){this.piece=p;}
    public int getNumber(){return this.number;}
    public char getLettre() {
        return lettre;
    }
    public Piece getPiece(){
        return this.piece;
    }
    @Override
    public String toString() {
        return "jeu.Case{" +
                "lettre=" + lettre +
                ", number=" + number +
                ", piece=" + piece +
                '}';
    }
}
