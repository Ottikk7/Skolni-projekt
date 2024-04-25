import logic.Ball;
import logic.Enemy;
import logic.Goal;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLogic implements KeyListener {
    int score;
    int winWidth,winHeight;
    Player player;
    boolean isShooting = false;
    Enemy enemy;
    Ball ball;
    Goal goal;
    GameLogic(int winWidth, int winHeight){
        this.winHeight = winHeight;
        this.winWidth = winWidth;
        player = new Player(400, 280);
        enemy = new Enemy(60, 150);
        ball = new Ball(20,20);
        goal = new Goal(-120,200);
        goal = new Goal(-120,180);
    }

    public void update(){
        player.move();
        enemy.move();
        updateBall();
        uptadeGoal();
    }

    private void uptadeGoal() {
        

    }

    public void updateBall(){
        if(isShooting){
            ball.x -= 10;
        }else {
            ball.setX(player.getX() - 10);
            ball.setY(player.getY() + 40);
        }
        if(ball.getX() == 0){
            score++;
            System.out.println(score);

        }

        if(ball.getX() < -470){
            isShooting = false;

        }





    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if(keys == KeyEvent.VK_SPACE){
            isShooting = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
