package org.example;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public boolean isValidBoard(
            SudokuBoard board) {

        return validateRows(board)
                && validateColumns(board)
                && validateSubgrids(board);
    }

    private boolean validateRows(
            SudokuBoard board) {

        for (int row = 0; row < board.getSize(); row++) {

            Set<Integer> seen =
                    new HashSet<>();

            for (int col = 0; col < board.getSize(); col++) {

                int value =
                        board.getCell(row, col);

                if (value == 0) {
                    continue;
                }

                if (!seen.add(value)) {

                    System.out.println(
                            "Number "
                                    + value
                                    + " already exists in Row "
                                    + (char) ('A' + row)
                                    + ".");

                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateColumns(
            SudokuBoard board) {

        for (int col = 0; col < board.getSize(); col++) {

            Set<Integer> seen =
                    new HashSet<>();

            for (int row = 0; row < board.getSize(); row++) {

                int value =
                        board.getCell(row, col);

                if (value == 0) {
                    continue;
                }

                if (!seen.add(value)) {

                    System.out.println(
                            "Number "
                                    + value
                                    + " already exists in Column "
                                    + (col + 1)
                                    + ".");

                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateSubgrids(
            SudokuBoard board) {

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {

            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Integer> seen =
                        new HashSet<>();

                for (int row = boxRow;
                     row < boxRow + 3;
                     row++) {

                    for (int col = boxCol;
                         col < boxCol + 3;
                         col++) {

                        int value =
                                board.getCell(row, col);

                        if (value == 0) {
                            continue;
                        }

                        if (!seen.add(value)) {

                            System.out.println(
                                    "Number "
                                            + value
                                            + " already exists in the same 3x3 subgrid.");

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}