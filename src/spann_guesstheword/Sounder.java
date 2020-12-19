/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spann_guesstheword;

/**
 *
 * @author Shanell A. Spann
 */
import javax.sound.sampled.LineUnavailableException;

public class Sounder {
    
    SoundUtils su = new SoundUtils();
    
    public void playMatchSound() throws LineUnavailableException
    {
        su.tone(450, 300);
    }
    
    public void playNoMatchSound() throws LineUnavailableException
    {
        su.tone(136, 300);
    }
    
    public void playWinnerSound() throws LineUnavailableException
    {
        su.tone(700, 300);
        su.tone(250, 300);
        su.tone(700, 300);
    }
    
    public void playLoserSound() throws LineUnavailableException
    {
        su.tone(185, 500);
        su.tone(155, 200);
        su.tone(150, 500);
    }
    
    public void playAlreadyGuessedSound() throws LineUnavailableException
    {
        su.tone(150, 500);
    }
}
