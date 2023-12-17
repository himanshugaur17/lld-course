package single.resp.principle;

class TicTacToeBoard extends Board {
    private char[][] boardMatrix;
    int n, m;

    @Override
    boolean makeMove(Move move) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }

    @Override
    public char getCellValue(int i, int j) {
        return boardMatrix[i][j];
    }
}

abstract class Board {
    abstract boolean makeMove(Move move);

    abstract char getCellValue(int i, int j);
}
