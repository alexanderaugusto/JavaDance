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
import javax.swing.JButton;

/**
 *
 * @author Alexa
 */
public class ThreadMusic extends Thread {

    private String music;

    public ThreadMusic(String music) {
        this.music = music;
    }

    @Override
    public void run() {
        URL song = ThreadMusic.class.getResource(music + ".wav");
        AudioClip songPlay = Applet.newAudioClip(song);

        songPlay.play();
    }
}
