package single.resp.principle;

public class AiEngine {
    /*
     * The AIEngine should only suggest move
     * It should not modify the state of board
     * Acting the moves on board is the respons of Board itself.
     */
    public static Move suggestMove(Board board, Player player) {
        return new Move(player, 0, 0);
    }
}
