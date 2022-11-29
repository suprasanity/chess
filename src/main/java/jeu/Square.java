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

    //override not on parameters, function below delete 
    @Override
    public boolean equals(Object other){
        if(other instanceof Square){
            Square square = (Square) other;
            return (square.letter==this.letter && square.number==this.number);
        }
        return false;
    }
    public static boolean isValidSquare(Square other){
        return false;
    }
    public static boolean isOccupiedSquare(int nextMove){
        for(Move move : Board.p.getOpponentAttacksOnSquare()){
            if(move.getDestCoord() == nextMove){
                return true;
            }
        }
        return false;
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
