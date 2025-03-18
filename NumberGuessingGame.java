import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

    public static int playRound() {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; 
        int attempts = 0;
        int maxAttempts = 10;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nI have chosen a number between 1 and 100. Try to guess it!");
        
        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
            
            if (userGuess < numberToGuess) {
                int difference = numberToGuess - userGuess;
                if (difference <= 5) {
                    System.out.println("You're very close! Try a little higher.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            } else if (userGuess > numberToGuess) {
                int difference = userGuess - numberToGuess;
                if (difference <= 5) {
                    System.out.println("You're very close! Try a little lower.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return attempts;
            }
        }
        
        System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
        return maxAttempts; 
    }
    
    public static void main(String[] args) {
        int roundsWon = 0;
        int totalAttempts = 0;
        int roundsPlayed = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed + ":");
            
            int attempts = playRound();
            
            if (attempts < 10) {
                roundsWon++;
            }
            totalAttempts += attempts;
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Average Attempts per Round: " + (totalAttempts / (double) roundsPlayed));
    }
}