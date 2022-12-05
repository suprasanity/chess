import Piece.*;
import ai.Strategie;
import fr.pantheonsorbonne.miage.PlayerFacade;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import ai.Minimax;
import jeu.Square;

import java.util.HashMap;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        Board board = new Board();
        board.initPlayeur(new Player(board, "White", "IA"), new Player(board, "Black", "yann"));
        boolean endofgame = false;

        //Stratégie joueur blanc
        Minimax m = new Minimax();
        Strategie strategieJoueurBlanc = m;



        //Stratégie joueur blanc
        Minimax m2 = new Minimax();
        Strategie strategieJoueurNoir = m2;





        while (!endofgame) {
            board.incrementTour();

            System.out.println("Tour: " + board.getTour());
            joueurBlancJoue(board, strategieJoueurBlanc);
            joueurBlackJoue(board, strategieJoueurNoir);

            endofgame=checkEndGame(board);


        }


    }

    private static boolean checkEndGame(Board board) {
        boolean endofgame = false;
        if (board.blackPlayer.inCheckMate()) {
            endofgame=whoWin(board);
        } else if (board.whitePlayer.inCheckMate()) {
            endofgame=whoWin(board);
        } else if (board.p.inStaleMate()) {
            endofgame=whoWin(board);
        }else if (board.getTour() >= board.getNbMaxTour()) {
            endofgame = whoWin(board);
        }else if (board.detectTropDeFoisLeMemeMove()){
            endofgame = whoWin(board);;
        }else if (board. detectRoiMange()){
            endofgame = whoWin(board);;
        }

        return endofgame;
    }

    private static void joueurBlackJoue(Board board, Strategie strategieJoueurNoir) {
        List<Square> listeEmission;
        Move calculatedMove;
        String endMove;
        String startMove;
        //joueur noir
        board.p = board.getBlackPlayer();
        calculatedMove = strategieJoueurNoir.execute(board, 2, false);

        startMove = intToCase(board, calculatedMove.getCurrCoord());
        endMove = intToCase(board, calculatedMove.getDestCoord());



        System.out.println("");
        System.out.println("Emission Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMove + " " + endMove + " Piece " + calculatedMove.getPiece().toString());


        Piece pSource = board.p.getBoard().lesCase.get(calculatedMove.getCurrCoord()).getPiece();
        Square pCible = board.p.getBoard().lesCase.get(calculatedMove.getDestCoord());
        if (pCible != null && pCible.getPiece() != null) {
            System.out.println("Piece : " + pSource.toString() + " mange " + pCible.getPiece().toString());
        }
        board.p = board.getBlackPlayer();
        listeEmission = board.p.makeMove(calculatedMove, board).getToBoard().getBlackPlayer().getBoard().getLesCase();
        board.getWhitePlayer().getBoard().setLesCase(listeEmission);
        board.getBlackPlayer().getBoard().setLesCase(listeEmission);
        board.setLesCase(listeEmission);

        board.afficherPlateau();
    }



    private static void joueurBlancJoue(Board board, Strategie strategieJoueurBlanc) {
        String startMove;
        String endMove;
        board.p = board.getWhitePlayer();
        Move calculatedMove = strategieJoueurBlanc.execute(board, 2, false);
        startMove = intToCase(board, calculatedMove.getCurrCoord());
        endMove = intToCase(board, calculatedMove.getDestCoord());
        System.out.println("Emission Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMove + " " + endMove + " Piece " + calculatedMove.getPiece().toString());

        //incrementeFrequence(calculatedMove);

        Piece pSource = board.p.getBoard().lesCase.get(calculatedMove.getCurrCoord()).getPiece();
        Square pCible = board.p.getBoard().lesCase.get(calculatedMove.getPieceDestination());
        if (pCible != null && pCible.getPiece() != null) {
            System.out.println("Piece : " + pSource.toString() + " mange " + pCible.getPiece().toString());
        }

        board.p = board.getWhitePlayer();


        List<Square> listeEmission = board.p.makeMove(calculatedMove, board).getToBoard().getLesCase();
        board.getWhitePlayer().getBoard().setLesCase(listeEmission);
        board.getBlackPlayer().getBoard().setLesCase(listeEmission);
        board.setLesCase(listeEmission);

        board.afficherPlateau();
    }

    public static String intToCase(Board b, int i) {
        return b.lesCase.get(i).getLetter() + String.valueOf(b.lesCase.get(i).getNumber());
    }

    private static boolean whoWin(Board board) {
        if (EvaluateWinner.winnerOfTheGame(board) == "White") {
            // we've won :-)
            System.out.println("victory pour les blanc!\n" );
            System.out.println("défaite  pour les noirs!\n");
            return true;
        } else if (EvaluateWinner.winnerOfTheGame(board) == "Black") {
            // we've lost :-(
            System.out.println("victory pour les noirs!\n" );
            System.out.println("défaite  pour les blanc!\n" );
            return true;
        } else if (EvaluateWinner.winnerOfTheGame(board) == "Tie") {
            // it's a tie :-/
            System.out.println("Exécaux!\n" );
            return true;
        }
        return false;
    }
}