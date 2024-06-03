package logic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Enemy extends Entity {
    public Enemy(int x, int y){
        super("brankar.png");
        this.x = x;
        this.y = y;
        speed = 1;
        width= 60;
        height= 80;



    }


    public void move(){
        y += speed;
        if(y < 120){
            speed *= -1;
        }
        if(y > 400){
            speed *= -1;
        }
    }





}

