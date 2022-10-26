package Piece;

import jeu.Case;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fou implements Piece{
    private String couleur;

    @Override
    public void setCouleur(String c) {
        this.couleur=c;
    }
    public String toString(){
        return "Fou " +couleur;
    }


}
