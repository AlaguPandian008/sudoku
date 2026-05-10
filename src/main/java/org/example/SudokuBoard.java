package org.example;

public class SudokuBoard {

    private static final int SIZE = 9;

    private final int[][] board;
    private final int[][] solution;
    private final boolean[][] fixedCells;

    public SudokuBoard(
            int[][] puzzle,
            int[][] solution) {

        this.board = new int[SIZE][SIZE];
        this.solution = solution;
        this.fixedCells = new boolean[SIZE][SIZE];

        loadPuzzle(puzzle);
    }

    private void loadPuzzle(int[][] puzzle) {

        for (int row = 0; row < SIZE; row++) {

            for (int col = 0; col < SIZE; col++) {

                board[row][col] = puzzle[row][col];

                fixedCells[row][col] =
                        puzzle[row][col] != 0;
            }
        }
    }

    public boolean setCell(
            int row,
            int col,
            int value) {

        if (fixedCells[row][col]) {

            System.out.println(
                    "Invalid move. "
                            + getCellName(row, col)
                            + " is pre-filled.");

            return false;
        }

        if (value < 1 || value > 9) {
            System.out.println(
                    "Number must be between 1 and 9.");
            return false;
        }

        board[row][col] = value;

        return true;
    }

    public boolean clearCell(int row, int col) {

        if (fixedCells[row][col]) {
            return false;
        }

        board[row][col] = 0;

        return true;
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public int getSolutionValue(
            int row,
            int col) {

        return solution[row][col];
    }

    public void fillHint(
            int row,
            int col,
            int value) {

        if (!fixedCells[row][col]) {
            board[row][col] = value;
        }
    }

    public int getSize() {
        return SIZE;
    }

    private String getCellName(
            int row,
            int col) {

        char rowLabel = (char) ('A' + row);

        return rowLabel + String.valueOf(col + 1);
    }
}