# Sudoku CLI Game – Design Document

## 1. Overview
This is a Java-based command-line Sudoku application where users play Sudoku using text commands. The system handles puzzle generation, user interactions, validation rules, hints, and completion detection. The focus is on clean modular design, separation of concerns, and testable logic.

---

## 2. Functional Requirements

### Game Start
- The system generates a valid Sudoku puzzle at startup.
- The puzzle contains 30 pre-filled numbers.
- Empty cells are displayed as `_`.

---

### User Commands
- `A3 4` → Place number 4 at row A, column 3
- `C5 clear` → Clear a cell (only if it is not pre-filled)
- `hint` → Reveal one correct value in the grid
- `check` → Validate current board state
- `quit` → Exit the game

---

### Rules
- Numbers must be between 1 and 9
- Pre-filled cells cannot be modified
- Sudoku rules must always be followed:
    - No duplicates in a row
    - No duplicates in a column
    - No duplicates in a 3×3 subgrid

---

## 3. System Design

The system is designed using a layered approach:

User Input → Main Controller → Game Logic Layer → Data Layer → Output Renderer

---

## 4. Core Components

### 4.1 Main
**Responsibility:** Entry point and game controller.

**Key Methods:**
- `main(String[] args)`  
  Starts the application.

- `start()`  
  Runs the main game loop (display board → read input → process command → repeat).

- `handleMove(SudokuBoard board, String input)`  
  Processes user commands such as placing values, clearing cells, and validating input format.

- `checkBoard(SudokuBoard board)`  
  Calls validator to check if the board is valid and prints the result.

---

### 4.2 SudokuBoard
**Responsibility:** Stores and manages the Sudoku grid state.

**Key Methods:**
- `getCell(int row, int col)`  
  Returns value at a given position.

- `setCell(int row, int col, int value)`  
  Places a value if the move is valid and cell is not fixed.

- `clearCell(int row, int col)`  
  Clears a cell if it is not part of the initial puzzle.

- `getSize()`  
  Returns board size (9).

---

### 4.3 SudokuValidator
**Responsibility:** Ensures all Sudoku rules are followed.

**Key Methods:**
- `isValidBoard(SudokuBoard board)`  
  Validates entire board.

- `hasRowConflict(...)`  
  Checks duplicate values in a row.

- `hasColumnConflict(...)`  
  Checks duplicate values in a column.

- `hasSubgridConflict(...)`  
  Checks duplicate values in a 3×3 subgrid.

---

### 4.4 SudokuSolver
**Responsibility:** Provides solving logic and hint functionality.

**Key Methods:**
- `giveHint(SudokuBoard board)`  
  Reveals one correct missing value.

- `isSolved(SudokuBoard board)`  
  Checks if the puzzle is fully solved and valid.

- `solve(...)`  
  Solves the Sudoku puzzle using backtracking logic.

---

### 4.5 PuzzleGenerator
**Responsibility:** Generates playable Sudoku puzzles.

**Key Methods:**
- `createPuzzle()`  
  Creates a valid puzzle with 30 pre-filled values.

- `generateFullBoard()`  
  Generates a complete solved Sudoku board.

- `removeCells(...)`  
  Removes values while ensuring the puzzle remains solvable.

---

### 4.6 ConsoleRenderer
**Responsibility:** Handles all console output formatting.

**Key Methods:**
- `render(SudokuBoard board)`  
  Displays the Sudoku grid in a readable format.

- `printHeader()`  
  Prints column labels (1–9).

---

## 5. Architecture Design

The system follows a clean separation of concerns:

- **Presentation Layer:** ConsoleRenderer, Main
- **Business Logic Layer:** SudokuSolver, SudokuValidator
- **Data Layer:** SudokuBoard
- **Utility Layer:** PuzzleGenerator

---

## 6. Key Design Principles

### 6.1 Single Responsibility Principle
Each class has only one responsibility (e.g., Board stores data, Validator checks rules).

### 6.2 Separation of Concerns
UI logic (console) is separated from game logic and data management.

### 6.3 Testability
Core logic is independent of user input/output, making unit testing possible.

### 6.4 Maintainability
Each feature is modular, so changes in one component do not affect others.

### 6.5 Extensibility
The design supports future enhancements such as new puzzle sizes or different interfaces.

---

## 7. Assumptions

- Only one puzzle runs per session
- Input format strictly follows defined commands
- Generated puzzle is always valid and solvable
- Pre-filled cells cannot be changed
- Solver always produces a correct solution when required

---

## 8. Summary

The Sudoku CLI system is designed with simplicity and modularity in mind. Each component has a clear responsibility, ensuring the system is easy to understand, test, and maintain. The architecture cleanly separates input handling, game logic, validation, and output rendering, making it suitable for future enhancements.