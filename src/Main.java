import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MazeData maze = new MazeData(19,19);
        MazeData maze2 = new MazeData(19,19);

        Player player1 = new Player();
        Player player2 = new Player();

        JLabel leftWinLabel = new JLabel("", SwingConstants.CENTER);
        leftWinLabel.setSize(new Dimension(750,1000));
        leftWinLabel.setBounds(0,0,750,1000);
        leftWinLabel.setMinimumSize(leftWinLabel.getPreferredSize());
        leftWinLabel.setFont(new Font("Serif", Font.BOLD, 40));

        JLabel rightWinLabel = new JLabel("", SwingConstants.CENTER);
        rightWinLabel.setSize(new Dimension(750,1000));
        rightWinLabel.setBounds(750,0,750,1000);
        rightWinLabel.setFont(new Font("Serif", Font.BOLD, 40));

        DisplayPanel leftPanel = new DisplayPanel(maze, player1, 75, leftWinLabel);
        DisplayPanel rightPanel = new DisplayPanel(maze2, player2, 75, rightWinLabel);

        Frame frame = new Frame(leftPanel, rightPanel);

        frame.add(leftWinLabel);
        frame.add(rightWinLabel);
        frame.add(rightPanel);
        frame.add(leftPanel);
    }
}
