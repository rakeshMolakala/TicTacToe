package tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * TicTacToe board that represents the board view.
 */
public class BoardPanel extends JPanel {
  private final ReadonlyTttModel model;

  /**
   * Board panel constructor that takes in the readonly TicTacToe model.
   *
   * @param model readonly TicTacToe model
   */
  public BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Player[][] board = model.getBoard();
    g.setFont(g.getFont().deriveFont(30f));
    if (!model.isGameOver()) {
      g2d.drawString(String.format("Player %s turn", model.getTurn()), 350, 50);
    } else {
      if (model.getWinner() == null) {
        g2d.drawString("Oops, it's a draw match!", 350, 50);
      } else {
        g2d.drawString(String.format("Game Over! Player %s wins!",
                model.getWinner()), 350, 50);
      }
    }
    g2d.setPaint(Color.BLACK);
    g2d.drawRect(0, 0, 100, 100);
    g2d.fillRect(0, 0, 100, 100);
    g2d.setPaint(Color.WHITE);
    g2d.drawRect(100, 0, 100, 100);
    g2d.fillRect(100, 0, 100, 100);
    g2d.setPaint(Color.BLACK);
    g2d.drawRect(200, 0, 100, 100);
    g2d.fillRect(200, 0, 100, 100);
    g2d.setPaint(Color.WHITE);
    g2d.drawRect(0, 100, 100, 100);
    g2d.fillRect(0, 100, 100, 100);
    g2d.setPaint(Color.BLACK);
    g2d.drawRect(100, 100, 100, 100);
    g2d.fillRect(100, 100, 100, 100);
    g2d.setPaint(Color.WHITE);
    g2d.drawRect(200, 100, 100, 100);
    g2d.fillRect(200, 100, 100, 100);
    g2d.setPaint(Color.BLACK);
    g2d.drawRect(0, 200, 100, 100);
    g2d.fillRect(0, 200, 100, 100);
    g2d.setPaint(Color.WHITE);
    g2d.drawRect(100, 200, 100, 100);
    g2d.fillRect(100, 200, 100, 100);
    g2d.setPaint(Color.BLACK);
    g2d.drawRect(200, 200, 100, 100);
    g2d.fillRect(200, 200, 100, 100);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] != null) {
          g2d.setPaint(Color.RED);
          g2d.setStroke(new BasicStroke(3));
          if (board[i][j] == Player.X) {
            g2d.drawLine((100 * j) + 20, (100 * i) + 20, 100 * (j + 1) - 20,
                    100 * (i + 1) - 20);
            g2d.drawLine(100 * (j + 1) - 20, (100 * i) + 20, (100 * j) + 20,
                    100 * (i + 1) - 20);
          } else {
            g2d.setPaint(Color.GREEN);
            g2d.drawOval((100 * j) + 10, (100 * i) + 10, 80, 80);
          }
        }
      }
    }
  }
}
