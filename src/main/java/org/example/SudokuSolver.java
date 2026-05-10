package org.example;


public class SudokuSolver {

    private final SudokuValidator validator;

    public SudokuSolver() {
        validator = new SudokuValidator();
    }

    public boolean isSolved(
            SudokuBoard board) {

        if (hasEmptyCells(board)) {
            return false;
        }

        return validator.isValidBoard(board);
    }

    public void giveHint(
            SudokuBoard board) {

        for (int row = 0; row < board.getSize(); row++) {

            for (int col = 0; col < board.getSize(); col++) {

                if (board.getCell(row, col) != 0) {
                    continue;
                }

                int correctValue =
                        board.getSolutionValue(row, col);

                board.fillHint(
                        row,
                        col,
                        correctValue);

                printHint(
                        row,
                        col,
                        correctValue);

                return;
            }
        }

        System.out.println("No hints available.");
    }

    private boolean hasEmptyCells(
            SudokuBoard board) {

        for (int row = 0; row < board.getSize(); row++) {

            for (int col = 0; col < board.getSize(); col++) {

                if (board.getCell(row, col) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private void printHint(
            int row,
            int col,
            int value) {

        char rowLabel = (char) ('A' + row);

        System.out.println(
                "Hint: Cell "
                        + rowLabel
                        + (col + 1)
                        + " = "
                        + value);
    }
}