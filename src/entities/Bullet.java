package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

    private int x;
    private int y;

    public static final int WIDTH = 4;
    public static final int HEIGHT = 15;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        y -= 8;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public boolean isOffScreen() {
        return y + HEIGHT < 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}