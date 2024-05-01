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
    BufferedImage bg, titleScreen;



    GameGraphics(GameLogic logic) {
        this.logic = logic;
        try {
            titleScreen = ImageIO.read(new File("src/main/resources/titleScreen.png"));
            bg = ImageIO.read(new File("src/main/resources/fieldAA.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics g) {
        g.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
        g.drawImage(bg, 0, 0, logic.winWidth, logic.winHeight, null);
        if(logic.game){
            logic.player.draw(g);
            logic.ball.draw(g);
            logic.goal.draw(g);
            logic.enemy.draw(g);


        }

        if(!logic.game){
            logic.goal.draw(g);
            g.drawString("Score: "+ logic.score, 300,100);
            g.drawImage(titleScreen,0,0,logic.winWidth, logic.winHeight, null);

        }




    }
}


