import org.example.PuzzleGenerator;
import org.example.SudokuBoard;
import org.example.SudokuSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuSolverTest {

    @Test
    void shouldGiveHint() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        SudokuSolver solver =
                new SudokuSolver();

        solver.giveHint(board);

        assertNotEquals(
                0,
                board.getCell(0, 2));
    }

    @Test
    void shouldDetectSolvedBoard() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        for (int row = 0; row < board.getSize(); row++) {

            for (int col = 0; col < board.getSize(); col++) {

                if (board.getCell(row, col) == 0) {

                    board.fillHint(
                            row,
                            col,
                            board.getSolutionValue(row, col));
                }
            }
        }

        SudokuSolver solver =
                new SudokuSolver();

        assertTrue(solver.isSolved(board));
    }
}