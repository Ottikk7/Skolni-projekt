package logic;

import java.awt.*;

public class Ball extends Entity {
    int speed = 3;
    public Ball(int x, int y){
        super("Balll.png");
        this.x = x;
        this.y = y;
        width = 30;
        height = 30;
    }
    public void draw(Graphics g){
        g.drawImage(image, x,y,45,45,null);
    }

}
