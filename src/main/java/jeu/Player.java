package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.King;
import Piece.Pawn;
import Piece.Piece;

public class Player {
    private final String color;
    private final String name;
    public static final int DIRECTION = -1;
    public static final int OPPONENT_DIRECTION = 1; 
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
    public List<Move> getAttacksOnSquare(){ // le cas du pat 
        List<Move> allOpponentMove = new ArrayList<>();
        for(Square square : Board.lesCase){
            if(square.getPiece() instanceof Pawn){
                Pawn pawn = (Pawn)square.getPiece();
                if(square.getPiece().getColor().equals(getCurrentColor())){
                    for(Move move : pawn.attackMove(square)){//need check
                        allOpponentMove.add(move);
                    }
                }
            }
            else{
                    if(square.getPiece() instanceof Piece){
                        if(square.getPiece().getColor().equals(getCurrentColor())){
                            for(Move move : square.getPiece().legalMovSquares(square)){//need check
                                allOpponentMove.add(move);
                            }
                        }
                    }
                
            } 
        }
        return allOpponentMove;
    }
    
    public List<Move> getOpponentAttacksOnSquare(){ // board
        List<Move> allOpponentMove = new ArrayList<>();
        for(Square square : Board.lesCase){
            if(square.getPiece() instanceof Pawn){
                Pawn pawn = (Pawn)square.getPiece();
                if(square.getPiece().getColor().equals(getOpponnentColor())){
                    for(Move move : pawn.attackMove(square)){//need check
                        allOpponentMove.add(move);
                    }
                }
            }
            else{
                
                    if(square.getPiece() instanceof Piece){
                        if(square.getPiece().getColor().equals(getOpponnentColor())){
                            for(Move move : square.getPiece().legalMovSquares(square)){//need check
                                allOpponentMove.add(move);
                            }
                        }
                    }
                
            } 
        }
        return allOpponentMove;
    }
  
}
