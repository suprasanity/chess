package Piece;


import jeu.Case;
import jeu.Plateau;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pion implements Piece {
    private String color;
    @Override
    public String toString() {
        return "pion " +this.color;
    }
    public void setColor(String color){this.color=color;}


}
