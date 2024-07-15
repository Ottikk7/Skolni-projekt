import javax.swing.*;
import java.awt.*;
public class GameUpdate extends JPanel implements Runnable {
    GameLogic logic;
    int winWidth=800,winHeight=600;
    GameGraphics graphics;
    GameUpdate(){
        logic = new GameLogic(winWidth, winHeight);
        graphics = new GameGraphics(logic);
        setPreferredSize(new Dimension(winWidth,winHeight));
        Thread thread = new Thread(this);
        thread.start();

        addKeyListener(logic.player);
        addKeyListener(logic.enemy);
        addKeyListener(logic);
        setFocusable(true);
        requestFocus();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics.draw(g);
    }
    @Override
    public void run() {
        while (true){
            logic.update();
            repaint();

            try{
                Thread.sleep(1000/120);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}