import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
    Panel panel1, panel2;
    
    Frame() {
        setSize(2000,1000); // Sets the size, obviously:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program fully stop when the X button is hit, rather than just running in the background.
        setVisible(true); // Makes the frame visible:
        setLocationRelativeTo(null);
        addKeyListener(this);

        panel1 = new Panel(30, 30);
        panel2 = new Panel(30, 30);
        add(panel1);
        add(panel2);
        panel1.setBounds(0,0,1000,1040);
        panel2.setBounds(1000,0,1000,1040);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (87) :
                if (panel1.isAccessible(3)) {
                    panel1.getPlayer().incY(false);
                }
                break;
            case (83):
                if (panel1.isAccessible(0)) {
                    panel1.getPlayer().incY(true);
                }
                break;
            case (65) :
                if (panel1.isAccessible(1)) {
                    panel1.getPlayer().incX(false);
                }
                break;
            case (68) :
                if (panel1.isAccessible(2)) {
                    panel1.getPlayer().incX(true);
                }
                break;
            case (KeyEvent.VK_UP) :
                if (panel2.isAccessible(3)) {
                    panel2.getPlayer().incY(false);
                }
                break;
            case (KeyEvent.VK_DOWN) :
                if (panel2.isAccessible(0)) {
                    panel2.getPlayer().incY(true);
                }
                break;
            case (KeyEvent.VK_LEFT) :
                if (panel2.isAccessible(1)) {
                    panel2.getPlayer().incX(false);
                }
                break;
            case (KeyEvent.VK_RIGHT) :
                if (panel2.isAccessible(2)) {
                    panel2.getPlayer().incX(true);
                }
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
