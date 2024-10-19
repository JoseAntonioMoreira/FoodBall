import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Media {

   /* public static void playLoopSound() {
       while (true){
           try {
               FileInputStream fileInputStream = new FileInputStream("rsc/background.mp3");
               new Player(fileInputStream).play();

           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
    }

    public static void playSound() {
        try {
            // Get the audio input stream from the file
            File soundFile = new File("rsc/goal.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource
            Clip clip = AudioSystem.getClip();

            // Open the audio input stream with the clip
            clip.open(audioInputStream);

            // Start playing the sound
            clip.start();

            // Optional: wait for the sound to finish playing
            clip.drain();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

    public static void playLoopSound() {
        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream("rsc/background.mp3");
                Player player = new Player(fileInputStream);
                player.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();  // Start the thread for this sound
    }

    public static void playSound() {
        new Thread(() -> {
            try {
                File soundFile = new File("rsc/goal.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                Thread.sleep(2000);
                clip.close();
                System.out.println("testss");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();  // Start the thread for this sound
    }
}