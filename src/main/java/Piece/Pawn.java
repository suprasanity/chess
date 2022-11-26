package Piece;


import jeu.Board;
import jeu.Move;
import jeu.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pawn implements Piece {
    private String color;
    private final int VALUE = 1;
    private char symbol;
    private boolean firstMove;
    public void setColor(String color){
        this.color=color;
      
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265F' : '\u2659';
    }
    public char getSymbol(){
        return this.symbol;
    }
    public String getColor(){
        return this.color;
    }
    
    public int getValue(){
        return this.VALUE;
    }
    public boolean isFirstMove(){
        return this.firstMove;
    }
    public List<Move> legalMovSquares(Square square){
        List<Move> legalMove = new ArrayList<>();
        int index =0;
        int[] listDirection;
        if(square.getPiece() instanceof Pawn){
            //case if row 7 or row 2
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            // pawn attack piece each side if exist
            
            listDirection = new int[]{-7,-9};
            for(int direction : listDirection){
                int nextPossibleMove = direction + index;
                if(Board.lesCase.get(nextPossibleMove).getPiece() != null
                    && Objects.equals(Board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                                      Board.p.getOpponnentColor()))
                {
                    legalMove.add(new Move(nextPossibleMove, index, new Pawn()));
                }
            }
            // pawn just move
            if(square.getNumber() == 2 && Board.p.getCurrentColor().equals("White") ||
               square.getNumber()== 7 && Board.p.getCurrentColor().equals("Black")){
                listDirection = new int[]{-8,-16};
                for(int direction : listDirection){
                    int nextPossibleSquare = direction + index;
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare,index,new Pawn()));
                    }
                }
            }
            else{
                int direction = -8;
                int nextPossibleSquare = direction + index;
                if(nextPossibleSquare>=Board.START_INDEX_BOARD){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare, index, new Pawn()));
                    }
                }
            } 
        }
        return legalMove;     
    }
    @Override
    public String toString() {
        return "pion " +this.color;
    }


}
