/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spann_guesstheword;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Shanell A. Spann
 * ITDEV110 - ITOOP
 * Due: 11/28/2019
 * Assignment # 10
 */
public class Spann_GuessTheWord {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, LineUnavailableException, InterruptedException {
        
        Board b = new Board();
        Controller c = new Controller();
        SoundUtils su = new SoundUtils();
        
        su.tone(520, 200);
        su.tone(520, 100);
        
        b.gameSetup();
        
        su.tone(200, 50);
        su.tone(200, 30);

    }
    
}
