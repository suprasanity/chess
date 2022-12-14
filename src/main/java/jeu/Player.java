package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.Piece;

public class Player {
    //class abstraite/static , settings
    private final String color;
    private final String name;
    public Player(String color,String name){
        this.color = (color.equals("Black") ? "Black" : "White");
        this.name = name;
    }
    public static String getCurrentColor(){return this.color;}
    public static String getOpponnentColor(){return (this.color.equals("Black") ? "Black" : "White");}
    public List<Piece> getAllPieces(List<Square> board){
        List<Piece> listOfPiece = new ArrayList<>();
        for(Square square : board){
            if(square.getPiece()!=null){
                listOfPiece.add(square.getPiece());
            }
        }
        return listOfPiece;
    }
    public List<Square> getAttacksOnSquare(List<Square> Board){
        return null;
    }
    public List<Square> getOpponentAttacksOnSquare(List<Square> Board){return null;}
    public static int getDirection(){return 1;}
    public static int getOpponentDirection(){return -1;}
}
