import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Initialize mazes:
        MazeData maze = new MazeData(19,19);
        MazeData maze2 = new MazeData(19,19);

        // Initialize players:
        Player player1 = new Player();
        Player player2 = new Player();

        // Initialize maze solved screens:
        JLabel lWinLabel = createWinLabel(0);
        JLabel rWinLabel = createWinLabel(750);

        // Initialize maze displays:
        DisplayPanel leftPanel = new DisplayPanel(maze, player1, 75, lWinLabel);
        DisplayPanel rightPanel = new DisplayPanel(maze2, player2, 75, rWinLabel);

        // Create frame, passing the two maze displays:
        Frame frame = new Frame(leftPanel, rightPanel);

        // Add all components to frame:
        frame.add(lWinLabel);
        frame.add(rWinLabel);
        frame.add(rightPanel);
        frame.add(leftPanel);
    }

    /**
     * Generates a label to display that the player has solved their maze and the time it took.
     * @param xShift The amount the label is to be shifted. Either 0 or 750 (left or right).
     * @return Returns the generated win label.
     */
    private static JLabel createWinLabel(int xShift) {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setBounds(xShift,0,750,1000);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        return label;
    }
}
