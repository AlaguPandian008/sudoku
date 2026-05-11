
import org.example.PuzzleGenerator;
import org.example.SudokuBoard;
import org.example.SudokuValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuValidatorTest {

    @Test
    void shouldDetectRowViolation() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        board.setCell(0, 2, 3);

        SudokuValidator validator =
                new SudokuValidator();

        boolean result =
                validator.isValidBoard(board);

        assertFalse(result);
    }

    @Test
    void shouldDetectColumnViolation() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        board.setCell(2, 0, 5);

        SudokuValidator validator =
                new SudokuValidator();

        boolean result =
                validator.isValidBoard(board);

        assertFalse(result);
    }

    @Test
    void shouldDetectSubgridViolation() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        board.setCell(1, 2, 8);

        SudokuValidator validator =
                new SudokuValidator();

        boolean result =
                validator.isValidBoard(board);

        assertFalse(result);
    }
}