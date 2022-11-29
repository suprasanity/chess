import ai.Strategie;
import jeu.Board;
import jeu.Player;
import ai.Minimax;
public class Main {
    public static void main(String[] args) {
        
        Board p = new Board(new Player("White","Yann"));
        Strategie s = new Minimax();
        s.execute(p, 3);
         p.afficherPlateau();
    }

}