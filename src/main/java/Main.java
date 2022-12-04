import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import jeu.Square;
public class Main {
    public static void main(String[] args) {
        Player p = new Player("White","yann");
        Board mp = new Board(p);
        /*Board.lesCase.get(27).setPiece(new King());
        Board.lesCase.get(27).getPiece().setColor("White");
        Board.lesCase.get(25).setPiece(new King());
        Board.lesCase.get(25).getPiece().setColor("Black");  
        Board.lesCase.get(42).setPiece(new Rook());
        Board.lesCase.get(42).getPiece().setColor("White");*/
        Board.lesCase.get(39).setPiece(new Bishop());
        Board.lesCase.get(39).getPiece().setColor("Black");
        //Board.lesCase.get(17).setPiece(new Pawn()); 
        //Board.lesCase.get(17).getPiece().setColor("Black"); 
        mp.afficherPlateau();
        for (int i=0;i<Board.lesCase.size();i++) {
            System.out.println(i);
            System.out.println(Board.lesCase.get(i).toString());
        }
        mp.afficherPlateau();
        /*for(Move move : Board.p.getOpponentAttacksOnSquare()){
            System.out.println(move);
        }*/
        /*for(int i=0;i<Board.lesCase.get(24).getPiece().
        legalMovSquares(Board.lesCase.get(24)).size();i++){
            System.out.println(Board.lesCase.get(24).getPiece().
            legalMovSquares(Board.lesCase.get(24)).get(i));
        }*/
        /*for(Move move : Board.lesCase.get(1).getPiece().legalMovSquares(Board.lesCase.get(1))){
            System.out.println(move.getDestCoord());
            System.out.println(move.getCurrCoord());
            System.out.println(move);
        }*/
        /*for(Move mv : Board.lesCase.get(53).getPiece().
        legalMovSquares(Board.lesCase.get(53))){
            System.out.println(mv);
        }*/
        /*for(Move mq : Board.lesCase.get(27).getPiece()
                      .legalMovSquares(Board.lesCase.get(27)))
        {
            System.out.println(mq);
        }*/
        //System.out.println(Board.lesCase.get(9).getPiece());
        /*for(Move move : Board.lesCase.get(27).getPiece().legalMovSquares(Board.lesCase.get(27))){
            System.out.println(move);
            System.out.println(Square.isOccupiedSquare(move.getDestCoord()));
        }
        
        System.out.println(Square.isOccupiedSquare(20));*/
        /*King mpd = (King)Board.lesCase.get(27).getPiece();
        for(Move move : mpd
            .moveSquaresReal(Board.lesCase.get(27))){ // check class king 
            
            
            System.out.println("move "+move);
        }*/
        //System.out.println(Square.isOccupiedSquare(22));
        //Guest g1=new Guest("yann");

        //Cavalier p = new Cavalier();
        //p.PrintUnicode();
        //Board.lesCase.get(57).setPiece(null);
        //Board.lesCase.get(58).setPiece(null);
        //Board.lesCase.get(59).setPiece(null);
        //Board.lesCase.get(50).setPiece(new Queen());
        //Board.lesCase.get(50).getPiece().setColor("Black");
        //Board.lesCase.get(61).setPiece(null);
        //Board.lesCase.get(62).setPiece(null);
        //Board.lesCase.get(52).setPiece(new Pawn());
        //Board.lesCase.get(51).getPiece().setColor("Black");
        //Board.lesCase.get(16).setPiece(new Knight());
        //Board.lesCase.get(16).getPiece().setColor("Black");
        Board.lesCase.get(24).setPiece(new Rook());
        Board.lesCase.get(24).getPiece().setColor("Black");
        Board.lesCase.get(60).setPiece(new King());
        Board.lesCase.get(60).getPiece().setColor("White");
        //Board.lesCase.get(60).setPiece(null);
        //Board.lesCase.get(43).setPiece(new Queen());
        //Board.lesCase.get(43).getPiece().setColor("White");

        mp.afficherPlateau();
        Board.lesCase.get(52).setPiece(null);
        mp.afficherPlateau();
        for(Move move : Board.p.getAttacksOnSquareWithoutCheck()){
            System.out.println(move);
        }
        /*System.out.println(Board.p.isCheck());
        for(Move mv : Board.p.getAttacksOnSquareWithoutCheck()){
            System.out.println(mv);
        }*/

        
        
        //mp.afficherPlateau();

    }

}