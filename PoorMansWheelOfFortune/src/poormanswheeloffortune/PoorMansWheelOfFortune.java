/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poormanswheeloffortune;
import java.util.Scanner;
/**
 *
 * @author amccormick2
 */
public class PoorMansWheelOfFortune {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the variabrus
        String userInput = ""; 
        String message = "I may be drunk, Miss, but in the morning I will be sober and you will still be ugly.";
        String category = "Famous Quotes By Winston Churchill";
        String compareToChar = "";
        final String startAnswer = "$";
        
        boolean correct = false;
        
        int cp = 0, length = 0;
        
        Scanner kbdScanner = new Scanner(System.in);
        
        length = message.length(); 
        do{
            cp=0;
            System.out.print("Enter a letter(Enter $ to make a guess): ");
            userInput = kbdScanner.nextLine();
            while(cp<length){
                

                
                compareToChar = message.substring(cp,cp+1);//extract character
                
                if(compareToChar.toLowerCase().equals(userInput.toLowerCase())){
                    System.out.println("Found "+ userInput+ " at position "+ (cp+1));//Display position
                }
                
                cp++;
            }
        }while(!userInput.equals(startAnswer));    
            System.out.println("Ok, Make a guess: ");
            userInput = kbdScanner.nextLine();
            if(userInput.toLowerCase().equals(message.toLowerCase())){
                System.out.println("You win!");
            }
            else{
                System.out.println("Sorry, You Lose. It was "+ message);
                
            } 
    }
}
