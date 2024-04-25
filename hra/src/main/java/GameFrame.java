import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame {
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        add(panel);
        pack();
        setResizable(false);

        setVisible(true);
        setTitle("Beat the keeper");
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(new File("src/main/resources/ovladac game.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
