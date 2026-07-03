package entities;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Alien {

    private int x;
    private int y;

    public static final int WIDTH = 40;
    public static final int HEIGHT = 30;

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
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

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getRight() {
        return x + WIDTH;
    }

    



}