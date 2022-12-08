
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    DisplayPanel lPanel, rPanel;
    /**
     * Constructor for the frame class. A frame holds two panels representing the different players'
     * perspectives and handles key commands. Only one frame is require, as it holds the entirety o the game.
     * @param lPanel The left maze displayed. Controlled with w, a, s, d, for movement, and 1 and 2 for zoom.
     * @param rPanel The right maze displayed. Controlled with the arrow keys for movement, and plus and minus for zoom.
     * */
    Frame(DisplayPanel lPanel, DisplayPanel rPanel) {
        setSize(1517,1040); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setBackground(Color.WHITE);
        setVisible(true); // Makes the frame visible:
        addKeyListener(this);

        this.lPanel = lPanel;
        this.rPanel = rPanel;

        lPanel.setBounds(0,0,750,1000);
        rPanel.setBounds(750,0,750,1000);

        add(rPanel);
        add(lPanel);
    }

    @Override
    /**
     * Controls key commands. Commands are as follows:
     * w/Up Arrow - Player moves upwards
     * a/Left Arrow - Player moves left
     * s/Down Arrow - Player moves down
     * d/Right Arrow - Player moves right
     * Space/Enter - Player interacts with win point.
     * 1/Minus - Zooms out
     * 2/Plus - Zooms in
     * Control - Randomizes mazes
     */
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case (87) -> lPanel.tryMove(0, -1, 3);
            case (83) -> lPanel.tryMove(0, 1, 0);
            case (65) -> lPanel.tryMove(-1, 0, 1);
            case (68) -> lPanel.tryMove(1, 0, 2);
            case (37) -> rPanel.tryMove(-1, 0, 1);
            case (38) -> rPanel.tryMove(0, -1, 3);
            case (39) -> rPanel.tryMove(1, 0, 2);
            case (40) -> rPanel.tryMove(0, 1, 0);
            case (32) -> lPanel.testSolved();
            case (10) -> rPanel.testSolved();
            case (45) -> rPanel.zoom(false);
            case (61) -> rPanel.zoom(true);
            case (50) -> lPanel.zoom(false);
            case (49) -> lPanel.zoom(true);
            case (17) -> {
                lPanel.getMazeData().generateMaze();
                rPanel.getMazeData().generateMaze();
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
