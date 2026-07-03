import java.awt.Graphics;

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

}