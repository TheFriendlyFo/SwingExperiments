
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    DisplayPanel lPanel, rPanel;
    /**
     * Constructor for the frame class. A frame holds two panels representing the different players'
     * perspectives and handles key commands. Only one frame is require, as it holds the entirety o the game.
     **/
    Frame(DisplayPanel lPanel, DisplayPanel rPanel) {
        setSize(1500,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        addKeyListener(this);

        this.lPanel = lPanel;
        this.rPanel = rPanel;

        lPanel.setBounds(0,0,750,1000);
        rPanel.setBounds(750,0,750,1000);

        add(rPanel, BorderLayout.WEST);
        add(lPanel, BorderLayout.WEST);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (87) -> lPanel.tryMove(0, -1, 3);
            case (83) -> lPanel.tryMove(0, 1, 0);
            case (65) -> lPanel.tryMove(-1, 0, 1);
            case (68) -> lPanel.tryMove(1, 0, 2);
            case (KeyEvent.VK_UP) -> rPanel.tryMove(0, -1, 3);
            case (KeyEvent.VK_DOWN) -> rPanel.tryMove(0, 1, 0);
            case (KeyEvent.VK_LEFT) -> rPanel.tryMove(-1, 0, 1);
            case (KeyEvent.VK_RIGHT) -> rPanel.tryMove(1, 0, 2);
        }
        if (lPanel.testSolved() || rPanel.testSolved()) {
            remove(lPanel);
            remove(rPanel);
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
