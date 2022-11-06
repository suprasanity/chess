package Piece;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop implements Piece{
    private String color;
    private final int VALUE = 3;
    private char symbol;
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265D': '\u2657';
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
