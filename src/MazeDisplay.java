import javax.swing.*;
import java.awt.*;

public class MazeDisplay extends JPanel{
    MazeData mazeData;
    Player player;
    int cellSize;
    MazeDisplay(MazeData mazeData, Player player, int cellSize) {
        setPreferredSize(new Dimension(750,1000));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.mazeData = mazeData;
        this.player = player;
        this.cellSize = cellSize;
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

        int xShift = Math.max(Math.min(mazeData.getWidth()*cellSize - 750 - player.getX() * cellSize, 0), -mazeData.getWidth()*cellSize - 750);
        int yShift = Math.max(Math.min(375 - player.getY() * cellSize, 0), -mazeData.getWidth()*cellSize - 750);

        for (Cell[] row : mazeData.getCells()) {
            for (Cell column : row) {
                paintCell(g2d, column, xShift, yShift);
            }
        }

        g2d.drawRect(
                xShift + player.getX() * cellSize + cellSize/5,
                yShift + player.getY() * cellSize + cellSize/5,
                cellSize/5*3,
                cellSize/5*3
        );
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
