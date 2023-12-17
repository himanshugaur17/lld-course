package single.resp.principle;

import java.util.Arrays;

class RuleEngine {
    public static boolean isGameComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            int rows = ((TicTacToeBoard) board).n, cols = ((TicTacToeBoard) board).m;
            boolean gameCompletion = checkGameCompletionRowColWise(board, rows, cols);
            if (!gameCompletion)
                return checkGameCompletionDiag(board, rows, cols);
            return gameCompletion;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkGameCompletionDiag(Board board, int rows, int cols) {
        if (rows != cols)
            return false;

        boolean diag = true, revDiag = true;
        char placed = board.getCellValue(0, 0);
        if (placed == 'X' || placed == 'O') {
            for (int i = 0; i < rows; i++)
                if (board.getCellValue(i, i) != placed) {
                    diag = false;
                    break;
                }
        } else
            diag = false;
        if (diag == true)
            return true;
        placed = board.getCellValue(0, rows - 1);
        if (placed == 'X' || placed == 'O') {
            for (int j = rows - 1; j >= 0; j--)
                if (board.getCellValue(j, rows - j - 1) != placed) {
                    revDiag = false;
                    break;
                }
        } else
            revDiag = false;
        return revDiag;
    }

    private static boolean checkGameCompletionRowColWise(Board board, int rows, int cols) {
        int rowCount[] = new int[rows];
        int[] colCount = new int[cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                char cell = board.getCellValue(i, j);
                int fact = 0;
                if (cell == 'N') {
                    rowCount[i] = -1;
                    colCount[j] = -1;
                    continue;
                }
                if (cell == 'X')
                    fact = 1;
                else
                    fact = -1;
                rowCount[i] = rowCount[i] == -1 ? rowCount[i] : rowCount[i] + fact;
                colCount[j] = colCount[j] == -1 ? colCount[j] : colCount[j] + fact;

            }
        return Arrays.stream(colCount).anyMatch(col -> col == rows || col == -rows)
                || Arrays.stream(rowCount).anyMatch(row -> row == cols || row == -cols);
    }

    public char getWinnerChar(Board board) {
        return 'x';
    }
}
