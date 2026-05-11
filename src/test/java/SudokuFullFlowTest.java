import org.example.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuFullFlowTest {

    private void run(String input, StringBuilder outputHolder) {

        System.setIn(
                new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        outputHolder.append(out);
    }

    @Test
    void shouldCoverAllMainBranchesInOneFlow() {

        StringBuilder output =
                new StringBuilder();

        String input =
                "A3 4\n" +        // valid move
                        "check\n" +       // check branch
                        "hint\n" +        // hint branch
                        "A3 abc\n" +      // invalid number
                        "A99 5\n" +       // invalid position
                        "badinput\n" +    // invalid command format
                        "C5 clear\n" +    // clear branch
                        "quit\n";         // exit

        run(input, output);

        String result = output.toString();

        // Core validations
        assertTrue(result.contains("Welcome to Sudoku!"));
        assertTrue(result.contains("Enter command"));
        assertTrue(result.contains("Hint"));
        assertTrue(result.contains("Move accepted")
                || result.contains("Cannot clear"));
        assertTrue(result.contains("Invalid"));
        assertTrue(result.contains("Goodbye!"));
    }
}