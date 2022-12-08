import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel implements ActionListener {
    private final MazeData mazeData;
    private final Player player;
    private int cellSize;
    private boolean solved;
    private double time;
    private final JLabel winLabel;

    /**
     * Holds a maze and a player traversing that maze, as well as the size of that maze to be readjusted.
     * @param mazeData
     * @param player
     * @param cellSize
     */
    DisplayPanel(MazeData mazeData, Player player, int cellSize, JLabel winLabel) {
        setPreferredSize(new Dimension(750,1000));

        this.mazeData = mazeData;
        this.player = player;
        this.winLabel = winLabel;
        this.cellSize = cellSize;
        this.solved = false;
        this.time = 0;

        Timer timer = new Timer(10, this);
        timer.start();
        winLabel.setHorizontalTextPosition(JLabel.CENTER);
        winLabel.setVerticalTextPosition(JLabel.CENTER);
        winLabel.setVisible(false);
    }

    public MazeData getMazeData() {
        return mazeData;
    }

    public void testSolved() {
        solved = solved
                || (player.getX() == mazeData.getWidth() - 1
                && player.getY() == mazeData.getHeight() - 1);
    }

    public void tryMove(int xInc, int yInc, int wall) {
        if (mazeData.isAccessible(player.getX(), player.getY(), wall)) {
            player.incX(xInc);
            player.incY(yInc);
        }
    }

    public void zoom(boolean in) {
        cellSize = Math.max(Math.min(cellSize + (in ? 5 : -5), 150), 25);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,750,1000);

        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(0,0,750,1000);
        g2d.setStroke(new BasicStroke(1));

        if (!solved) {
            setVisible(false);
            winLabel.setText("Alabalaba");
            winLabel.setVisible(true);
            validate();
            repaint();
            winLabel.validate();
            winLabel.repaint();
        } else {
            int xShift = -Math.min(Math.max(cellSize * player.getX() - 375, 0), cellSize * mazeData.getWidth() - 750);
            int yShift = -Math.min(Math.max(cellSize * player.getY() - 500, 0), cellSize * mazeData.getHeight() - 1000);

            for (Cell[] row : mazeData.getCells()) {
                for (Cell column : row) {
                    paintCell(g2d, column, xShift, yShift);
                }
            }

            g2d.drawOval(
                    xShift + (mazeData.getWidth() - 1) * cellSize + cellSize / 5,
                    yShift + (mazeData.getHeight() - 1) * cellSize + cellSize / 5,
                    cellSize / 5 * 3,
                    cellSize / 5 * 3
            );
            g2d.drawRect(
                    xShift + player.getX() * cellSize + cellSize / 5,
                    yShift + player.getY() * cellSize + cellSize / 5,
                    cellSize / 5 * 3,
                    cellSize / 5 * 3
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time += solved ? 0 : 0.01;
    }

    private void paintCell(Graphics2D g2d, Cell cell, int xShift, int yShift) {
        int adjX = cell.getX() * cellSize + xShift;
        int adjY = cell.getY() * cellSize + yShift;
        if (cell.getWall(3)) {
            g2d.drawLine(adjX, adjY, adjX + cellSize, adjY);
        }
        if (cell.getWall(1)) {
            g2d.drawLine(adjX, adjY, adjX, adjY + cellSize);
        }
        if (cell.getWall(2)) {
            g2d.drawLine(adjX + cellSize, adjY, adjX + cellSize, adjY + cellSize);
        }
        if (cell.getWall(0)) {
            g2d.drawLine(adjX, adjY + cellSize, adjX + cellSize, adjY + cellSize);
        }
    }
}
