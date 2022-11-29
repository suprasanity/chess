package ai;

import Piece.Piece;
import jeu.Board;
import jeu.Player;

public final class SimpleCalculator implements Calculator {

    private static int checkBonus  = 70;
    private static int checkmateBonus=1000000000;

    private static int castledBonus = 60;
    private static int depthBonus=100;

    @Override
    public int evaluate(Board board, int depth) {

        return scorePlayer(board, board.getWhitePlayer(), depth) -
               scorePlayer(board, board.getBlackPlayer(), depth);
    }

    private int scorePlayer(Board board, Player player, int depth) {

        return pieceValue(player)+mobility(player)+check(player)+IsCheckMate(player,depth)+casteled(player);

    }

    private int casteled(Player player) {
        return player.isCastled() ? depthBonus : 0;
    }

    public int IsCheckMate(Player player, int depth){
        return player.isInCheckMate() ? checkmateBonus * depthBonus(depth) : 0;
    }

    private int depthBonus(int depth) {
        return depth == 0 ? 1 : 100 * depth;
    }

    private int check(Player player) {
        return player.isInCheck() ? -150 : 0;
    }


    private int mobility(Player player) {
        return player.getLegalMoves().size();
    }

    private static int pieceValue(Player player) {
        int pieceValueScore = 0;
    for ( Piece piece : Board.getActivePieces(player)) {
        pieceValueScore += piece.getPieceValue();
    }
    return pieceValueScore;
    }

}
