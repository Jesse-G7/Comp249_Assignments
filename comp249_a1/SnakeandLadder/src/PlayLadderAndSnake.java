/**
 * Name(s) and ID(s): Tian Gao 40110068, Yitong Zhang 40066756
 * COMP249
 * Assignment # 1
 * Due Date: Feb 8th
 */

//-----------------------------
//Assignment#1
//Question part2
//Written by: Tian Gao 40110068, Yitong Zhang 40066756
//-----------------------------

import java.util.Scanner;
/**
 * driver class
 * ask the user to input the numbers and names of the players
 * @author Tian Gao and Yitong Zhang
 */
public class PlayLadderAndSnake {

    public static void main(String[] args) {

        //welcome message
        System.out.println("\n**********************************************");
        System.out.println("Welcome to Tian Gao and Yitong Zhang's program");
        System.out.println("**********************************************\n");


        Scanner keyIn = new Scanner(System.in);
        final int maxAttempts = 4;
        System.out.println("Enter the # of players for your game – Number must be between 2 " +
                "and 4 inclusively: ");
        int playerTotal = keyIn.nextInt();
        int attempts = 1;

        //count attempts, reach 4 quit.
        while(playerTotal < 2 || playerTotal > 4){
            System.out.println("Bad Attempt " + attempts + " - Invalid # of players. Please enter a # between 2 and " +
                    "4 inclusively:");
            playerTotal = keyIn.nextInt();
            attempts++;
            if(attempts == maxAttempts){
                System.out.println("Bad Attempt " + maxAttempts + "! You have exhausted all your chances. Program will " +
                        "terminate! ");
                System.exit(0);
            }
        }

        System.out.println("Enter the first name of each player by order and separate by space: ");
        keyIn.nextLine();  // remove new line
        String playerNames = keyIn.nextLine();




        LadderAndSnake game1 = new LadderAndSnake(playerTotal,playerNames);
        game1.play();
        keyIn.close();


    }


}
