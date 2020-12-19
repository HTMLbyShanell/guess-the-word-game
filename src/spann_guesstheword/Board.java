/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spann_guesstheword;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util. Scanner;
import javax.sound.sampled.LineUnavailableException;

public class Board 
{
    
    char holdChar;
    char[] aWord;
    char[] wordInPlayArray;
    char[] boardInPlayArray;
    
    ArrayList<Character> badGuessArray = new ArrayList();
    Random rand = new Random();
    Scanner keyboard = new Scanner(System.in);
    Sounder s = new Sounder();
    
    String [] myWordListArray = {"angel", "jesus", "blizzard", "christmas", 
    "nutcracker", "reindeer", "december", "merry", "ornament", "elf"};
    
    String thisword;
    int MAX = 10;
    int MIN = 1;
    int MAX_GUESSES = 7;
    int guessCounter = 0;
    
    
    public void gameSetup() throws IOException, LineUnavailableException, InterruptedException
    {
        Controller c = new Controller();
        thisword = myWordListArray[rand.nextInt(MAX - MIN) + 1];
        
        aWord = new char[thisword.length()];
        wordInPlayArray = new char[thisword.length()];
        boardInPlayArray = new char[thisword.length()];
        guessCounter = 0; 
        
        StringReader readstring = new StringReader(thisword);
        readstring.read(aWord, 0, thisword.length());
        
        for (int x = 0; x < aWord.length; x++)
        {
            wordInPlayArray[x] = aWord[x];
        }
        
        System.out.println("HELLO! GUESS THE FOLLOWING WORD:");
        
        for (int i = 0; i< aWord.length; i++)
        {
            System.out.print("_ ");
        }
        
        guessCounter = 0;

            do{
                getGuessFromUser();

                if(holdChar == '0')
                {
                    c.Quit();
                    return;
                }
                isGuessValid();
                displayGameBoard(); 
                displayBadGuesses();
                checkForWinner();
            }while(holdChar != '0');
            
       c.Quit();
    }
     
    public void getGuessFromUser() throws LineUnavailableException, IOException, InterruptedException
    {
        Controller c = new Controller();
        
        if(guessCounter < 7)
        {
            System.out.println("\n\nGUESS A LETTER  or  PRESS '0' TO QUIT!");
            holdChar = keyboard.next().toLowerCase().charAt(0);
            
        }
        else
        {
            s.playLoserSound();
            System.out.println("\nYOU RAN OUT OF GUESSES! YOU LOST.");
            c.playAgain();
            holdChar = '0';
        }
    }
    
    public void isGuessValid() throws LineUnavailableException
    {
        boolean bad;
        bad = badGuessArray.contains(holdChar);
        
        if(bad)
        {
            System.out.println("\t\t\t\t\t\t\t\tYOU ALREADY GUESSED " + holdChar);
            s.playAlreadyGuessedSound();
        }
        else
        {
            handleMatch();
        }
    }
    
    public void handleMatch() throws LineUnavailableException
    {
        boolean matchFound = false;
        
        for(int i = 0; i < wordInPlayArray.length; i++)
        {
            if(wordInPlayArray[i] == holdChar)
            {
                boardInPlayArray[i] = holdChar;
                matchFound = true;
                s.playMatchSound();
            }
        } 
        if (matchFound == false)
        {
            s.playNoMatchSound();
            badGuessArray.add(holdChar);
            guessCounter++;
            System.out.println("\t\t\t\t\t\t\t\tGUESSES LEFT: " + (7 - guessCounter));
        }
    }
    
    public void displayGameBoard()
    {
        for(int i = 0; i < wordInPlayArray.length; i++)
        {
            System.out.print("[" + boardInPlayArray[i] + " " + "]");
        }
        
        System.out.println();
    }
    
    public void checkForWinner() throws LineUnavailableException, InterruptedException, IOException
    {
        Controller c = new Controller();
        
        if(Arrays.equals(wordInPlayArray, boardInPlayArray))
        {
            Thread.sleep(500);
            System.out.println("\n\nYOU'RE SO SMART! YOU GUESSED THE WORD! ");
            s.playWinnerSound();
            holdChar = '0';
            c.Quit();
        }
    }
    
    public void displayBadGuesses()
    {
        System.out.print("\t\t\t\t\t\t\t\tWRONG GUESSES: ");
        
        for(char letter : badGuessArray)
        {
            System.out.print(letter + ", ");
        }
        
    }   
}
    
    

    

