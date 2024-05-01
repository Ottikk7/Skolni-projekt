package logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Entity extends Coordinates  {
    BufferedImage image;
    public Entity(String file){
        try {
            image = ImageIO.read(new File("src/main/resources/" + file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

}
