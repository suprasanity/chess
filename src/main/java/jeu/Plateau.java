package jeu;

import Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public  List<Case> lesCase = new ArrayList<>();

    public Plateau() {
        initCase();
        initPiece();
        initCouleur();

    }

    private void initCouleur() {
        for (Case c : lesCase) {
            if (c.getNumber() == 1 || c.getNumber() == 2) {
                c.getPiece().setColor("Blanc");
            } else if(c.getNumber() == 7 || c.getNumber() == 8) {
                c.getPiece().setColor("Noir");
            }
        }
    }

    public void initCase() {
        char[] lettre = "ABCDEFGH".toCharArray();
        for (int i = 1; i <= 8; i++) {
            for (char c : lettre)
                lesCase.add(new Case(c, i));
        }
    }

    public void initPiece() {
        for (Case c : lesCase) {
            if (c.getNumber() == 2 || c.getNumber() == 7) {
                c.setPiece(new Pion());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLettre() == 'A' || c.getLettre() == 'H')) {
                c.setPiece(new Rook());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLettre() == 'B' || c.getLettre() == 'G')) {
                c.setPiece(new Cavalier());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLettre() == 'C' || c.getLettre() == 'F')) {
                c.setPiece(new Fou());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLettre() == 'D')) {
                c.setPiece(new Reine());
            }
            if ((c.getNumber() == 1 || c.getNumber() == 8) && (c.getLettre() == 'E')) {
                c.setPiece(new Roi());
            }
        }

    }

    public void afficherPlateau() {
        for (Case c : lesCase) {
            System.out.println(c);
        }
    }
    public void MoovePiece(Case caseDepart,Case caseArrive){
        caseArrive.setPiece(caseDepart.getPiece());
        caseDepart.setPiece(null);
    }
}
