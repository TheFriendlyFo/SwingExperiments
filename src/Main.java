import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(0,0);
        Maze maze = new Maze(100,100,player);

        Frame frame = new Frame(maze, player);

        MyPanel panel = new MyPanel(maze, player);
        frame.add(panel);
        frame.pack();


    }
}
