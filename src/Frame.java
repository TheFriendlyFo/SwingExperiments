import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
    MazeDisplay maze1, maze2;
    
    Frame() {
        setSize(2000,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        addKeyListener(this);

        maze1 = new MazeDisplay(new MazeData(30,30), new Player());
        maze2 = new MazeDisplay(new MazeData(30,30), new Player());
        maze1.setBounds(0,0,1000,1000);
        maze2.setBounds(1000,0,1000,1000);
        add(maze2);
        add(maze1);
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
