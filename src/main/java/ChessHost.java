
import Piece.Piece;
import ai.Minimax;
import ai.Strategie;
import fr.pantheonsorbonne.miage.Facade;
import fr.pantheonsorbonne.miage.HostFacade;
import fr.pantheonsorbonne.miage.PlayerFacade;
import fr.pantheonsorbonne.miage.model.Game;
import fr.pantheonsorbonne.miage.model.GameCommand;

import java.util.List;
import java.util.Random;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import jeu.Square;

public class ChessHost {
    static int tour = 0;
    static Strategie strategy = new Minimax();
    static Move move;
    static Move moveOpponent;
    static String startMove;
    static String endMove;
    static String startMoveOpponent;
    static String endMoveOpponent;
    static String moveReceive;

    private ChessHost() {
    }

    public static void main(String[] args) throws Exception {
        // get the player facade, to interact with other player
        PlayerFacade playerFacade = (PlayerFacade) Facade.getFacade();
        // get the host facade, to manage the game
        HostFacade hostFacade = (HostFacade) Facade.getFacade();
        // wait until we are ready to use the host facade
        hostFacade.waitReady();
        // set our player name
        playerFacade.createNewPlayer("Hostyann" + new Random().nextInt());

        // play the game until the program quits
        while (true) {
            // creata a new game
            Game game = hostFacade.createNewGame("chess");
            // wait for another player to join
            hostFacade.waitForExtraPlayerCount(2);
            // play the game using the player facade
            playTheGame(playerFacade, game);

        }
    }

    private static void playTheGame(PlayerFacade playerFacade, Game game) {
        // create a new board
        Board board = new Board();
        board.initPlayeur(new Player(board, "White", game.playerName()), new Player(board, "Black", "youare"));


        // send its mark to the other player
        playerFacade.sendGameCommandToAll(game, new GameCommand("youare", "Black"));

        // loop until the game is other
        while (true) {

            // check if the game is over
            if (handleGameOver(playerFacade, game, board))
                break;

            System.out.println("+++++++++++ Début Chess: +++++++++++++++++" );
            board.incrementTour();
            System.out.println(board.getTour());

            Move calculatedMove = strategy.execute(board,2,false);
            startMove = intToCase(board,calculatedMove.getCurrCoord());
            endMove = intToCase(board,calculatedMove.getDestCoord());

            System.out.println("Emission Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMove + " " + endMove +  " Piece "+ calculatedMove.getPiece().toString());


            Piece pSource=board.p.getBoard().lesCase.get(calculatedMove.getCurrCoord()).getPiece();
            Square pCible=board.p.getBoard().lesCase.get(calculatedMove.getPieceDestination());
            if (pCible!=null && pCible.getPiece()!=null){
                System.out.println("Piece : " + pSource.toString() +" mange " + pCible.getPiece().toString());
            }




            String moveSend = startMove + "-" + endMove;
            board.p=board.getWhitePlayer();

            List<Square> listeEmission=board.p.makeMove(calculatedMove,board).getToBoard().getLesCase();
            board.getWhitePlayer().getBoard().setLesCase(listeEmission);
            board.getBlackPlayer().getBoard().setLesCase(listeEmission);
            board.setLesCase(listeEmission);
            //board=board.p.makeMove(calculatedMove,board).getToBoard();
            board.afficherPlateau();

            // send the move to the other player
            playerFacade.sendGameCommandToAll(game, new GameCommand("move", moveSend));

            // get the other player's move and retreive the board
            GameCommand command = playerFacade.receiveGameCommand(game);
            moveReceive = command.body();

            startMoveOpponent = moveReceive.substring(0, 2);
            endMoveOpponent = moveReceive.substring(3, 5);
            //System.out.println("reception Commande Joueur: " + board.p.getColor().toString() + " " + "Move: " + startMoveOpponent + " " + endMoveOpponent);

            int startMoveIndice = transformeToInt( board,startMoveOpponent);
            int endMoveIndice = transformeToInt( board,endMoveOpponent);

            Piece p=board.p.getBoard().lesCase.get(startMoveIndice).getPiece();

            List <Square> listeReception=board.p.makeMove(new Move(endMoveIndice,startMoveIndice,p),board).getToBoard().getWhitePlayer().getBoard().getLesCase();


            board.getWhitePlayer().getBoard().setLesCase(listeReception);
            board.getBlackPlayer().getBoard().setLesCase(listeReception);
            board.setLesCase(listeReception);

            /*board = board.p
                    .makeMove(new Move(endMoveIndice,startMoveIndice),board).getToBoard();*/

            //board = moveOpp0onent.getToBoard();

            //board.afficherPlateau();
            System.out.println("+++++++++++ Fin  Chess: +++++++++++++++++" );
        }
    }

    private static boolean handleGameOver(PlayerFacade playerFacade, Game game, Board board) {
        boolean endofgame=false;// check if the game is over
        if (board.blackPlayer.inCheckMate()) {
            endofgame=whoWin(playerFacade, game, board);
        } else if (board.whitePlayer.inCheckMate()) {
            endofgame=whoWin(playerFacade, game, board);
        } else if (board.p.inStaleMate()) {
            endofgame=whoWin(playerFacade, game, board);
        }else if (board.getTour() >= board.getNbMaxTour()) {
            endofgame = whoWin(playerFacade, game, board);
        }else if (board.detectTropDeFoisLeMemeMove()){
            endofgame = whoWin(playerFacade, game, board);
        }else if (board. detectRoiMange()){
            endofgame = whoWin(playerFacade, game, board);
        }
        // the game is not over
        return endofgame;

    }

    private static boolean whoWin(PlayerFacade playerFacade, Game game, Board board) {
        if (EvaluateWinner.winnerOfTheGame(board) == "White") {
            // we've won :-)
            playerFacade.sendGameCommandToAll(game, new GameCommand("gameover", "defeat"));
            playerFacade.sendGameCommandToAll(game, new GameCommand("board", board.toString()));
            System.out.println("victory!\n" + board);
            return true;
        } else if (EvaluateWinner.winnerOfTheGame(board) == "Black") {
            // we've lost :-(
            playerFacade.sendGameCommandToAll(game, new GameCommand("gameover", "victory"));
            playerFacade.sendGameCommandToAll(game, new GameCommand("board", board.toString()));
            System.out.println("defeat!\n" + board);
            return true;
        } else if (EvaluateWinner.winnerOfTheGame(board) == "Tie") {
            // it's a tie :-/
            playerFacade.sendGameCommandToAll(game, new GameCommand("gameover", "tie"));
            playerFacade.sendGameCommandToAll(game, new GameCommand("board", board.toString()));
            System.out.println("tie!\n" + board);
            return true;
        }
        return false;
    }
    public static String intToCase(Board b, int i){
        return b.lesCase.get(i).getLetter()+String.valueOf( b.lesCase.get(i).getNumber());
    }



    public static int transformeToInt(Board b, String s){
        int i = 0;
        for (Square square : b.lesCase) {
            if(square.getLetter()==s.charAt(0) && square.getNumber()==Integer.parseInt(String.valueOf(s.charAt(1)))){
                return i;
            }
            i++;
        }
        return 0;
    }

}
