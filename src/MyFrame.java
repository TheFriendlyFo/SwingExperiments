import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    Maze maze;

    MyFrame(Maze maze) {
        this.maze = maze;
        panel = new MyPanel(maze);
        add(panel);
        pack();

        setSize(1000,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        setLocationRelativeTo(null);
    }
}
