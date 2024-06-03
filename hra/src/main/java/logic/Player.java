package logic;

import javax.management.remote.SubjectDelegationPermission;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
    boolean up, down;

    public Player(int x, int y){
        super("ronaldo pixel.png");
        speed = 4;
        this.x = x;
        this.y = y;
        width= 60;
        height= 75;





    }



    public void move(){
        if(up){
            y -= speed;
        }
        if (down){
            y+= speed;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            int keys= e.getKeyCode();
            if(keys == KeyEvent.VK_W){
                up = true;

            }
            if(keys == KeyEvent.VK_S){
                down=true;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keys= e.getKeyCode();
        if(keys == KeyEvent.VK_W){
            up = false;

        }
        if(keys == KeyEvent.VK_S){
            down=false;
        }
    }
}
