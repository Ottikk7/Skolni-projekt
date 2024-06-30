package logic;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Entity extends Attributes  {
    BufferedImage image;
    int speed;
    public Entity(String file){
        try {
            image = ImageIO.read(getClass().getResource("/" + file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getImage() {
        return image;
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
