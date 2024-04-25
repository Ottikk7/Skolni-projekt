package logic;

public class Ball extends Entity {
    int speed = 3;
    public Ball (int x, int y){
        super("Ball.jpg");
        this.x = x;
        this.y = y;
        width = 30;
        height = 30;


    }
}
