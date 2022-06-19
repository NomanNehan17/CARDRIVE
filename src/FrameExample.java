import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class FrameExample {
    public static void main (String []args) throws Exception
    {
        Board b = new Board();

                                                  //C211017
        JFrame f = new JFrame();
        f.setSize(1024, 550);
        f.add(b);
        f.setVisible(true);
        AudioInputStream a = AudioSystem.getAudioInputStream(new File("backgroundSound.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(a);
        clip.loop(-1);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}