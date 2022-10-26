package Piece;

import java.io.PrintWriter;

public class Cavalier implements Piece{
   private String couleur;
    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }

    public String toString(){
        return "Cavalier "+this.couleur;
    }
    public void PrintUnicode(){
        PrintWriter printWriter = new PrintWriter(System.out,true);
        char aa = '\u2658';
        printWriter.println(aa);
    }
}
