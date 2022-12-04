import Piece.Piece;
import jeu.Board;

public class EvaluateWinner {

    private EvaluateWinner() {}

    public static String winnerOfTheGame(Board board) {
        int pointsWhite = checkMatePoints(board)[0] +
                queenWasMoving(board)[0] +
                knightNotEat(board)[0] +
                eatingOpponentQueen(board)[0] +
                kingNotMoving(board)[0] +
                eatingOpponentPawn(board)[0] +
                notLooseRooks(board)[0] +
                leastPiece(board)[0] +
                promotionPawn(board)[0];

        int pointsBlack = checkMatePoints(board)[1] +
                queenWasMoving(board)[1] +
                knightNotEat(board)[1] +
                eatingOpponentQueen(board)[1] +
                kingNotMoving(board)[1] +
                eatingOpponentPawn(board)[1] +
                notLooseRooks(board)[1]+
                leastPiece(board)[1]+
                promotionPawn(board)[1];

        String winner = "NoWinner";
        if (pointsWhite > pointsBlack) {
            winner = "White";
        } else if(pointsBlack >pointsWhite) {
            winner = "Black";
        } else if(pointsWhite == pointsBlack){
            winner = "Tie";
        }

        return winner;
    }

    // CheckMate
    private static int[] checkMatePoints(Board board) {
        int[] points = new int[3];
        if (board.whitePlayer.inCheckMate()) {
            points[1] = 100;
        } else if (board.blackPlayer.inCheckMate()) {
            points[0] = 100;
        }
        return points;
    }

    // Pas bouger la dame
    private static int[] queenWasMoving(Board board) {
        Piece queenWhite = board.whitePlayer.getQueen();
        Piece queenBlack = board.blackPlayer.getQueen();
        int[] points = new int[2];
        if (queenWhite.firstMove()) {
            points[0] = 10;
        }
        if (queenBlack.firstMove()) {
            points[1] = 10;
        }
        return points;
    }

    // Pas manger de cavalier
    private static int[] knightNotEat(Board board) {
        int[] points = new int[2];
        int knightCountWhite = 0;
        int knightCountBlack = 0;
        for (Piece piece : board.blackPlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "K") {
                knightCountWhite += 1;
            }
        }
        if (knightCountWhite < 2) {
            points[0] = 10;
        }
        for (Piece piece : board.whitePlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "K") {
                knightCountBlack += 1;
            }
        }
        if (knightCountBlack < 2) {
            points[1] = 10;
        }
        return points;
    }

    // Manger la reine ennemie
    private static int[] eatingOpponentQueen(Board board) {
        int[] points = new int[2];
        int queenCountWhite = 0;
        int queenCountBlack = 0;
        for (Piece piece : board.blackPlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "Q") {
                queenCountWhite += 1;
            }
        }
        if (queenCountWhite == 0) {
            points[0] = 10;
        }
        for (Piece piece : board.whitePlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "Q") {
                queenCountBlack += 1;
            }
        }
        if (queenCountBlack == 0) {
            points[1] = 10;
        }
        return points;
    }

    // Pas bouger le roi jusqu'Ã  l'Ã©chec
    private static int[] kingNotMoving(Board board) {
        Piece kingWhite = board.whitePlayer.getKing();
        Piece kingBlack = board.blackPlayer.getKing();
        int[] points = new int[2];
        if (kingWhite.firstMove()) {
            points[0] = 10;
        } else if (kingBlack.firstMove()) {
            points[1] = 10;
        }
        return points;
    }

    // Manger tous les pions
    private static int[] eatingOpponentPawn(Board board) {
        int[] points = new int[2];
        int pawnCountWhite = 0;
        int pawnCountBlack = 0;
        for (Piece piece : board.blackPlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "P") {
                pawnCountBlack += 1;
            }
        }
        if (pawnCountBlack == 0) {
            points[0] = 10;
        }
        for (Piece piece : board.whitePlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "P") {
                pawnCountWhite += 1;
            }
        }
        if (pawnCountWhite == 0) {
            points[1] = 10;
        }
        return points;
    }

    // Ne pas perdre ses 2 tours
    private static int[] notLooseRooks(Board board) {
        int[] points = new int[2];
        int rookCountWhite = 0;
        int rookCountBlack = 0;
        for (Piece piece : board.blackPlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "R") {
                rookCountBlack += 1;
            }
        }
        if (rookCountBlack == 0) {
            points[1] = 10;
        }
        for (Piece piece : board.whitePlayer.getPieceOnBoard()) {
            if (piece.getPieceName() == "R") {
                rookCountWhite += 1;
            }
        }
        if (rookCountWhite == 0) {
            points[0] = 10;
        }
        return points;
    }

    // Gagner la partie avec moins de piÃ¨ce
    private static int[] leastPiece(Board board) {
        int[] points = new int[2];
        if (board.whitePlayer.getPieceOnBoard().size() > board.blackPlayer.getPieceOnBoard().size()) {
            points[0] = 10;
        } else if (board.blackPlayer.getPieceOnBoard().size() > board.whitePlayer.getPieceOnBoard().size()) {
            points[1] = 10;
        }
        return points;
    }

    // promouvoir un pion
    private static int[] promotionPawn(Board board) {
        int[] points = new int[2];

        return points;
    }

}
