package ai;

import jeu.Board;
import jeu.Move;

public interface Strategie {

     Move execute(Board board, int depth);
     Move execute(Board board, int depth,boolean affichagePlateau);

}