import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class GameGraphics extends JPanel {
    GameLogic panel;
    BufferedImage bg;


    GameGraphics(GameLogic panel){
        this.panel = panel;
        try {
            bg= ImageIO.read(new File("src/main/resources/fieldAA.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    public void draw(Graphics g){
        g.drawImage(bg,0,0,panel.winWidth, panel.winHeight, null);

    }


    

}
