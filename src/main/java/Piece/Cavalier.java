package Piece;

import java.io.PrintWriter;

public class Cavalier implements Piece{
   private String color;
    @Override
    public void setColor(String color) {
        this.color=color;
    }

    public String toString(){
        return "Cavalier "+this.color;
    }
    public void PrintUnicode(){
        PrintWriter printWriter = new PrintWriter(System.out,true);
        char aa = '\u2658';
        printWriter.println(aa);
    }
}
