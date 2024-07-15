package logic;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Enemy extends Entity implements KeyListener {
    boolean up, down;
    public Enemy(int x, int y){
        super("brankar.png");
        this.x = x;
        this.y = y;
        speed = 1;
        width= 60;
        height= 80;
    }
    public void move(boolean secondPlayer){
        if (secondPlayer){
            if(up && y > 120){
                y -= speed;
            }
            if(down && y < 400){
                y += speed;
            }
        }
        if (!secondPlayer){
            y += speed;
            if(y < 120){
                speed *= -1;
            }
            if(y > 400){
                speed *= -1;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys= e.getKeyCode();
        if(keys == KeyEvent.VK_UP){
            up = true;
        }
        if(keys == KeyEvent.VK_DOWN){
            down=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keys= e.getKeyCode();
        if(keys == KeyEvent.VK_UP){
            up = false;
        }
        if(keys == KeyEvent.VK_DOWN){
            down=false;
        }
    }
}