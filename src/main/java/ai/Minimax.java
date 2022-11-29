package ai;

import jeu.Board;
import jeu.Move;
import jeu.MoveTransition;

public class Minimax implements Strategie{

    private final Calculator calculator;

    public Minimax() {
        this.calculator = new SimpleCalculator();
    }

    @Override
    public String toString() {
 //rt
        return "Minimax";
    }

    @Override
    public Move execute(Board board, int depth) {
        Move bestMove = null;
        int highestSeenValue = Integer.MIN_VALUE;
        int lowestSeenValue = Integer.MAX_VALUE;
        int currentValue;

        for (Move move : board.p.getLegalMoves()) {
            MoveTransition moveTransition = board.p.makeMove(move);
                currentValue = board.p.getColor().equals("White")
                              ? min(moveTransition.getToBoard(), depth - 1) :
                                max(moveTransition.getToBoard(), depth - 1);

                if (board.p.getColor().equals("White") && currentValue >= highestSeenValue) {
                    highestSeenValue = currentValue;
                    bestMove = move;
                } else if (board.p.getColor().equals("Black") && currentValue <= lowestSeenValue) {
                    lowestSeenValue = currentValue;
                    bestMove = move;
                }
            }

        return bestMove;
    }

    public int min(Board board, int depth) {
       if (depth == 0){
           return calculator.evaluate(board, depth);
       }
       int lowest = Integer.MAX_VALUE;
       for (Move move : board.getPlayerToPlay().getLegalMoves()){
           MoveTransition moveTransition = board.getPlayerToPlay().makeMove(move);
           int currentValue = max(moveTransition.getToBoard(), depth - 1);
           if (currentValue <= lowest){
               lowest = currentValue;
           }
       }
         return lowest;
    }

    public int max(Board board, int depth) {
        if (depth == 0){
            return calculator.evaluate(board, depth);
        }
        int maximum = Integer.MIN_VALUE;
        for (Move move : board.getPlayerToPlay().getLegalMoves()){
            MoveTransition moveTransition = board.getPlayerToPlay().makeMove(move);
            int currentValue = max(moveTransition.getToBoard(), depth - 1);
            if (currentValue >= maximum){
                maximum = currentValue;
            }
        }
        return maximum;
    }
    private static boolean isEndGameScenario(final Board board) {
        return board.getPlayerToPlay().isInCheckMate() || board.getBlackPlayer().isInCheckMate();
    }
}
