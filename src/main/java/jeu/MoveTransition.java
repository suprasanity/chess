package jeu;



public final class MoveTransition {


    private final Board toBoard;


    public MoveTransition(final Board fromBoard,
                          final Board toBoard,
                          final Move transitionMove
                         ) {
        this.toBoard = toBoard;

    }

    public Board getToBoard() {
         return this.toBoard;
    }


}
