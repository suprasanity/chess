import ai.Strategie;
import jeu.Board;
import jeu.Move;
import jeu.Player;
import ai.Minimax;
public class Main {
    public static void main(String[] args) {
        
        Board b = new Board();
        b.initPlayeur(new Player(b,"White","IA"),new Player(b,"Black","yann"));
        Minimax m = new Minimax();
        m.setAffichagePlateau(true);
        Strategie s = m;
        Move res=s.execute(b, 3);
        System.out.println(res.getCurrCoord()+" - "+res.getDestCoord());
         b.afficherPlateau();
    }

}