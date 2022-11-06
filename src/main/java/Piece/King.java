package Piece;



public class King implements Piece{
    private String color;
    private final int VALUE = -1;
    private char symbol;
    public void setColor(String color) {
        this.color=color;
        setSymbol(color);
    }
    public void setSymbol(String color){
        this.symbol = (color.equals("Black")) ? '\u265A': '\u2654';
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
