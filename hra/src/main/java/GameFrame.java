import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame {
    GameUpdate panel;

    public static void   main(String[] args) {
        new GameFrame();
    }

    GameFrame(){
        panel = new GameUpdate();
        add(panel);
        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        setTitle("Beat the KEEPER");
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(new File("src/main/resources/ovladac game.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
