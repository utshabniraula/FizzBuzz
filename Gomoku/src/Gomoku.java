/**
 * Gomoku Game Implementation
 * This program implements the game of Gomoku (five-in-a-row) using Java.
 * The game is played on a grid, and players take turns placing their markers (RING or CROSS).
 * The goal is to get five markers in a row (horizontally, vertically, or diagonally).
 * The program supports a basic computer player and tracks the winner of the previous game
 * to determine the starting player for the next round.
 *
 * Author: UTSHAB NIRAULA
 */

import cs251.project2.*;
import java.util.Random;

public class Gomoku implements GomokuInterface {
    // Random object to generate random numbers (used for deciding the starting player)
    private final Random random = new Random();

    // 2D array to represent the game board
    private Square[][] board;

    // Tracks whose turn it is (RING or CROSS)
    private Square currentTurn;

    // Flag to enable/disable the computer player
    private boolean isComputerPlayerEnabled = false;

    // Tracks which player the computer is (CROSS by default)
    private Square computerPlayerSquare;

    // Tracks the winner of the previous game (null if no previous winner or if the game was a draw)
    private Square previousWinner = null;

    /**
     * Constructor: Initializes the game when a Gomoku object is created.
     */
    public Gomoku() {
        initializeGame();
    }

    /**
     * Returns the number of rows in the game board (default is 30).
     *
     * @return The number of rows in the game board.
     */
    public int getNumRows() {
        return DEFAULT_NUM_ROWS;
    }

    /**
     * Returns the number of columns in the game board (default is 30).
     *
     * @return The number of columns in the game board.
     */
    public int getNumCols() {
        return DEFAULT_NUM_COLS;
    }

    /**
     * Returns the number of squares in a line needed to win (default is 5).
     *
     * @return The number of squares in a line needed to win.
     */
    public int getNumInLineForWin() {
        return SQUARES_IN_LINE_FOR_WIN;
    }

