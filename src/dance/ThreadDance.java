/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dance;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadDance extends Thread {

    private JLabel character;
    private JFrame pista;    
    private int tamanhoX;
    private int tamanhoY;

    public ThreadDance(JLabel character, JFrame pista, int tamanhoX, int tamanhoY) {
        this.character = character;
        this.pista = pista;
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;

    }

    @Override
    public void run() {

        if (character.isVisible()) {
            character.setVisible(false);
        } else {
            character.setVisible(true);

            Random r = new Random();
            int n = 0;

            while (character.isVisible()) {
                n = r.nextInt(9);

                // Mexe no eixo X
                if (character.getX() + tamanhoX < pista.getWidth() && character.getX() > 0) {

                    if (n <= 2) {
                        character.setLocation(character.getX() + n, character.getY());
                        pista.repaint();
                    } else if (n > 2 && n <= 4) {
                        character.setLocation(character.getX() - n, character.getY());
                        pista.repaint();
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadDance.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    character.setVisible(false);
                    character.setVisible(true);
                    pista.repaint();
                }

                // Mexe no eixo Y
                if (character.getY() < pista.getHeight() && character.getY() > 300) {

                    if (n > 4 && n <= 6) {
                        character.setLocation(character.getX(), character.getY() + n);
                        pista.repaint();
                    } else if (n > 6 && n <= 8) {
                        character.setLocation(character.getX(), character.getY() - n);
                        pista.repaint();
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadDance.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    character.setVisible(false);
                    character.setVisible(true);
                    pista.repaint();
                }

            }

        }

    }
}
