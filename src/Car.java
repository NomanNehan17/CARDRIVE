import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

                                          //C211017
public class Car {
    Image carImage;
    Image carStopImage;
    Image carRunningRight;
    ImageIcon carImageIcon;
    //Clip player = null;
    int x;
    int y;
    Clip player1;
    Clip player2;
    AudioInputStream carRunningSound;
    AudioInputStream fireSound;
    List bullets;
    //Clip player;
    Car () throws Exception
    {
        carImageIcon = new ImageIcon( "car.png");
        carStopImage = carImageIcon.getImage();

        carImageIcon = new ImageIcon( "carRunningRight.gif");
        carRunningRight = carImageIcon.getImage();


        carImage = carStopImage;
        x= 120;
        y= 450;
        carRunningSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav"));
        player1 = AudioSystem.getClip();
        fireSound = AudioSystem.getAudioInputStream(new File("fire_sound.wav"));
        player2 = AudioSystem.getClip();
        bullets = new ArrayList();

    }

    void move (KeyEvent e) throws Exception {
        if (e.getKeyCode() == 39)
            x = x + 5;
        if (e.getKeyCode() == 37)
            x = x - 5;

        if (e.getKeyCode() == 40)
            y = y + 5;
        if (e.getKeyCode() == 38)
            y = y - 5;

        carImage = carRunningRight;

        if (player1.isOpen() == false) player1.open(carRunningSound);
        player1.loop(Clip.LOOP_CONTINUOUSLY);

        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if (player2.isOpen() == false) player2.open(fireSound);

            player2.start();
            rightFire();
            ////Sound Add
            //carRunningSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav").getAbsoluteFile());
            //player = AudioSystem.getClip();
            //Clip player = AudioSystem.getClip();
            //player.open(carRunningSound);
            //player.start();
        }
    }
        void stop ()
        {
        carImage = carStopImage;
            // player.stop ();
            // player.setFramePosition(0);
            //Clip player1;
            player1.stop();
            player1.setFramePosition(0);
            player2.stop();
            player2.setFramePosition(0);

        }
        public void rightFire()
        {
            Bullet bullet = new Bullet(x, 450);
            bullets.add(bullet);
        }
        public void leftFire ()
        {
            Bullet  bullet = new Bullet(310, 450);
            bullets.add(String.valueOf(bullet));
        }

}