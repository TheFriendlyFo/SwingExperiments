// USE WASD AND ARROW KEYS
// ^
// |
// |
// |
// |
// |






import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
    MazeDisplay maze1, maze2;

    int solved;
    
    Frame() {
        solved = 0;
        setSize(1500,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        addKeyListener(this);
        MazeData maze = new MazeData(9, 9);

        maze1 = new MazeDisplay(maze, new Player(), 50);
        maze2 = new MazeDisplay(maze, new Player(), 50);

        maze2.setBounds(750,0,750,1000);
        maze1.setBounds(0,0,750,1000);

        add(maze2, BorderLayout.WEST);
        add(maze1, BorderLayout.WEST);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        solved = maze1.getPlayer().getX() == maze1.getData().getWidth() - 1 && maze1.getPlayer().getY() == maze1.getData().getHeight() - 1
                ? 1 : maze2.getPlayer().getX() == maze2.getData().getWidth() - 1 && maze2.getPlayer().getY() == maze2.getData().getHeight() - 1
                ? 2 : 0;
        if (solved == 1) {
            maze1.setSolved(1);
            maze2.setSolved(2);
        } else if (solved == 2) {
            maze1.setSolved(2);
            maze2.setSolved(1);
        } else {
            switch (e.getKeyCode()) {
                case (87) -> maze1.tryMove(0, -1, 3);
                case (83) -> maze1.tryMove(0, 1, 0);
                case (65) -> maze1.tryMove(-1, 0, 1);
                case (68) -> maze1.tryMove(1, 0, 2);
                case (KeyEvent.VK_UP) -> maze2.tryMove(0, -1, 3);
                case (KeyEvent.VK_DOWN) -> maze2.tryMove(0, 1, 0);
                case (KeyEvent.VK_LEFT) -> maze2.tryMove(-1, 0, 1);
                case (KeyEvent.VK_RIGHT) -> maze2.tryMove(1, 0, 2);
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
