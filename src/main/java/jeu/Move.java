package jeu;

import Piece.Piece;

public class Move {
    private int destCoord;
    private int currCoord;
    public Move(int destCoord, int currCoor){
        this.destCoord = destCoord;
        this.currCoord = currCoord;
    }
}