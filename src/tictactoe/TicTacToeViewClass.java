package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * TicTacToe view that enables the user to play the game.
 */
public class TicTacToeViewClass extends JFrame implements TicTacToeView {
  private final BoardPanel boardPanel;

  /**
   * TicTacToe view constructor that takes in the readonly TicTacToe model.
   *
   * @param model readonly TicTacToe model
   */
  public TicTacToeViewClass(ReadonlyTttModel model) {
    super("Tic-Tac-Toe Game");
    this.setSize(800, 450);
    this.getContentPane().setBackground(Color.BLACK);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel,BorderLayout.CENTER);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter clickAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int x = e.getX();
        int y = e.getY();
        if (x >= 0 && x < 100) {
          x = 1;
        } else if (x >= 100 && x < 200) {
          x = 2;
        } else if (x >= 200 && x < 300) {
          x = 3;
        }
        if (y >= 0 && y < 100) {
          y = 1;
        } else if (y >= 100 && y < 200) {
          y = 2;
        } else if (y >= 200 && y < 300) {
          y = 3;
        }
        listener.handleCellClick(x, y);
      }
    };
    boardPanel.addMouseListener(clickAdapter);
  }

  @Override
  public void refresh() {
    repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
