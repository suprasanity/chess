package jeu;

import Piece.Piece;

import java.util.List;
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




    public static boolean isOccupiedSquare(Move mv, Board b){
        List<Move> qsd;

        if(mv.getPiece().getColor().equals("Black")){
            if(b.p.getColor().equals("Black")){
                qsd = b.p.getOpponentAttacksOnSquare(b);
            }
            else{
                qsd = b.p.getAttacksOnSquare(b);
            }
        }else{
            if(b.p.getColor().equals("White")){
                qsd = b.p.getOpponentAttacksOnSquare(b);
            }
            else{
                qsd = b.p.getAttacksOnSquare(b);
            }
        }
        for(Move move : qsd){
            if(move.getDestCoord() == mv.getDestCoord()){
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
