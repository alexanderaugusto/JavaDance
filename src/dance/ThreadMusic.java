/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dance;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Alexa
 */
public class ThreadMusic extends Thread {

    private String music;
    private boolean fim;
    private AudioClip songPlay;

    public ThreadMusic(String music, boolean fim) {
        this.music = music;
        this.fim = fim;
    }

    @Override
    public void run() {
        
        while (fim) {
            URL song = ThreadMusic.class.getResource(music + ".wav");
            songPlay = Applet.newAudioClip(song);

            songPlay.play();

            try {
                Thread.sleep(180000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMusic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        songPlay.stop();

    }
}
