package org.example;

public class ConsoleRenderer {

    public void render(SudokuBoard board) {

        System.out.println();
        System.out.println("Current grid:");

        printHeader();

        for (int row = 0; row < board.getSize(); row++) {

            char rowLabel = (char) ('A' + row);

            System.out.print("  " + rowLabel + " ");

            for (int col = 0; col < board.getSize(); col++) {

                int value =
                        board.getCell(row, col);

                if (value == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(value + " ");
                }
            }

            System.out.println();
        }
    }

    private void printHeader() {

        System.out.println(
                "    1 2 3 4 5 6 7 8 9");
    }
}
