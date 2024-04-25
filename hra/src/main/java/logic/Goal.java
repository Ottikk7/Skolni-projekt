package logic;

import java.awt.*;

public class Goal extends  Entity{
    public Goal(int x, int y){
        super("brankaa.png");
        this.x = x;
        this.y = y;
        width= 60;
        height= 75;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x,y,200,250,null);

    }
}
