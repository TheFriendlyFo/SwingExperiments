import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MazeData maze = new MazeData(15,15);

        Player player1 = new Player();
        Player player2 = new Player();

        JLabel leftWinLabel = new JLabel();
        leftWinLabel.setSize(750,1000);
        leftWinLabel.setLocation(0,0);        
        JLabel rightWinLabel = new JLabel();
        rightWinLabel.setSize(750,1000);
        rightWinLabel.setLocation(750,0);

        DisplayPanel leftPanel = new DisplayPanel(maze, player1, 75, leftWinLabel);
        DisplayPanel rightPanel = new DisplayPanel(maze, player1, 75, rightWinLabel);

        Frame frame = new Frame(leftPanel, rightPanel);
        frame.add(leftWinLabel);
        frame.add(rightWinLabel);
    }
}
