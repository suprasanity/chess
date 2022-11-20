package jeu;

import Piece.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public static List<Square> lesCase = new ArrayList<>();
    //on suppose que 0=>A ... 7=>H
    public static final List<Character> LETTER = arrayToListChar("ABCDEFGH".toCharArray());
    
    public Board() {
        initCase();
        initPiece();
        initCouleur();

    }
    private static List<Character> arrayToListChar(char[] array){
        List<Character> listOfChar = new ArrayList<>(); 
        for(char i : array){
            listOfChar.add((Character)i);
        }
        return listOfChar;
    }
    
    private void initCouleur() {
        for (Square c : lesCase) {
            if (c.getNumber() == 1 || c.getNumber() == 2) {
                c.getPiece().setColor("White");
            } else if(c.getNumber() == 7 || c.getNumber() == 8) {
                c.getPiece().setColor("Black");
            }
        }
    }

    public void initCase() {
        for (int i = 1; i <= 8; i++) {
            for (char c : Board.LETTER)
                lesCase.add(new Square(c, i));
        }
    }

    public void initPiece() {
        for (Square c : lesCase) {
            if (c.getNumber() == 2 || c.getNumber() == 7) {
                c.setPiece(new Pawn());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLetter() == 'A' || c.getLetter() == 'H')) {
                c.setPiece(new Rook());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLetter() == 'B' || c.getLetter() == 'G')) {
                c.setPiece(new Knight());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLetter() == 'C' || c.getLetter() == 'F')) {
                c.setPiece(new Bishop());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLetter() == 'D')) {
                c.setPiece(new Queen());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLetter() == 'E')) {
                c.setPiece(new King());
            }
        }

    }

    public void afficherPlateau() {
        for (Square c : lesCase) {
            System.out.println(c);
        }
        int buff = 0;
        System.out.print(" ");
        for(char letter : Board.LETTER){
            System.out.print("  "+letter);
        }
        System.out.println("");
        for(int i=0;i<lesCase.size();i++){
            if(i%8==0){
            System.out.print(lesCase.get(i).getNumber());
            buff = i;
            for(int y=0;y<=(lesCase.size()/8)*2;y++){
                if(y%2==0){
                    System.out.print(" |");
                }
                else{
                    if(lesCase.get(buff).getPiece() != null){
                        System.out.print(lesCase.get(buff).getPiece().getSymbol());
                    }
                    else{
                        System.out.print("_");
                    }
                    buff++;
                }
            }
            System.out.println("");
        }
    }
}
    public void MovePiece(Square caseDepart,Square caseArrive){
        caseArrive.setPiece(caseDepart.getPiece());
        caseDepart.setPiece(null);
    }
}