    /**
     * Initializes the game by setting up the board and determining the starting player.
     * If there was a previous winner, that player starts the next game.
     * Otherwise, a random player is chosen to start.
     */
    public void initializeGame() {
        // Create a new board with all squares set to EMPTY
        board = new Square[getNumRows()][getNumCols()];
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                board[i][j] = Square.EMPTY;
            }
        }

        // If there was a previous winner, start with that player
        if (previousWinner != null) {
            currentTurn = previousWinner;
        } else {
            // Otherwise, choose a random player to start
            int rand = random.nextInt(2);
            currentTurn = (rand == 0) ? Square.RING : Square.CROSS;
        }
    }

    /**
     * Handles a click on the game board at the specified row and column.
     * If the square is empty, the current player places their marker.
     * The method then checks if the move resulted in a win or a draw.
     * If the game is not over, the turn switches to the other player.
     * If the computer player is enabled, it makes its move after the human player.
     *
     * @param row The row where the click occurred.
     * @param col The column where the click occurred.
     * @return The result of the move (e.g., GAME_NOT_OVER, RING_WINS, CROSS_WINS, DRAW).
     */
    public TurnResult handleClickAt(int row, int col) {
        if (board[row][col] == Square.EMPTY) {
            // Place the current player's marker on the board
            board[row][col] = currentTurn;

            // Check if this move caused a win or a draw
            TurnResult result = checkForWin(row, col);

            if (result == TurnResult.GAME_NOT_OVER) {
                // Switch turns to the other player
                currentTurn = (currentTurn == Square.RING) ? Square.CROSS : Square.RING;

                // If the computer player is enabled and it's their turn, make their move
                if (isComputerPlayerEnabled && currentTurn == computerPlayerSquare) {
                    computerMove();
                    result = checkForWin(row, col); // Check if the computer's move caused a win or draw
                }
            } else {
                // Update the previousWinner based on the result
                if (result == TurnResult.RING_WINS) {
                    previousWinner = Square.RING;
                } else if (result == TurnResult.CROSS_WINS) {
                    previousWinner = Square.CROSS;
                } else if (result == TurnResult.DRAW) {
                    previousWinner = null; // No winner in case of a draw
                }
            }

            return result;
        }

        // If the square is already occupied, do nothing and return GAME_NOT_OVER
        return TurnResult.GAME_NOT_OVER;
    }

    /**
     * Checks if the current move resulted in a win or a draw.
     * The method checks for five-in-a-row (or the specified number) horizontally,
     * vertically, or diagonally.
     *
     * @param row The row of the last move.
     * @param col The column of the last move.
     * @return The result of the check (e.g., RING_WINS, CROSS_WINS, DRAW, GAME_NOT_OVER).
     */
    private TurnResult checkForWin(int row, int col) {
        Square currentSquare = board[row][col];
        if (currentSquare == Square.EMPTY) {
            return TurnResult.GAME_NOT_OVER;
        }

        // Directions: horizontal, vertical, diagonal (top-left to bottom-right), diagonal (bottom-left to top-right)
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        for (int[] dir : directions) {
            int count = 1;

            // Check in the positive direction
            int r = row + dir[0];
            int c = col + dir[1];
            while (r >= 0 && r < getNumRows() && c >= 0 && c < getNumCols() && board[r][c] == currentSquare) {
                count++;
                r += dir[0];
                c += dir[1];
            }

            // Check in the negative direction
            r = row - dir[0];
            c = col - dir[1];
            while (r >= 0 && r < getNumRows() && c >= 0 && c < getNumCols() && board[r][c] == currentSquare) {
                count++;
                r -= dir[0];
                c -= dir[1];
            }

            // If we have enough in a row, return the corresponding win result
            if (count >= getNumInLineForWin()) {
                return (currentSquare == Square.RING) ? TurnResult.RING_WINS : TurnResult.CROSS_WINS;
            }
        }

        // Check for a draw (if the board is full)
        boolean isDraw = true;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (board[i][j] == Square.EMPTY) {
                    isDraw = false;
                    break;
                }
            }
        }
        if (isDraw) {
            return TurnResult.DRAW;
        }

        // If no win or draw, the game continues
        return TurnResult.GAME_NOT_OVER;
    }

    /**
     * Returns a string representation of the current game board.
     * The string is formatted with each row on a new line.
     *
     * @return A string representation of the game board.
     */
    public String getCurrentBoardAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                sb.append(board[i][j].toChar());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns the current player's turn (RING or CROSS).
     *
     * @return The current player's turn.
     */
    public Square getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Initializes the computer player based on the provided argument.
     * If the argument is "COMPUTER", the computer player is enabled.
     * If the argument is "NONE", the computer player is disabled.
     *
     * @param opponent The argument specifying whether to enable the computer player.
     */
    public void initComputerPlayer(String opponent) {
        if (opponent.equals("COMPUTER")) {
            isComputerPlayerEnabled = true;
            computerPlayerSquare = Square.CROSS; // Assume computer is CROSS
        } else if (opponent.equals("NONE")) {
            isComputerPlayerEnabled = false;
        }
    }

    /**
     * Makes a move for the computer player.
     * The computer places its marker in the first available square.
     */
    private void computerMove() {
        if (!isComputerPlayerEnabled) return;

        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumCols(); j++) {
                if (board[i][j] == Square.EMPTY) {
                    board[i][j] = computerPlayerSquare;
                    TurnResult result = checkForWin(i, j);
                    if (result == TurnResult.GAME_NOT_OVER) {
                        currentTurn = Square.RING; // Switch back to human player
                    }
                    return;
                }
            }
        }
    }

    /**
     * Main method to start the Gomoku game.
     * If a command-line argument is provided, it initializes the computer player.
     *
     * @param args Command-line arguments (optional: "COMPUTER" to enable the computer player).
     */
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        if (args.length > 0) {
            game.initComputerPlayer(args[0]);
        }
        GomokuGUI.showGUI(game);
    }
}