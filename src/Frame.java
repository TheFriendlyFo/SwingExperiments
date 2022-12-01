import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    MyPanel panel;
    Maze maze;
    Player player;
    
    Frame(Maze maze, Player player) {
        setSize(1000,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        setLocationRelativeTo(null);
        addKeyListener(this);

        this.maze = maze;
        this.player = player;

        panel = new MyPanel(maze, player);
        add(panel);
        pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case ('w') :
                if (maze.isAccessible(player.getX(), player.getY(), 3)) {
                    player.incY(false);
                }
            case ('s') :
                if (maze.isAccessible(player.getX(), player.getY(), 0)) {
                    player.incY(true);
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
