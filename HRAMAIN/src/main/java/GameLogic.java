import  logic.Ball;
import logic.Enemy;
import logic.Goal;
import logic.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GameLogic implements KeyListener {
    int score;
    int winWidth,winHeight;
    Player player;
    boolean isShooting = false;
    boolean game;
    int gameLevel;
    Enemy enemy;
    Ball ball;
    boolean rules;
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
            updatePlayer();
            updateEnemy();
            checkCollision();
        }
    }
    public void checkCollision(){
        if(enemy.getRectangle().intersects(ball.getRectangle())){
            game = false;
            System.out.println("Brankář to vychytal");
        }
    }
    public void updateEnemy(){
        if(score == 5){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-2);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(2);
            }
            gameLevel = 2;
        }
        if(score == 10){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-3);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(3);
            }
            gameLevel = 3;

        }
        if(score == 15){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-4);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(4);
            }
            gameLevel = 4;
        }
        if(score == 20){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 5;
        }
        if(score == 25){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 6;
        }
        if(score == 30){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 7;
        }
        if(score == 35){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 8;
        }
        if(score == 35){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 8;
        }
        if(score == 40){
            if(enemy.getSpeed() <= -1){
                enemy.setSpeed(-5);
            }
            if(enemy.getSpeed() >= 1){
                enemy.setSpeed(5);
            }
            gameLevel = 9;
        }
        if(score == 45){
            game = false;
            reset();
        }
    }
    public void updatePlayer(){
        if(player.getY()<0){
            player.setY(0);
        }
        if(player.getY()>winHeight - player.getHeight()){
            player.setY(winHeight - player.getHeight());
        }
    }
    public void updateBall(){
        if(isShooting){
            ball.x -= 10;
        }else {
            ball.setX(player.getX() - 10);
            ball.setY(player.getY() + 40);
        }
        if(ball.getX() == 60 && ball.getY() > 170 && ball.getY() < 405){
            score++;

        } else if(ball.getX() == 0 && ball.getY() > 405){
                game = false;
        } else if(ball.getX() == 0 && ball.getY() < 150){
            game = false;
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
        enemy.setSpeed(1);
        gameLevel = 1;
        score = 0;
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
            reset();
        }
        if(!game && !rules && keys == KeyEvent.VK_R){
            rules = true;
        }else if(!game && rules && keys == KeyEvent.VK_R){
            rules = false;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}