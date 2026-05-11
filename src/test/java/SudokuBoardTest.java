//package com.example.sudoku;

import org.example.PuzzleGenerator;
import org.example.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    void shouldPlaceValueInEmptyCell() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        boolean result =
                board.setCell(0, 2, 4);

        assertTrue(result);
        assertEquals(4,
                board.getCell(0, 2));
    }

    @Test
    void shouldNotModifyFixedCell() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        boolean result =
                board.setCell(0, 0, 9);

        assertFalse(result);
        assertEquals(5,
                board.getCell(0, 0));
    }

    @Test
    void shouldClearCell() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        board.setCell(0, 2, 4);

        boolean result =
                board.clearCell(0, 2);

        assertTrue(result);
        assertEquals(0,
                board.getCell(0, 2));
    }
}