/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dance;

import javax.swing.JLabel;

/**
 *
 * @author Alexa
 */
public class ThreadDance extends Thread {

    private JLabel character;

    public ThreadDance(JLabel character) {
        this.character = character;
    }

    @Override
    public void run() {
        if (character.isVisible()) {
            character.setVisible(false);
        } else {
            character.setVisible(true);
        }
    }
}
