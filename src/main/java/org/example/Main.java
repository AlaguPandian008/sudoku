package org.example;

import java.util.Scanner;

public class Main {

    private final ConsoleRenderer renderer;
    private final SudokuValidator validator;
    private final SudokuSolver solver;

    public Main() {
        renderer = new ConsoleRenderer();
        validator = new SudokuValidator();
        solver = new SudokuSolver();
    }

    static void main(String[] args) {
        new Main().start();
    }

    private void start() {

        Scanner scanner = new Scanner(System.in);

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        System.out.println("Welcome to Sudoku!");

        boolean running = true;

        while (running) {

            renderer.render(board);

            if (solver.isSolved(board)) {
                System.out.println();
                System.out.println(
                        "You solved the puzzle!");
                break;
            }

            System.out.println();
            System.out.println(
                    "Enter command (A3 7, C5 clear, hint, check, quit):");

            String input =
                    scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                running = false;
                continue;
            }

            if (input.equalsIgnoreCase("hint")) {
                solver.giveHint(board);
                continue;
            }

            if (input.equalsIgnoreCase("check")) {
                checkBoard(board);
                continue;
            }

            handleMove(board, input);
        }

        System.out.println("Goodbye!");
    }

    private void checkBoard(SudokuBoard board) {

        boolean valid =
                validator.isValidBoard(board);

        if (valid) {
            System.out.println(
                    "No rule violations detected.");
        }
    }

    private void handleMove(
            SudokuBoard board,
            String input) {

        String[] parts = input.split(" ");

        if (parts.length != 2) {
            System.out.println("Invalid command.");
            return;
        }

        String position =
                parts[0].toUpperCase();

        int row = position.charAt(0) - 'A';
        int col = position.charAt(1) - '1';

        if (parts[1].equalsIgnoreCase("clear")) {

            boolean cleared =
                    board.clearCell(row, col);

            if (!cleared) {
                System.out.println(
                        "Cannot clear pre-filled cell.");
            }

            return;
        }

        try {

            int value =
                    Integer.parseInt(parts[1]);

            boolean success =
                    board.setCell(row, col, value);

            if (success) {
                System.out.println("Move accepted.");
            }

        } catch (NumberFormatException ex) {
            System.out.println("Invalid number.");
        }
    }
}