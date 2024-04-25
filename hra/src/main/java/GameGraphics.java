import logic.Ball;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class GameGraphics extends JPanel {
    GameLogic logic;
    BufferedImage bg;


    GameGraphics(GameLogic logic){
        this.logic = logic;
        try {
            bg= ImageIO.read(new File("src/main/resources/fieldAA.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    public void draw(Graphics g){
        g.drawImage(bg,0,0,logic.winWidth, logic.winHeight, null);
        logic.player.draw(g);
        logic.enemy.draw(g);
        logic.ball.draw(g);
        logic.goal.draw(g);

    }


    

}
