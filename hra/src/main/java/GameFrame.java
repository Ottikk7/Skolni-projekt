import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame {
    GameLogic panel;
    GameFrame(){
        panel = new GameLogic();
        add(panel);
        pack();
        setResizable(false);

        setVisible(true);
        setTitle("Score zero");
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(new File("src/main/resources/ovladac game.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
