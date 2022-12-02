import javax.swing.*;
import java.awt.*;

public class MazeDisplay extends JPanel{
    MazeData mazeData;
    Player player;
    MazeDisplay(MazeData mazeData, Player player) {
        setPreferredSize(new Dimension(2000,1000));
        this.mazeData = mazeData;
        this.player = player;
    }

    public void tryMove(int xInc, int yInc, int wall) {
        if (mazeData.isAccessible(player.getX(), player.getY(), wall)) {
            player.incX(xInc);
            player.incY(yInc);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,1000,1040);

        int xShift = Math.max(Math.min(500 - player.getX() * 50, 0), -500);
        int yShift = Math.max(Math.min(500 - player.getY() * 50, 0), -500);

        for (Cell[] row : mazeData.getCells()) {
            for (Cell column : row) {
                paintCell(g2d, column, xShift, yShift);
            }
        }

        g2d.drawRect(xShift + player.getX() * 50 + 10, yShift + player.getY() * 50 + 10, 30, 30);
    }

    private void paintCell(Graphics2D g2d, Cell cell, int xShift, int yShift) {
        int adjX = cell.getX() * 50 + xShift;
        int adjY = cell.getY() * 50 + yShift;
        if (cell.getWall(3)) {
            g2d.drawLine(adjX, adjY, adjX + 50, adjY);
        }
        if (cell.getWall(1)) {
            g2d.drawLine(adjX, adjY, adjX, adjY + 50);
        }
        if (cell.getWall(2)) {
            g2d.drawLine(adjX + 50, adjY, adjX + 50, adjY + 50);
        }
        if (cell.getWall(0)) {
            g2d.drawLine(adjX, adjY + 50, adjX + 50, adjY + 50);
        }
    }

}
