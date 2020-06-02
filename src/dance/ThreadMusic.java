package dance;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ThreadMusic extends Thread {

    private String audioName;
    private String audioPath;

    private Clip clip;

    public ThreadMusic(String audioName, String audioPath) {
        this.audioName = audioName;
        this.audioPath = audioPath;
    }

    public void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    @Override
    public void run() {
        AudioInputStream inputStream = null;

        try {
            inputStream = AudioSystem.getAudioInputStream(new File(audioPath));

            clip = AudioSystem.getClip();
            clip.open(inputStream);

            clip.start();
            Thread.sleep(10000);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException ex) {
            System.out.println("Error when playing an audio... " + ex.getMessage());
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                System.out.println("Error when closing an audio... " + ex.getMessage());
            }
        }
    }
}
