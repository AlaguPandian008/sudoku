
import org.example.ConsoleRenderer;
import org.example.PuzzleGenerator;
import org.example.SudokuBoard;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleRendererTest {

    @Test
    void shouldRenderBoardCorrectly() {

        SudokuBoard board =
                PuzzleGenerator.createPuzzle();

        ConsoleRenderer renderer =
                new ConsoleRenderer();

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));

        renderer.render(board);

        String result = output.toString();

        assertTrue(result.contains("Current grid:"));
        assertTrue(result.contains("1 2 3 4 5 6 7 8 9"));
        assertTrue(result.contains("A 5 3 _ _ 7 _ _ _ _"));
        assertTrue(result.contains("I _ _ _ _ 8 _ _ 7 9"));
    }
}