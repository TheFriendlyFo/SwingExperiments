import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Maze maze;
    MyPanel(Maze maze) {
        this.maze = maze;
        setPreferredSize(new Dimension(1000,1000));
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int xShift = 500 - 10 * maze.getPlayer().getX();
        int yShift = 500 - 10 * maze.getPlayer().getY();

        for (Cell[] row : maze.getMaze()) {
            for (Cell column : row) {
                g2d.drawOval(column.getX()*10+xShift,column.getY()*10+yShift,10,10);
            }
        }
    }
}
