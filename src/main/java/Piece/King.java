package Piece;



public class King implements Piece{
    private String color;
    private final int VALUE = -1;
    
    public void setColor(String color) {
        this.color=color;
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
