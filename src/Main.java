import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10,10);
        Maze maze = new Maze(25,25,player);
        MyFrame frame = new MyFrame(maze);


    }
}
