package Piece;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class Knight implements Piece{
    private String color;
    private final int VALUE = 3;
    private char symbol;
    private final int[] listDirection = new int[]{6,-6,15,-15,17,-17,10,-10};
    private boolean firstMove = false;
    public void setFirstMove(){this.firstMove = true;}
    public boolean isFirstMove(){
        return this.firstMove;
    }
    public List<Move> legalMovSquares(Square square){
        int index=0;
        int buff=1;
        List<Move> legalMove = new ArrayList<>();
        if(square.getPiece() instanceof Knight){
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                
                if((isColumnExclusionLeft(buff, square, nextPossibleSquare) ||
                   isSecondColumnExclusionLeft(buff, square, nextPossibleSquare)) || 
                   isColumnExclusionRight(buff, square, nextPossibleSquare) ||
                   isSecondColumnExclusionRight(buff, square, nextPossibleSquare) ){
                    if(nextPossibleSquare<=Board.END_INDEX_BOARD 
                    && nextPossibleSquare>=Board.START_INDEX_BOARD){
                        if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                            legalMove.add(new Move(nextPossibleSquare,index, Board.lesCase
                            .get(index).getPiece()));// move constructor(destination coord, current coord,piece,) 
                        }
                        else{
                            if(!(Board.lesCase.get(nextPossibleSquare).getPiece()
                                .getColor().equals(square.getPiece().getColor()))){

                                legalMove.add(new Move(nextPossibleSquare,index, Board.lesCase
                                .get(index).getPiece()));
                            }
                        }
                    }
                }
                
            }
        }
        return legalMove;
    }
    public boolean isSecondColumnExclusionLeft(int step,Square currSquare,int indexNextSquare){
        return isColumnExclusionLeft(step+1, currSquare, indexNextSquare);
    }
    public boolean isSecondColumnExclusionRight(int step,Square currSquare, int indexNextSquare){
        return isColumnExclusionRight(step+1,currSquare, indexNextSquare);
    }
    public boolean isColumnExclusionLeft(int step,Square currSquare,int indexNextSquare){ // static ? 
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
        this.symbol = (color.equals("Black")) ? '\u265E' : '\u2658';
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
        return "Cavalier "+this.color;
    }
    public void PrintUnicode(){
        PrintWriter printWriter = new PrintWriter(System.out,true);
        char aa = '\u2658';
        printWriter.println(aa);
    }
}
