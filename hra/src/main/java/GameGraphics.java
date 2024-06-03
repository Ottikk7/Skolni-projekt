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
            ruless = ImageIO.read(getClass().getResource("/Rules.png"));
            titleScreen = ImageIO.read(getClass().getResource("/mainMenu.png"));
            titles = ImageIO.read(getClass().getResource("/TITLE.png"));
            bg1 = ImageIO.read(getClass().getResource("/fieldAA.png"));
            bg2 = ImageIO.read(getClass().getResource("/fieldAA2.png"));
            bg3 = ImageIO.read(getClass().getResource("/fieldAA3.png"));
            bg4 = ImageIO.read(getClass().getResource("/fieldAA4.png"));

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
            g.drawImage(logic.player.getImage(), logic.player.getX(),logic.player.getY(),logic.player.getWidth(),logic.player.getHeight(),null);
            g.drawImage(logic.ball.getImage(), logic.ball.getX(),logic.ball.getY(),logic.ball.getWidth(),logic.ball.getHeight(),null);
            g.drawImage(logic.goal.getImage(), logic.goal.getX(),logic.goal.getY(),logic.goal.getWidth(),logic.goal.getHeight(),null);
            g.drawImage(logic.enemy.getImage(), logic.enemy.getX(),logic.enemy.getY(),logic.enemy.getWidth(),logic.enemy.getHeight(),null);


        }

        if(!logic.game){
            g.drawImage(bg1, 0, 0, logic.winWidth, logic.winHeight, null);
            g.drawString("Score: "+ logic.score, 10,30);
            g.drawImage(logic.goal.getImage(), logic.goal.getX(),logic.goal.getY(),logic.goal.getWidth(),logic.goal.getHeight(),null);
            g.drawImage(titleScreen,0,0,logic.winWidth, logic.winHeight, null);
            g.drawImage(titles,100,10, logic.winWidth - 200, logic.winHeight - 200, null);
            if(logic.rules){
                g.drawImage(ruless, 0,0,logic.winWidth, logic.winHeight, null);
            }

        }




    }
}


