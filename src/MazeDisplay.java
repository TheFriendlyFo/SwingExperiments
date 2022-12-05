import javax.swing.*;
import java.awt.*;

public class MazeDisplay extends JPanel{
    private final MazeData mazeData;
    private final Player player;
    int cellSize;
    int solved;
    MazeDisplay(MazeData mazeData, Player player, int cellSize) {
        setPreferredSize(new Dimension(750,1000));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.mazeData = mazeData;
        this.player = player;
        this.cellSize = cellSize;
        solved = 0;
    }

    public MazeData getData() {
        return mazeData;
    }

    public Player getPlayer() {
        return player;
    }
    public void setSolved(int solved) {
        this.solved = solved;
    }

    public void tryMove(int xInc, int yInc, int wall) {
        if (mazeData.isAccessible(player.getX(), player.getY(), wall)) {
            player.incX(xInc);
            player.incY(yInc);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,750,1000);
        if (solved == 0) {
            int xShift = -Math.min(Math.max(cellSize * player.getX() - 375, 0), cellSize * mazeData.getWidth() - 700);
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
        } else if (solved == 1) {

        }
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
