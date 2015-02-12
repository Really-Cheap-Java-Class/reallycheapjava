/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guessanumber2_0;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author amccormick2
 */
public class GuessANumber2_0 {

        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create variables
        Scanner kbdScanner = new Scanner(System.in);//create scanner
        
        Random rng = new Random();//create a random number generator
        
        int correctNumber = 0, userGuess = 0;//various variables
        int maxNumber = 0, minNumber = 0, backdoorCode = -999;//couple of constants
        int numberOfGuesses = 0;//counter
        int difficultyLevel = 0;//difficultyLevel
        int nightmareMinRandomMin = 1, nightmareMaxRandomMin = 500000, nightmareMaxRandomMax = 1000000, nightmareMinRandomMax = 500001;
        
        String tryAgainString = "";//try again?
        
        
        boolean isCorrect = false, isValidInput = false, tryAgain = false;
        
        System.out.println("Guess a Number(Console)\n\n");
        

          do{ 
            System.out.print("Please enter a difficulty level\nEnter 1 For Beginner which is numbers 1-10\n"
                + "Enter 2 for normal which is numbers 1-100\n"
                + "Enter 3 for expert which is numbers 1-1000\n"
                + "Enter 4 for Nightmare which randomly starts between 1 and a 500,000"
                    + " and may contain up to a million numbers: ");

             
             difficultyLevel = kbdScanner.nextInt();
                  
             if(difficultyLevel == 1){//beginner mode
                 maxNumber = 10;
                 minNumber = 1;
             }
             else if(difficultyLevel == 2){//intermediate
                 maxNumber = 100;
                 minNumber = 1;
             }
             else if(difficultyLevel == 3){//expert
                 minNumber = 1;
                 maxNumber = 1000;
             }
             else if(difficultyLevel == 4){
                 System.out.println("\n\nPlease note nightmare mode is a work in progress.\n"
                         + "More features will be added as time goes on.");
                 minNumber = rng.nextInt(nightmareMinRandomMax)+nightmareMinRandomMin;//generates random number between constants
                 maxNumber = rng.nextInt(nightmareMaxRandomMax)+nightmareMaxRandomMin;//does same, adds difficulty. working on obfuscation
             }
            correctNumber = rng.nextInt(maxNumber)+minNumber;
            System.out.println("\n\nI'm thinking of a number between "+ minNumber+ " and "+ maxNumber
                    +"\nCan you guess what it is?");
            //generate random number
            do{ 
 
                do{
                     System.out.print("Enter a number between "+ minNumber+" & "+ maxNumber+ ": ");
                     userGuess = kbdScanner.nextInt();
                
                     if (userGuess >= minNumber && userGuess <= maxNumber){
                         isValidInput = true;
                     }
                     else if (userGuess == backdoorCode){
                         System.out.println("Cheater! The secret number is "+ correctNumber);
                         isValidInput = false;
                     }
                     else{
                         System.out.println("Pay Attention! Between "+ minNumber+ " and "+ maxNumber);
                         isValidInput = false;
                     }
                 }while(!isValidInput);
            
                 numberOfGuesses++;
            
                if(userGuess == correctNumber){
                   isCorrect = true;
                   System.out.println("\nIt took you "+ numberOfGuesses + " tries to get it right.\nThanks"
                   + " for playing");
                }
                else if(userGuess > correctNumber){
                    System.out.println("Too High! Try Again!");
                }
                else{
                  System.out.println("Too Low! Try Again!");
                }
            
        }while(!isCorrect);
            System.out.print("Would you like to try again? Enter Y for yes, N for no: ");
            
            tryAgainString = kbdScanner.next();
             
            if(tryAgainString.toLowerCase().equals("y")){//check if they say yes
                 tryAgain = true;
             }
            else{
                 tryAgain = false;
             }
       }while(tryAgain);
    }
}
