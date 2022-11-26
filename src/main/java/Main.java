import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Piece.Bishop;
import Piece.Knight;
import Piece.Pawn;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import jeu.Square;
public class Main {
    public static void main(String[] args) {
        Player p = new Player("Black","yann");
        Board mp = new Board(p);
        Board.lesCase.get(44).setPiece(new Pawn());
        Board.lesCase.get(44).getPiece().setColor("White"); 
        mp.afficherPlateau();
        for (int i=0;i<Board.lesCase.size();i++) {
            System.out.println(i);
            System.out.println(Board.lesCase.get(i).toString());
        }
        mp.afficherPlateau();
        /*for(int i=0;i<Board.lesCase.get(24).getPiece().
        legalMovSquares(Board.lesCase.get(24)).size();i++){
            System.out.println(Board.lesCase.get(24).getPiece().
            legalMovSquares(Board.lesCase.get(24)).get(i));
        }*/
        for(Move mv : Board.lesCase.get(53).getPiece().
        legalMovSquares(Board.lesCase.get(53))){
            System.out.println(mv);
        }
        
        //Guest g1=new Guest("yann");

        //Cavalier p = new Cavalier();
        //p.PrintUnicode();


    }

}