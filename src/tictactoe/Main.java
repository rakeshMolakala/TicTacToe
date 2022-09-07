package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {
    TicTacToeModel m = new TicTacToeModel();
    TicTacToeView v = new TicTacToeViewClass(m);
    new TicTacToeConsoleController(m, v).playGame(m);
  }
}
