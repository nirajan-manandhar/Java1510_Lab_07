package ca.bcit.comp1510.lab7;
import java.util.Scanner;
import java.util.Random;

/**
 * Games class.
 * Executes a menu that starts mini-games.
 * @author nirajanmanandhar
 * @version 1.0
 *
 */
public class Games {
    /**
     * Declares the score variable.
     */
    private int score;

    /**
     * Declares the scan object.
     */
    private Scanner scan;
    
    /**
     * Declares the rand object.
     */
    private Random rand;
    
    /**
     * Constructs the Games method.
     */
    public Games() {
        score = 0;
        rand = new Random();
        scan = new Scanner(System.in);
    }
    
        /**
         * Prints out the play menu.  
         */
        public void play() {
            int input = 0;
            final int escape = 4;
            
            System.out.println("Welcome to the games program!");
            while (input != escape) {
                System.out.println("Make you choice (enter a number): "
                        + "\n1. See your score \n2. Guess a number "
                        + "\n3. Play Rock, Paper, Scissors \n4. Quit \n>");
                
                input = scan.nextInt();
                
                final int three = 3;
                final int four = 4;
                
                    switch (input) {
                    case 1:
                        System.out.println("Your score: " + score + "\n");
                        break;
                    case 2:
                        guessANumber();
                        break;
                    case three:
                        rockPaperScissors();
                        break;
                    case four:
                        break;
          
                    default:
                        System.out.println("Enter a valid number!\n");
                           
                    }
                
            }
                
        }
        
        /**
         * Game that guesses a number.
         */
        public void guessANumber() {
            int count = 1;
            final int max = 101;
            final int limit = 5;
            final int five = 5;
            
            int number = rand.nextInt(max);
            System.out.println("Try to guess the number I have between 0-100");
            int guess = scan.nextInt();
            
            do {
                if (guess > number) {
                    System.out.println("Your guess is too high!");
                    System.out.println("Guess again!");
                    guess = scan.nextInt();
                    count++;
                    System.out.println("Count: " + count);

                } else if (guess < number) {
                    System.out.println("Your guess is too low!");
                    System.out.println("Guess again!");
                    guess = scan.nextInt();
                    count++;
                    System.out.println("Count: " + count);
                    
                }

                    if (guess == number && count <= limit) {
                        System.out.println("You are right!");
                        System.out.println("Five points!");
                        score += five;
                    } else if (guess == number && count > limit) {
                        System.out.println("You are right!");
                    }
                    
                             
            }
            while (guess != number);
        }
        
        /**
         * Rock, paper, scissors game.
         * 
         */
        public void rockPaperScissors() {
            final int limit = 3;
            Random gen = new Random();
            
            int state = gen.nextInt(limit);
          
            // 0 - Rock
            // 1 - Paper
            // 2 - Scissors
            
            System.out.println("\nEnter your choice of either Rock, "
                    + "Paper, or Scissors.\n");
            String choice = scan.next();
            
            while (!"rock".equals(choice) 
                    && !"paper".equals(choice) && !"scissors".equals(choice)) {
                System.out.println("That's not a valid choice! Try again!\n");
                
                choice = scan.next();
            }
            
            final int deduction = 3;
            final int reward = 5;
            
            if (choice.equals("rock")) {
                
                if (state == 0) {
                    System.out.println("I chose rock too! TIE!\n");
                } else if (state == 1) {
                    System.out.println("I chose paper! You LOSE!"
                            + "\nMinus three points!");
                    score -= deduction;
                } else if (state == 2) {
                    System.out.println("I chose scissors! You WIN!"
                            + "\nPlus five points!");
                    score += reward;
                }
                
            } else if (choice.equals("paper")) {
                
                if (state == 0) {
                    System.out.println("I chose rock! You WIN!"
                            + "\nPlus five points!");
                    score += reward;
                } else if (state == 1) {
                    System.out.println("I chose paper too! TIE!\n");
                } else if (state == 2) {
                    System.out.println("I chose scissors! You LOSE!"
                            + "\nMinus three points!");
                    score -= deduction;
                }
                
            } else if (choice.equals("scissors")) {
                
                if (state == 0) {
                    System.out.println("I chose rock! You LOSE!"
                            + "\nMinus three points!");
                    score -= deduction;
                } else if (state == 1) {
                    System.out.println("I chose paper! You WIN!"
                            + "\nPlus five points!");
                    score += reward;
                } else if (state == 2) {
                    System.out.println("I chose scissors too! TIE!\n");
                }
            
            }
        }
    }
        

