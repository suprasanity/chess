package Piece;

public class Reine implements Piece{
    private String color;
    @Override
    public void setColor(String color) {
        this.color=color;
    }
    public String toString(){return "Reine "+color;}
}
