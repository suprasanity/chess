package ai;

import jeu.Board;
import jeu.MesConstantes;
import jeu.Move;
import jeu.MoveTransition;

public class Minimax implements Strategie {


    public void setAffichagePlateau(boolean affichagePlateau) {
        this.affichagePlateau = affichagePlateau;
    }

    private  boolean affichagePlateau=true;
    private final Calculator calculator;

    public Minimax() {
        this.calculator = new SimpleCalculator();
    }

    @Override
    public String toString() {
        //rt
        return "Minimax";
    }

    public Move execute(Board board, int depth,boolean affichagePlateau) {
        this.affichagePlateau=affichagePlateau;
        return this.execute(board, depth);
    }
    @Override
    public Move execute(Board board, int depth) {
        Move bestMove = null;
        int highestSeenValue = Integer.MIN_VALUE;
        int lowestSeenValue = Integer.MAX_VALUE;
        int currentValue;


        int indice=0;

        board.afficherPlateau(affichagePlateau);
        if (board.p.getColor().equals("White")) {
            bestMove = getMove(board, depth, bestMove, highestSeenValue, lowestSeenValue, indice, MesConstantes.WHITE,MesConstantes.BLACK);
        }else{
            bestMove = getMove(board, depth, bestMove, highestSeenValue, lowestSeenValue, indice, MesConstantes.BLACK,MesConstantes.WHITE);
        }
        board.incrementeFrequence(bestMove);
        return bestMove;
    }

    private Move getMove(Board board, int depth, Move bestMove, int highestSeenValue, int lowestSeenValue, int indice,String couleurPlayeur,String couleurAdv) {
        int currentValue;
        for (Move move : board.p.getLegalMoves()) {

            MoveTransition moveTransition = board.p.makeMove(move, board);
            indice++;


            moveTransition.getToBoard().afficherPlateau(affichagePlateau);
            indice++;

            currentValue = board.p.getColor().equals(couleurPlayeur) ? min(moveTransition.getToBoard(), depth - 1,affichagePlateau) : max(moveTransition.getToBoard(), depth - 1,affichagePlateau);

            if (board.p.getColor().equals(couleurPlayeur) && currentValue >= highestSeenValue) {
                String moveString = move.getPiece().getColor() + move.getPiece().toString() + move.getCurrCoord() + move.getDestCoord();

                if (bestMove!=null){
                    String moveBestString = bestMove.getPiece().getColor() + bestMove   .getPiece().toString() + bestMove.getCurrCoord() + bestMove.getDestCoord();
                    if(board.getMapsFrequence().get(moveString)!=null){
                        if  (board.getMapsFrequence().get(moveBestString)!=null){
                            if (board.getMapsFrequence().get(moveString)<board.getMapsFrequence().get(moveString)){
                                highestSeenValue = currentValue;
                                bestMove = move;
                            }
                        }else{
                            //on fait rien
                        }
                    }else {
                        highestSeenValue = currentValue;
                        bestMove = move;
                    }
                }else{
                    highestSeenValue = currentValue;
                    bestMove = move;
                }

            } else if (board.p.getColor().equals(couleurAdv) && currentValue <= lowestSeenValue) {
                String moveString = move.getPiece().getColor() + move.getPiece().toString() + move.getCurrCoord() + move.getDestCoord();
                if (bestMove!=null){
                    String moveBestString = bestMove.getPiece().getColor() + bestMove   .getPiece().toString() + bestMove.getCurrCoord() + bestMove.getDestCoord();
                    if(board.getMapsFrequence().get(moveString)!=null){
                        if  (board.getMapsFrequence().get(moveBestString)!=null){
                            if (board.getMapsFrequence().get(moveString)<board.getMapsFrequence().get(moveString)){
                                lowestSeenValue = currentValue;
                                bestMove = move;
                            }
                        }else{
                            //on fait rien
                        }
                    }else {
                        lowestSeenValue = currentValue;
                        bestMove = move;
                    }
                }else {
                    lowestSeenValue = currentValue;
                    bestMove = move;
                }

            }

        }
        return bestMove;
    }

    public int min(Board board, int depth,boolean affichagePlateau) {

        if (depth == 0) {
            return calculator.evaluate(board, depth);
        }
        int lowest = Integer.MAX_VALUE;
        int indice=0;
        for (Move move : board.getPlayerToPlay().getLegalMoves()) {
            MoveTransition moveTransition = board.getPlayerToPlay().makeMove(move, board);

            moveTransition.getToBoard().afficherPlateau(affichagePlateau);

            int currentValue = max(moveTransition.getToBoard(), depth - 1,affichagePlateau);
            if (currentValue <= lowest) {
                lowest = currentValue;
            }

            indice++;
        }
        //System.out.println("Calcul Min "+lowest);
        return lowest;
    }

    public int max(Board board, int depth,boolean affichagePlateau) {
        //board.setJoueurEncoursIA();
        if (depth == 0) {
            return calculator.evaluate(board, depth);
        }
        int maximum = Integer.MIN_VALUE;
        int indice=0;
        for (Move move : board.getPlayerToPlay().getLegalMoves()) {
            MoveTransition moveTransition = board.getPlayerToPlay().makeMove(move, board);
          //  System.out.println("simulation Max "+indice);
            moveTransition.getToBoard().afficherPlateau(affichagePlateau);

            int currentValue = min(moveTransition.getToBoard(), depth - 1,affichagePlateau);
            if (currentValue >= maximum) {
                maximum = currentValue;
            }
            //board.lesCase = board.copyCase(board.lesCaseSauvegardees);
            indice++;
        }
        //System.out.println("Calcul Max "+maximum);
        return maximum;

    }

    private static boolean isEndGameScenario(final Board board) {
        return board.getPlayerToPlay().isInCheckMate() || board.getBlackPlayer().isInCheckMate();
    }
}
