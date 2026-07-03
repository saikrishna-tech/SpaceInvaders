import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {

        setTitle("Space Invaders");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        add(new GamePanel());

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

}