import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.startGame();
        while (!board.isComplete()) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            /*
             * Should have been gameEngine.makeMove
             * As getting the access to the wholeBoard
             * is very dangerouse
             * we can do whatever we want with it!
             */
            board.makeMove(new Move(i, j, 'X'));
        }
    }
}

class GameEngine {
    public static void main(String[] args) {

    }
    /* APIs */

    Board startGame() {

    }

    boolean makeMove(Board board, Move move) {

    }

    Board getGameStatus() {

    }

}

class Board {

}

class TicTacToeBoard extends Board {
    char[][] boardMatrix;
    int n, m;
}

class Move {
    int i, j;
    char charToBePlaced;

    public Move(int i, int j, char charToBePlaced) {
        this.i = i;
        this.j = j;
        this.charToBePlaced = charToBePlaced;
    }

}
