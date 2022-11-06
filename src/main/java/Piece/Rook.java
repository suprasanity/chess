package Piece;

public class Rook implements Piece {
    private String color ;
    private final int VALUE = 5;
    private char symbol;
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
