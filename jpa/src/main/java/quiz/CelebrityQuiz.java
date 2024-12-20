package quiz;

import CRUD.CelebrityCRUD;
import entity.Celebrity;

import java.util.Scanner;

public class CelebrityQuiz implements Quiz {
    private final CelebrityCRUD celebrityCRUD = new CelebrityCRUD();
    private int score = 0;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {
        System.out.println("Welcome to the Celebrity Quiz!");
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        System.out.println("\nQuiz complete! Your total score: " + score + "/5");
    }

    @Override
    public void questionOne() {
        System.out.println("1. Which country is Ronaldo from?");
        System.out.print("Your answer: ");
        String questionOneAnswer = scanner.nextLine().trim().toLowerCase(); // Användarens svar

        String correctCountry = "portugal"; // Det förväntade korrekta svaret

        // Kontrollera om svaret matchar direkt utan att bero på databasen
        if (questionOneAnswer.equals(correctCountry)) {
            System.out.println("Correct! Ronaldo is from " + correctCountry + ".");
            score++; // Öka poängen om svaret är korrekt
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
        }
    }

    @Override
    public void questionTwo() {
        System.out.println("2. Which celebrity portrayed Joel in the TV series The Last of Us?");
        System.out.print("Your answer: ");
        String questionTwoAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "pedro pascal";
        Celebrity celebrity = CelebrityCRUD.selectCelebrityAndReturn(questionTwoAnswer);

        if (celebrity != null) {
            if (celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
                System.out.println("Correct! " + celebrity.getCelebrityName() + " portrayed Joel in The Last of Us.");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
            }
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }

    @Override
    public void questionThree() {
        System.out.println("3. Which movie is Cameron Diaz most known for?");
        System.out.print("Your answer: ");
        String questionThreeAnswer = scanner.nextLine().trim().toLowerCase();

        String correctMovie = "the mask";

        if (questionThreeAnswer.equals(correctMovie)) {
            System.out.println("Correct! Cameron Diaz is most known for " + correctMovie + ".");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctMovie + ".");
        }
    }

    @Override
    public void questionFour() {
        System.out.println("4. Which country did Napoleon invade first?");
        System.out.print("Your answer: ");
        String questionFourAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "italy";
        // Eftersom 'invadedCountries' inte finns i Celebrity-entiteten, jämför direkt
        if (questionFourAnswer.equals(correctCountry)) {
            System.out.println("Correct! Napoleon's first country he invaded was " + correctCountry + ".");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
        }
    }

    @Override
    public void questionFive() {
        System.out.println("5. Who is John Stormare's most iconic character?");
        System.out.print("Your answer: ");
        String questionFiveAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCharacter = "john abruzzi";

        if (questionFiveAnswer.equals(correctCharacter)) {
            System.out.println("Correct! John Stormare's most iconic character is " + correctCharacter + ".");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCharacter + ".");
        }
    }
}
