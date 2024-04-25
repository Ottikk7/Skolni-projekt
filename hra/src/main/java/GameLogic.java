import logic.Enemy;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameLogic extends JPanel implements Runnable {
    int winWidth=800,winHeight=600;
    GameGraphics graphics;
    Player player;
    Enemy enemy;
    GameLogic(){
        player = new Player(400, 300);
        enemy = new Enemy(60, 150);
        setPreferredSize(new Dimension(winWidth,winHeight));
        graphics = new GameGraphics(this);
        Thread thread = new Thread(this);
        thread.start();
        addKeyListener(player);
        setFocusable(true);
        requestFocus();




    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        graphics.draw(g);
        player.draw(g);
        enemy.draw(g);

    }

    @Override
    public void run() {
        while (true){
            update();
            repaint();

            try{
                Thread.sleep(1000/120);
            } catch (InterruptedException e){
                e.printStackTrace();

            }
        }

    }

    public void update(){
        player.move();
        enemy.move();
    }
}
