import logic.Ball;
import logic.Goal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class GameGraphics extends JPanel {
    GameLogic logic;
    BufferedImage bg1,bg2,bg3,bg4, titles, titleScreen, ruless;



    GameGraphics(GameLogic logic) {
        this.logic = logic;
        try {
            ruless = ImageIO.read(new File("src/main/resources/Rules.png"));
            titleScreen = ImageIO.read(new File("src/main/resources/mainMenu.png"));
            titles = ImageIO.read(new File("src/main/resources/TITLE.png"));
            bg1 = ImageIO.read(new File("src/main/resources/fieldAA.png"));
            bg2 = ImageIO.read(new File("src/main/resources/fieldAA2.png"));
            bg3 = ImageIO.read(new File("src/main/resources/fieldAA3.png"));
            bg4 = ImageIO.read(new File("src/main/resources/fieldAA4.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics g) {
        g.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));

        if(logic.game){
            if(logic.gameLevel == 1){
                g.drawImage(bg1, 0, 0, logic.winWidth, logic.winHeight, null);
            }else if(logic.gameLevel == 2){
                g.drawImage(bg2, 0, 0, logic.winWidth, logic.winHeight, null);
            }else if(logic.gameLevel == 3){
                g.drawImage(bg3, 0, 0, logic.winWidth, logic.winHeight, null);
            }else if(logic.gameLevel == 4){
                g.drawImage(bg4  , 0, 0, logic.winWidth, logic.winHeight, null);
            }
            g.drawString("Score: "+ logic.score, 10,30);
            logic.player.draw(g);
            logic.ball.draw(g);
            logic.goal.draw(g);
            logic.enemy.draw(g);


        }

        if(!logic.game){
            g.drawImage(bg1, 0, 0, logic.winWidth, logic.winHeight, null);
            g.drawString("Score: "+ logic.score, 10,30);
            logic.goal.draw(g);
            g.drawImage(titleScreen,0,0,logic.winWidth, logic.winHeight, null);
            g.drawImage(titles,100,10, logic.winWidth - 200, logic.winHeight - 200, null);
            if(logic.rules){
                g.drawImage(ruless, 0,0,logic.winWidth, logic.winHeight, null);
            }

        }




    }
}


