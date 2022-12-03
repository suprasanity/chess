package jeu;

import java.util.ArrayList;
import java.util.List;

import Piece.King;
import Piece.Pawn;
import Piece.Piece;
import Piece.Rook;

public class Player {
    private final String color;
    private final String name;
    public Boolean castled = false;
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
    public boolean isCastled(){
        return this.castled;
    }
    public void setCastled(boolean set){
        this.castled = set;
    }
    public List<Move> KingCastleOpponent(){
        List<Move> castleMove = new ArrayList<>();
        // king side
        if(Board.lesCase.get(4).getPiece() instanceof King
        && Board.lesCase.get(7).getPiece() instanceof Rook){
            if(!(Board.p.isCastled())){
                if(Board.lesCase.get(5).getPiece() == null
                && Board.lesCase.get(6).getPiece() == null){
                    if(!Square.isOccupiedSquareT(5)
                    && !Square.isOccupiedSquareT(6)){
                        System.out.println("Ajouté");
                    }
                }
            }
        }
        // queen side
        if(Board.lesCase.get(4).getPiece() instanceof King
        && Board.lesCase.get(7).getPiece() instanceof Rook){
            if(!(Board.p.isCastled())){
                if(Board.lesCase.get(1).getPiece() == null
                && Board.lesCase.get(2).getPiece() == null
                && Board.lesCase.get(3).getPiece()==  null){
                    if(!Square.isOccupiedSquareT(1)
                    && !Square.isOccupiedSquareT(2)
                    && !Square.isOccupiedSquareT(3)){
                        System.out.println("Ajouté");
                    }
                }
            }
        }
        return castleMove;
    }
    public List<Move> kingCastled(){// impl isCastled in class player ?
        List<Move> castleMove = new ArrayList<>();
        // king side
        if(Board.lesCase.get(60).getPiece() instanceof King
        && Board.lesCase.get(63).getPiece() instanceof Rook){
            if(Board.lesCase.get(60).getPiece().isFirstMove()
            && Board.lesCase.get(63).getPiece().isFirstMove()){
                if(!(Board.p.isCastled())){
                    if(Board.lesCase.get(61).getPiece() == null
                    && Board.lesCase.get(62).getPiece() == null){
                        if(!Square.isOccupiedSquareT(61)
                        && !Square.isOccupiedSquareT(62)){
                            King k = (King)Board.lesCase.get(60).getPiece();
                            Rook r = (Rook)Board.lesCase.get(63).getPiece();
                            castleMove.add(new Castled(k,
                            r,
                             Board.p, new Move(61, 63, null),
                              new Move(62, 60, null)));
                        }
                    }
                }
            }
        }
        // queen side
        if(Board.lesCase.get(60).getPiece() instanceof King
        && Board.lesCase.get(56).getPiece() instanceof Rook){
            if(Board.lesCase.get(60).getPiece().isFirstMove()
            && Board.lesCase.get(56).getPiece().isFirstMove()){
                if(!(Board.p.isCastled())){
                    if(Board.lesCase.get(57).getPiece() == null
                    && Board.lesCase.get(58).getPiece() == null
                    && Board.lesCase.get(59).getPiece()== null){
                        if(!Square.isOccupiedSquareT(57)
                        && !Square.isOccupiedSquareT(58)
                        && !Square.isOccupiedSquareT(59)){
                            King k = (King)Board.lesCase.get(60).getPiece();
                            Rook r = (Rook)Board.lesCase.get(56).getPiece();
                            castleMove.add(new Castled(k,
                            r,
                             Board.p, new Move(59, 56, null),
                              new Move(58, 60, null)));
                        }
                    }
                }
            }
        }
        return castleMove;
    }
    // then impl move like castled from queen side or no
    // polymorphe move must be done think about method & attr 
}
