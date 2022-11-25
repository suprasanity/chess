package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class Rook implements Piece {
    private String color ;
    private final int VALUE = 5;
    private char symbol;
    private final int[] listDirection = new int[]{-1,1,8,-8};
    public boolean isFirstMove(){
        return false;
    }
    public List<Move> legalMovSquares(Square square){
        int index=0;
        int buff=1;
        List<Move> legalMove = new ArrayList<>();
        if(square.getPiece() instanceof Rook){
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                while(1==1){
                    if((isColumnExclusionLeft(buff, square, nextPossibleSquare) || 
                    isColumnExclusionRight(buff, square, nextPossibleSquare)) || 
                    (direction == 8 || direction ==-8)){
                        if(nextPossibleSquare<Board.END_INDEX_BOARD 
                        && nextPossibleSquare>Board.START_INDEX_BOARD){
                            if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                                
                                legalMove.add(new Move(nextPossibleSquare,index, new Rook()));// move constructor(destination coord, current coord,piece,) 
                                nextPossibleSquare+=direction;
                                buff++;
                            }
                            else{
                                if(Board.lesCase.get(nextPossibleSquare).getPiece()
                                    .getColor().equals("White")){
                                    legalMove.add(new Move(nextPossibleSquare,index, new Rook()));
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
    public boolean isColumnExclusionLeft(int step,Square currSquare,int indexNextSquare){
        char currLetter = currSquare.getLetter();
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
        int indexCurrLetter = Board.LETTER.indexOf(currLetter);
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
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265C' : '\u2656';
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
    public String toString() {
        return "Tour "+this.color;
    }
    
}
