package single.resp.principle;

import java.util.Scanner;

public class GameEngineSimulator {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.startGame();
        Player human = new Player('X');
        Player comp = new Player('O');
        while (!RuleEngine.isGameComplete(board)) {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt(), j = sc.nextInt();
            // human move
            board.makeMove(new Move(human, i, j));
            if (RuleEngine.isGameComplete(board))
                break;
            // Ai should only suggest move
            Move move = AiEngine.suggestMove(board, comp);
            // board should make the moves on itself
            board.makeMove(move);
        }
    }
}
