/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spann_guesstheword;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

/**
 *
 * @author Shanell A. Spann
 */
public class Controller 
{
    char holdChar;
    Board b = new Board();
    Scanner keyboard = new Scanner(System.in);
    char playAgain;
    
    
             
   public void Quit() throws IOException, LineUnavailableException, InterruptedException
   {
       System.out.println("Thanks for playing! Goodbye.");
       System.out.close();

   }
   
   public void playAgain() throws IOException, LineUnavailableException, InterruptedException
   {
       System.out.println("Would you like to play again? Y or N");
       playAgain = keyboard.nextLine().toUpperCase().charAt(0);
       
       if (playAgain == 'Y')
       {
           System.out.println("\n\n");
           Thread.sleep(500);
           b.gameSetup();
       }
   }
    
}
