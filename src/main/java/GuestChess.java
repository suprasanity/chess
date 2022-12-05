

import Piece.Piece;
import ai.Minimax;
import ai.Strategie;
import fr.pantheonsorbonne.miage.Facade;
import fr.pantheonsorbonne.miage.PlayerFacade;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import jeu.Square;

import java.util.List;
import java.util.Random;


public class GuestChess {
    static int tour = 0;
    static Strategie strategy = new Minimax();
    static Move move;
    static Move moveOpponent;
    static String startMove;
    static String endMove;
    static String startMoveOpponent;
    static String endMoveOpponent;
    static String moveReceive;

    public static void main(String[] args) throws Exception {
        // get the facade as a player
        PlayerFacade facade = Facade.getFacade();
        facade.waitReady();
        // set our palyer name
        final String playerName = "Guestyann" + new Random().nextInt();
        facade.createNewPlayer(playerName);
        System.out.println("I am: " + playerName);
        // wait until we are able to join a new game
        Game currentGame = facade.autoJoinGame("chess");

        // get our mark
        GameCommand command = facade.receiveGameCommand(currentGame);
        if (!command.name().equals("youare")) {
            throw new RuntimeException();
        }

        Board board = new Board();
        board.initPlayeur(new Player(board, "White", "test"), new Player(board, "Black", playerName));

        while (true) {
            // get a command from someone else
            GameCommand commandLoop = facade.receiveGameCommand(currentGame);

            switch (commandLoop.name()) {
                case "move":
                    handleNewBoard(facade, currentGame, commandLoop, board);
                    break;
                case "gameover":
                    // if the game is other, stop playing and show the results
                    handleGameOver(facade, currentGame, commandLoop, board);
                    System.exit(0);
            }

        }

    }

    /**
     * react uppon gameover command received
     *
     * @param facade          the player facade
     * @param currentGame     the game currently played
     * @param gameOverCommand
     */
    private static void handleGameOver(PlayerFacade facade, Game currentGame, GameCommand gameOverCommand,
                                       Board board) {

        // show a message depending on our victory or not
        switch (gameOverCommand.body()) {
            case "victory":
                System.out.println("I've won\n ");
                break;
            case "defeat":
                System.out.println("I've lost\n");
                break;
            case "tie":
                System.out.println("It's a tie\n");
        }

        // after the game over command, we should receive the final version of the board
        // and display it
        GameCommand command = facade.receiveGameCommand(currentGame);


        board.afficherPlateau();

        moveReceive = command.body();
        board.afficherPlateau();



    }

    private static void handleNewBoard(PlayerFacade facade, Game currentGame, GameCommand commandLoop, Board board) {
        // get the other player's move and retreive the board

        System.out.println(" ");


        moveReceive = commandLoop.body();
        System.out.println("+++++++++++ Début Guess: +++++++++++++++++");
        System.out.println("Tour " + tour++);
        startMoveOpponent = moveReceive.substring(0, 2);
        endMoveOpponent = moveReceive.substring(3, 5);
        //System.out.println("Réception Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMove + " " + endMove );
        //réception des move du blanc
        int startMoveIndice = transformeToInt(board, startMoveOpponent);
        int endMoveIndice = transformeToInt(board, endMoveOpponent);
        Piece p = board.p.getBoard().lesCase.get(startMoveIndice).getPiece();
        List<Square> listeReception = board.p.makeMove(new Move(endMoveIndice, startMoveIndice, p), board).getToBoard().getWhitePlayer().getBoard().getLesCase();


        board.getWhitePlayer().getBoard().setLesCase(listeReception);
        board.getBlackPlayer().getBoard().setLesCase(listeReception);
        board.setLesCase(listeReception);


        board.p = board.getBlackPlayer();
        Move calculatedMove = strategy.execute(board, 3, false);

        startMove = intToCase(board, calculatedMove.getCurrCoord());
        endMove = intToCase(board, calculatedMove.getDestCoord());


        String moveSend = startMove + "-" + endMove;

        System.out.println("");
        System.out.println("Emission Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMove + " " + endMove + " Piece " + calculatedMove.getPiece().toString());



        Piece pSource = board.p.getBoard().lesCase.get(calculatedMove.getCurrCoord()).getPiece();
        Square pCible = board.p.getBoard().lesCase.get(calculatedMove.getDestCoord());
        if (pCible != null && pCible.getPiece() != null) {
            System.out.println("Piece : " + pSource.toString() + " mange " + pCible.getPiece().toString());
        }

        List<Square> listeEmission = board.p.makeMove(calculatedMove, board).getToBoard().getBlackPlayer().getBoard().getLesCase();
        board.getWhitePlayer().getBoard().setLesCase(listeEmission);
        board.getBlackPlayer().getBoard().setLesCase(listeEmission);
        board.setLesCase(listeEmission);

        board.afficherPlateau();

        System.out.println("+++++++++++ Fin Guess: +++++++++++++++++");
        // send the move to the other player
        facade.sendGameCommandToAll(currentGame, new GameCommand("move", moveSend));
    }

    public static String intToCase(Board b, int i) {
        return b.lesCase.get(i).getLetter() + String.valueOf(b.lesCase.get(i).getNumber());
    }

    public static int transformeToInt(Board b, String s) {
        int i = 0;
        for (Square square : b.lesCase) {
            if (square.getLetter() == s.charAt(0) && square.getNumber() == Integer.parseInt(String.valueOf(s.charAt(1)))) {
                return i;
            }
            i++;
        }
        return 0;
    }

}
