package game;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entities.Player;
import entities.Alien;
import entities.Bullet;

public class GamePanel extends JPanel implements java.awt.event.KeyListener, ActionListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Player player;
    private Alien[] aliens;
    private Timer timer;
    private Bullet bullet;
    private int score = 0;
    private int alienDirection = 1;
    private static final int ALIEN_SPEED = 2;
    private boolean gameOver = false;
    private boolean gameWon = false;


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);

        if (bullet != null) {
            bullet.draw(g);
        }

        for (Alien alien : aliens) {
            if (alien != null) {
                alien.draw(g);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 20);

        if (gameOver) {
            g.drawString("GAME OVER", WIDTH / 2 - 40, HEIGHT / 2);
        }

        if (gameWon) {
            g.drawString("YOU WIN!", WIDTH / 2 - 30, HEIGHT / 2);
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

        timer = new Timer(16, this);
        timer.start();

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

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
            if (bullet == null) {
                bullet = new Bullet(
                        player.getX() + Player.WIDTH / 2 - Bullet.WIDTH / 2,
                        player.getY()
                );
            }
        }

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver || gameWon) {
            repaint();
            return;
        }
        moveAliens();
        if (bullet != null) {
            bullet.move();

            for (int i = 0; i < aliens.length; i++) {
                if (aliens[i] != null &&
                    bullet.getBounds().intersects(aliens[i].getBounds())) {

                    aliens[i] = null;
                    bullet = null;
                    score += 10;
                    boolean anyAliensLeft = false;
                    for (Alien alien : aliens) {
                        if (alien != null) {
                            anyAliensLeft = true;
                            break;
                        }
                    }
                    if (!anyAliensLeft) {
                        gameWon = true;
                    }
                    break;
                }
            }

            if (bullet != null && bullet.isOffScreen()) {
                bullet = null;
            }
        }
        repaint();

    }


    private void moveAliens() {
        boolean changeDirection = false;
        for (Alien alien : aliens) {
            if (alien == null)
                continue;
            if (alienDirection == 1 &&
                alien.getRight() >= WIDTH) {
                changeDirection = true;
            }
            if (alienDirection == -1 &&
                alien.getX() <= 0) {
                changeDirection = true;
            }
        }
        if (changeDirection) {
            alienDirection *= -1;
            for (Alien alien : aliens) {
                if (alien != null) {
                    alien.move(0, 20);
                }
            }
        } else {
            for (Alien alien : aliens) {
                if (alien != null) {
                    alien.move(ALIEN_SPEED * alienDirection, 0);
                }
            }
        }
        for (Alien alien : aliens) {
            if (alien != null &&
                alien.getY() + Alien.HEIGHT >= player.getY()) {
                gameOver = true;
            }
        }
    }

}