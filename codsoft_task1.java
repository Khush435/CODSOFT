import java.util.Scanner;
import java.util.Random;

class Game 
{
    private int number,inputNumber,noOfGuesses;
    private final int maxAttempts = 7; // Limit number of attempts to 7
    private final int lowerBound = 1;
    private final int upperBound = 100;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    public void startNewRound() 
    {
        this.number = rand.nextInt(100);
        noOfGuesses = 0;
        System.out.println("\nNew Round Started! Guess a number between " + lowerBound + " and " + upperBound + ".");
    }
    public boolean takeUserInput() 
    {
        if (noOfGuesses >= maxAttempts) 
        {
            System.out.println("You've used all your attempts! The correct number was: " + number);
            return true;
        }
        System.out.print("Enter your guess (" + (maxAttempts - noOfGuesses) + " attempts left): ");
        inputNumber = sc.nextInt();
        noOfGuesses++;
        if (inputNumber == number) 
        {
            System.out.printf("Correct! You guessed the number %d in %d attempts.%n", number, noOfGuesses);
            return true;
        } 
        else if (inputNumber < number) 
            System.out.println("Too low...");
        else
            System.out.println("Too high...");

      return false;
    }
    public boolean isWin() {
        return inputNumber == number;
    }
    public int getMaxAttempts() {
        return maxAttempts;
    }
    public int getNoOfGuesses() {
        return noOfGuesses;
    }
}

public class codsoft_task1
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int totalRounds = 0, roundsWon = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        while (playAgain) 
        {
            game.startNewRound();

            boolean roundOver = false;
            while (!roundOver)
                roundOver = game.takeUserInput();

            totalRounds++;
            if (game.isWin())
                roundsWon++;

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = sc.next();
            playAgain = response.equals("yes");
        }

        double scorePercentage = totalRounds > 0 ? ((double) roundsWon / totalRounds) * 100 : 0;
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Score: "+ scorePercentage);
        System.out.println("Thanks for playing!");
    }
}

