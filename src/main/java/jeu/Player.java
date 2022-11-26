package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.Piece;

public class Player {
    private final String color;
    private final String name;
    public Player(String color,String name){
        this.color = (color.equals("Black") ? "Black" : "White");
        this.name = name;
    }
    public String getCurrentColor(){
        return this.color;
    }
    public String getOpponnentColor(){
        return (this.color.equals("Black") ? "White" : "Black");
    }
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
    //maybe make this into attr 
    public static int getDirection(){return -1;}
    public static int getOpponentDirection(){return 1;}
}
