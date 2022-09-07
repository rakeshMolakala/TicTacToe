package tictactoe;

/**
 * TicTacToe controller that handles the control between model and view.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final TicTacToe model;
  private final TicTacToeView view;

  /**
   * TicTacToe controller constructor that takes in the model and the view.
   *
   * @param model TicTacToe model
   * @param view  TicTacToe view
   */
  public TicTacToeConsoleController(TicTacToeModel model, TicTacToeView view) {
    this.model = model;
    this.view = view;
    view.addClickListener(this);
  }

  @Override
  public void playGame(TicTacToe m) {
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    try {
      model.move(col - 1, row - 1);
      view.refresh();
    } catch (IllegalStateException | IllegalArgumentException ignored) { }
  }
}
