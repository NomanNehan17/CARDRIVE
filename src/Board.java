import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel {

    Image background;
    Car car  = new Car ();
    Board() throws Exception
    {
        ImageIcon imageIcon = new ImageIcon("background.png");
        background = imageIcon.getImage();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    car.move(e);
                }
               catch (Exception exception)
               {
                   exception.printStackTrace();
               }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
             car.stop();
                //car.carImage = car.carStopImage;
            }
        });
        setFocusable (true);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(background,  0, 0, this);
        g.drawImage(car.carImage, car.x , car.y, this);
        repaint();
    }
}