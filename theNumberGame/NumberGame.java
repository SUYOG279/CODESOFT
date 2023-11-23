package theNumberGame;
	import java.util.Random;
	import java.util.Scanner;

	public class NumberGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = 10;
	        int rounds = 0;
	        int totalScore = 0;

	        boolean playAgain = true;

	        while (playAgain) {
	            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            System.out.println("Round " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);

	            int attempts = 0;
	            boolean guessedCorrectly = false;

	            while (attempts < maxAttempts && !guessedCorrectly) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();
	                attempts++;

	                if (userGuess == targetNumber) {
	                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                    totalScore += maxAttempts - attempts + 1;
	                    guessedCorrectly = true;
	                } else if (userGuess < targetNumber) {
	                    System.out.println("Too low! Try again.");
	                } else {
	                    System.out.println("Too high! Try again.");
	                }
	            }

	            if (!guessedCorrectly) {
	                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
	            }

	            rounds++;

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgainResponse = scanner.next().toLowerCase();
	            playAgain = playAgainResponse.equals("yes");

	            // Clear the newline character from the input buffer
	            scanner.nextLine();
	        }

	        System.out.println("Game Over! Your total score is: " + totalScore);
	        scanner.close();
	    }
	}




