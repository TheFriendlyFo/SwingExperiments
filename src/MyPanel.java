import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Maze maze;
    Player player;
    MyPanel(Maze maze, Player player) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1000,1000));
        addKeyListener(this);
        this.maze = maze;
        this.player = player;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,1000,1000);
        int xShift = 500 - player.getX() * 50;
        int yShift = 500 - player.getY() * 50;


        for (Cell[] row : maze.getCells()) {
            for (Cell column : row) {
                paintCell(g2d, column, xShift, yShift);
            }
        }

        g2d.drawRect(510, 510, 30, 30);
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

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ('w') :
                if (maze.isAccessible(player.getX(), player.getY(), 3)) {
                    player.incX(false);
                }
            case ('s') :
                if (maze.isAccessible(player.getX(), player.getY(), 0)) {
                    player.incX(true);
                }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
