package Piece;



import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class Bishop implements Piece{
    private String color;
    private final int VALUE = 3;
    private char symbol;
    private final int[] listDirection = new int[] {-9,9,-7,7}; 
    private boolean firstMove = false;
    public void setFirstMove(){
        this.firstMove = true;
    }
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265D': '\u2657';
    }
    public List<Move> legalMovSquares(Square square){
        int index=0;
        int buff=1;
        List<Move> legalMove = new ArrayList<>();
        if(square.getPiece() instanceof Bishop){
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                while(1==1){
                    if(isColumnExclusionLeft(buff, square, nextPossibleSquare) || 
                    isColumnExclusionRight(buff, square, nextPossibleSquare) ){
                        if(nextPossibleSquare<=Board.END_INDEX_BOARD 
                        && nextPossibleSquare>=Board.START_INDEX_BOARD){
                            if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                                legalMove.add(new Move(nextPossibleSquare,index, Board.lesCase
                                              .get(index).getPiece()));// move constructor(destination coord, current coord,piece,) 
                                nextPossibleSquare+=direction;
                                buff++;
                            }
                            else{
                                if(Board.lesCase.get(nextPossibleSquare).getPiece()
                                    .getColor().equals("White")){
                                    legalMove.add(new Move(nextPossibleSquare,index, Board.lesCase
                                    .get(index).getPiece()));
                                    break;
                                }else{break;}
                            }
                        }else{break;}
                    }else{break;}
                }buff=1;
            }
        }
        return legalMove;
    }
    public boolean isColumnExclusionLeft(int step,Square currSquare,int indexNextSquare){ // static ? 
        char currLetter = currSquare.getLetter();// modify
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter - step;
            Board.LETTER.get(indexNextLetter);
            return (Board.lesCase.get(indexNextSquare).getLetter()
                    ==(Board.LETTER.get(indexNextLetter))) ? true : false;
                
        }catch(Exception e){
            return false;
        }
    }
    public boolean isColumnExclusionRight(int step, Square currSquare,int indexNextSquare){
        char currLetter = currSquare.getLetter();
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);//need modify
        int indexNextLetter;
        try{
            indexNextLetter= indexCurrLetter + step;
            Board.LETTER.get(indexNextLetter);
            return (Board.lesCase.get(indexNextSquare).getLetter()
                    ==(Board.LETTER.get(indexNextLetter))) ? true : false;
                
        }catch(Exception e){
            return false;
        }
    }
    public boolean isFirstMove(){
        return this.firstMove;
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
    @Override
    public String toString(){
        return "Fou " +this.color;
    }


}
