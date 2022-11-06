package Piece;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop implements Piece{
    private String color;
    private final int VALUE = 3;

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
        return "Fou " +this.color;
    }


}
