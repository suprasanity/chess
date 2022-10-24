package jeu;

import Piece.Pion;
import Piece.Rook;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
private List<Case> lesCase=new ArrayList<>();

public Plateau(){
    initCase();
    initPiece();

}

    private void initCouleur() {
    for(Case c : lesCase){
        if(c.getNumber()<4){
            c.getPiece().setCouleur("Blanc");
        }
        else {c.getPiece().setCouleur("Noir");}
    }
    }

    public void initCase(){
    char [] lettre= "ABCDEFGH".toCharArray();
    for (int i = 1;i<=8;i++)
    {
        for(char c : lettre)
        lesCase.add(new Case(c,i));
    }
}
public void initPiece(){
    for (Case c :lesCase){
        if(c.getNumber()==2||c.getNumber()==7){
            c.setPiece(new Pion());
        }
        if((c.getNumber()==1||c.getNumber()==8) && (c.getLettre()=='A'||c.getLettre()=='H' )){
            c.setPiece(new Rook());
        }
        if((c.getNumber()==1||c.getNumber()==8) && (c.getLettre()=='A'||c.getLettre()=='H' )){
            c.setPiece(new Rook());
        }

    }
}
public void afficherPlateau(){
    for (Case c : lesCase){
                System.out.println(c);
        }
    }
}
