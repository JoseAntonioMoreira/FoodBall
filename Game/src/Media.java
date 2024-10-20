import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Media {
    public static void playLoopSound() {
        new Thread(() -> {
            try {
                // Use the class loader to get the resource stream in a static context
                InputStream inputStream = Media.class.getClassLoader().getResourceAsStream("rsc/background.mp3");

                if (inputStream == null) {
                    throw new RuntimeException("Sound file not found ");
                }

                // Wrap the input stream in a BufferedInputStream to support mark/reset
                new BufferedInputStream(inputStream);
                Player player = new Player(inputStream);
                player.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();  // Start the thread for this sound
    }

    public static void playSound() {
        new Thread(() -> {
            try {
                // Use the class loader to get the resource stream in a static context
                InputStream inputStream = Media.class.getClassLoader().getResourceAsStream("rsc/goal.wav");

                if (inputStream == null) {
                    throw new RuntimeException("Sound file not found ");
                }

                // Wrap the input stream in a BufferedInputStream to support mark/reset
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                // Get the audio input stream
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);


                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                Thread.sleep(2000);
                clip.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();  // Start the thread for this sound
    }
}