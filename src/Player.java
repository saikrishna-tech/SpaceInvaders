public class Player {

    private int x;
    private int y;

    public static final int WIDTH = 60;
    public static final int HEIGHT = 20;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(java.awt.Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}