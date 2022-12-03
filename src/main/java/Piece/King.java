package Piece;

import java.util.ArrayList;
import java.util.List;

import jeu.Board;
import jeu.Move;
import jeu.Square;

public class King implements Piece{
    private String color;
    private final int VALUE = -1;
    private char symbol;
    private boolean firstMove=true;
    //private final int[] listDirection = new int[]{-8,-9,-1,9,8,7,1,-7}; 
    public void setFirstMove(){this.firstMove = true;}
    public boolean isFirstMove(){
        return this.firstMove;
    }
    //filtre tous les moves possible => isoccupiedsquare
    public List<Move> moveSquaresReal(Square square){
        List<Move> realMove = new ArrayList<>();
        for(Move mv : legalMovSquares(square)){
            if(!(Square.isOccupiedSquare(mv))){
                realMove.add(mv);
            }
        }
        return realMove;
    }
    public List<Move> legalMovSquares(Square square){ // castling ? 
        List<Move> legalMove = new ArrayList<>();
        int[] listDirection;
        int index=0;
        int buff=1;
        if(square.getPiece() instanceof King){
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                    break;
                }
            }
            listDirection = new int[]{-9,-1,9,7,1,-7};
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                   //maybe better =>  for(){}
                if((isColumnExclusionLeft(buff, square, nextPossibleSquare) || 
                    isColumnExclusionRight(buff, square, nextPossibleSquare))){
                    if(nextPossibleSquare<=Board.END_INDEX_BOARD 
                        && nextPossibleSquare>=Board.START_INDEX_BOARD
                        ){ // boucle infini si method isOccupied impl
                            if(Board.lesCase.get(nextPossibleSquare).getPiece()==null){
                                legalMove.add(new Move(nextPossibleSquare,index,Board.lesCase
                                .get(index).getPiece()));// move constructor(destination coord, current coord,piece,) 
                            }
                            else{
                                if(!(Board.lesCase.get(nextPossibleSquare).getPiece()
                                    .getColor().equals(square.getPiece().getColor()))){
                                    legalMove.add(new Move(nextPossibleSquare,index,Board.lesCase
                                    .get(index).getPiece()));
                                }
                            }
                        }
                    }
               
            }
            listDirection = new int[]{8,-8};
            for(int direction : listDirection){
                int nextPossibleSquare = direction + index;
                if(nextPossibleSquare>=Board.START_INDEX_BOARD
                && nextPossibleSquare<=Board.END_INDEX_BOARD
                ){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare, index, Board.lesCase.get(index).getPiece()));
                    }
                    else{
                        if(!(Board.lesCase.get(nextPossibleSquare).getPiece().getColor()
                        .equals(square.getPiece().getColor()))){
                            legalMove.add(new Move(nextPossibleSquare, index, Board.lesCase.get(index).getPiece()));
                        }
                    }
                }   
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
        this.symbol = (color.equals("Black")) ? '\u265A': '\u2654';
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
        return "Roi " + this.color;
    }
}
