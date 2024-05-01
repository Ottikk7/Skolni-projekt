import  logic.Ball;
import logic.Enemy;
import logic.Goal;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.MessageDigest;
import java.util.Set;

public class GameLogic implements KeyListener {

    int score;
    int winWidth,winHeight;
    Player player;
    boolean isShooting = false;
    boolean game;
    Enemy enemy;
    Ball ball;
    Goal goal;

    GameLogic(int winWidth, int winHeight){

        this.winHeight = winHeight;
        this.winWidth = winWidth;
        player = new Player(400, 280);
        enemy = new Enemy(60, 150);
        ball = new Ball(20,20);
        goal = new Goal(-120,180);

        


    }

    public void update(){
        if(game){
            player.move();
            enemy.move();
            updateBall();
            checkCollision();

        }


    }





    public void checkCollision(){
        if(enemy.getRectangle().intersects(ball.getRectangle())){
            game = false;
            reset();

            System.out.println("Brankář to vychytal");

        }
    }









    public void updateBall(){

        if(isShooting){
            ball.x -= 10;
        }else {
            ball.setX(player.getX() - 10);
            ball.setY(player.getY() + 40);
        }
        if(ball.getX() == 60 && ball.getY() > 150 && ball.getY() < 405   ){
            score++;
            System.out.println(score);

        } else{
            if (ball.getX() == 0 && ball.getY() > 430 && ball.getY() < 140){
                game = false;
                reset();


            }
        }



        if(ball.getX() < -470){
            isShooting = false;

        }


    }


    public void reset(){
        isShooting = false;
        player.setY(280);
        ball.setX(player.getX() - 10);
        ball.setY(player.getY() + 40);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if(game){
            if(keys == KeyEvent.VK_SPACE){
                isShooting = true;
            }
        }

        if(!game && keys == KeyEvent.VK_SPACE){
            game = true;
            score = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
