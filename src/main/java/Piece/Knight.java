package Piece;

import java.io.PrintWriter;

public class Knight implements Piece{
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
        return "Cavalier "+this.color;
    }
    public void PrintUnicode(){
        PrintWriter printWriter = new PrintWriter(System.out,true);
        char aa = '\u2658';
        printWriter.println(aa);
    }
}