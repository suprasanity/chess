package Piece;

public class Queen implements Piece{
    private String color;
    private final int VALUE = 9;
    private char symbol;
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265B' : '\u2655'; 
    }
    public String getColor(){
        return this.color;
    }
    public int getValue(){
        return this.VALUE;
    }
    @Override
    public String toString(){
        return "Reine "+color;
    }
}
