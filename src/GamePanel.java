import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Player player;

    @Override
    protected void paintComponent(java.awt.Graphics g) {

        super.paintComponent(g);

        player.draw(g);

    }

    public GamePanel() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.BLACK);

        
        player = new Player(
                WIDTH / 2 - Player.WIDTH / 2,
                HEIGHT - 50
        );

    }

}