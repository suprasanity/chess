package Piece;


import jeu.Board;
import jeu.Move;
import jeu.Player;
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
    private boolean firstMove = false;
    public void setFirstMove(){this.firstMove = true;}
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
    // check attack of pawn even if there's no pieces, used for allOpponentAttack
    public List<Move> attackMove(Square square){
        List<Move> legalMove = new ArrayList<>();
        int index = 0;
        int directionSide = (square.getPiece().getColor()
                            .equals(Board.p.getCurrentColor()))
                            ?Player.DIRECTION: Player.OPPONENT_DIRECTION;
        int[] listDirection;
        if(square.getPiece() instanceof Pawn){
                //case if row 7 or row 2
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                        index = Board.lesCase.indexOf(findSquare);
                    }
            }
            // pawn attack piece each side if exist
            // if color of the piece equal to the color assigned for the player then we change the direction
            listDirection = new int[]{7,9};
            for(int direction : listDirection){
                int nextPossibleMove = direction * directionSide + index;
                if(Board.lesCase.get(nextPossibleMove).getPiece() == null 
                   && isColumnExclusionRight(1, square, nextPossibleMove)
                   || isColumnExclusionLeft(1, square, nextPossibleMove)){
                    legalMove.add(new Move(nextPossibleMove, index,Board.lesCase
                                 .get(index).getPiece()));
                }
                                        
            }
        }
        return legalMove;
    }
    // method used for determinate all move possible include when there's pieces on the two sides
    public List<Move> legalMovSquares(Square square){
        List<Move> legalMove = new ArrayList<>();
        int index =0;
        int[] listDirection;
        int directionSide = (square.getPiece().getColor()
                            .equals(Board.p.getCurrentColor()))
                            ?Player.DIRECTION: Player.OPPONENT_DIRECTION; 
        if(square.getPiece() instanceof Pawn){
            //case if row 7 or row 2
            for(Square findSquare : Board.lesCase){// en trop ? mettre getid pour chaque case ?
                if(square.equals(findSquare)){
                    index = Board.lesCase.indexOf(findSquare);
                }
            }
            // pawn attack piece each side if exist
            // if color of the piece equal to the color assigned for the player then we change the direction
            listDirection = new int[]{7,9};
            for(int direction : listDirection){
                int nextPossibleMove = direction * directionSide + index;
                if(Board.lesCase.get(nextPossibleMove).getPiece() != null
                   && (isColumnExclusionRight(1, square, nextPossibleMove)
                   || isColumnExclusionLeft(1, square, nextPossibleMove))){
                    if(!(Objects.equals(Board.lesCase.get(nextPossibleMove).getPiece().getColor(),
                                      square.getPiece().getColor())))
                    {
                    legalMove.add(new Move(nextPossibleMove, index,Board.lesCase
                    .get(index).getPiece()));
                    }
                }
                    
            }
            // pawn move 2 squares forward 
            if(square.getNumber() == 2 && square.getPiece().getColor().equals("White") ||
               square.getNumber()== 7 && square.getPiece().getColor().equals("Black")){
                listDirection = new int[]{8,16};
                for(int direction : listDirection){
                    int nextPossibleSquare = direction * directionSide + index;
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare,index,Board.lesCase
                        .get(index).getPiece()));
                    }else{
                        break;
                    }
                    
                }
            }
            else{ // move 1 square
                int direction = 8;
                int nextPossibleSquare = direction * directionSide + index;
                if(nextPossibleSquare>=Board.START_INDEX_BOARD){
                    if(Board.lesCase.get(nextPossibleSquare).getPiece() == null){
                        legalMove.add(new Move(nextPossibleSquare, index,Board.lesCase
                        .get(index).getPiece()));
                    }
                }
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
    @Override
    public String toString() {
        return "pion " +this.color;
    }


}
