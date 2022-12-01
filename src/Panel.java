import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    Maze maze;
    Player player;
    Panel(int height, int width) {
        this.maze = new Maze(height, width);
        this.player = new Player();
    }

    public boolean isAccessible(int wall) {
        return maze.isAccessible(player.getX(),player.getY(),wall);
    }

    public Player getPlayer() {
        return player;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,1000,1040);

        int xShift = Math.max(Math.min(500 - player.getX() * 50, 0), -500);
        int yShift = Math.max(Math.min(500 - player.getY() * 50, 0), -500);

        for (Cell[] row : maze.getCells()) {
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
