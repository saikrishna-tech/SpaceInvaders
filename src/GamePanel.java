import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel implements java.awt.event.KeyListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Player player;
    private Alien[] aliens;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        for (Alien alien : aliens) {
            alien.draw(g);
        }

    }

    public GamePanel() {

        setFocusable(true);
        requestFocus();
        addKeyListener(this);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.BLACK);

        
        player = new Player(
                WIDTH / 2 - Player.WIDTH / 2,
                HEIGHT - 50
        );

        aliens = new Alien[15];

        int index = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                aliens[index++] = new Alien(
                        100 + col * 100,
                        50 + row * 60
                );
            }
        }

    }


    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
            player.moveLeft();
        }

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
            player.moveRight();
        }

        repaint();
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

}