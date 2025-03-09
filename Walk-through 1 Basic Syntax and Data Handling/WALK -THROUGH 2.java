import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's even or odd: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        System.out.print("Enter a number (1-7) to get the corresponding day of the week: ");
        int dayNumber = scanner.nextInt();
        String day;
        switch (dayNumber) {
            case 1 -> day = "Monday";
            case 2 -> day = "Tuesday";
            case 3 -> day = "Wednesday";
            case 4 -> day = "Thursday";
            case 5 -> day = "Friday";
            case 6 -> day = "Saturday";
            case 7 -> day = "Sunday";
            default -> day = "Invalid input. Enter a number between 1 and 7.";
        }
        System.out.println("Day: " + day);

        int count = 10;
        while (count >= 1) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println();  

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        int guess;
        System.out.println("Guess a number between 1 and 100:");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            if (guess > randomNumber) {
                System.out.println("A bit too much! Try again.");
            } else if (guess < randomNumber) {
                System.out.println("A bit low! Try again.");
            }
        } while (guess != randomNumber);
        System.out.println("Well done! You got the right number!.");

        scanner.nextLine(); 
        String input;
        do {
            System.out.print("Enter something (type 'exit' to stop): ");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } while (!input.equalsIgnoreCase("exit"));
        scanner.close();
    }
}
