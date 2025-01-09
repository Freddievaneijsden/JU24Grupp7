package quiz;

import CRUD.CelebrityCRUD;
import CRUD.LeaderboardCRUD;
import entity.Celebrity;

import java.util.Scanner;

public class CelebrityQuiz implements Quiz {
    private final CelebrityCRUD celebrityCRUD = new CelebrityCRUD();
    private int score = 0;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {
        System.out.println("Welcome to the Celebrity Quiz!");
        System.out.println("Enter your name: ");
        String quizName = scanner.nextLine();
        int celebrityQuiz = 3;
       questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        System.out.println("\nQuiz complete! Your total score: " + score + "/5");
        LeaderboardCRUD.insertOne(quizName, score, celebrityQuiz);
        Result.showResult(quizName, score);
    }

    public void questionOne() {
        System.out.println("1. Who is the famous Brazilian football player?");
        System.out.print("Your answer: ");
        String questionOneAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "ronaldo";
        Celebrity celebrity = celebrityCRUD.selectCelebrityAndReturn(questionOneAnswer);

        if (celebrity != null && celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
            System.out.println("Correct! " + correctCelebrity + " is a famous Brazilian football player.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }

    public void questionTwo() {
        System.out.println("2. Which celebrity portrayed Joel in the TV series The Last of Us?");
        System.out.print("Your answer: ");
        String questionTwoAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "pedro pascal";
        Celebrity celebrity = celebrityCRUD.selectCelebrityAndReturn(questionTwoAnswer);

        if (celebrity != null && celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
            System.out.println("Correct! " + correctCelebrity + " portrayed Joel in The Last of Us.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }

    public void questionThree() {
        System.out.println("3. Who portrayed Tina Carlyle in the movie The Mask?");
        System.out.print("Your answer: ");
        String questionThreeAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "cameron diaz";
        Celebrity celebrity = celebrityCRUD.selectCelebrityAndReturn(questionThreeAnswer);

        if (celebrity != null && celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
            System.out.println("Correct! " + correctCelebrity + " portrayed Tina Carlyle in The Mask.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }


    public void questionFour() {
        System.out.println("4. Which famous person invaded Italy?");
        System.out.print("Your answer: ");
        String questionFourAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "napoleon bonaparte";
        Celebrity celebrity = celebrityCRUD.selectCelebrityAndReturn(questionFourAnswer);

        if (celebrity != null && celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
            System.out.println("Correct! " + correctCelebrity + " invaded Italy.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }

    public void questionFive() {
        System.out.println("5. Who is known for playing John Abruzzi?");
        System.out.print("Your answer: ");
        String questionFiveAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCelebrity = "peter stormare";
        Celebrity celebrity = celebrityCRUD.selectCelebrityAndReturn(questionFiveAnswer);

        if (celebrity != null && celebrity.getCelebrityName().equalsIgnoreCase(correctCelebrity)) {
            System.out.println("Correct! " + correctCelebrity + " is known for playing John Abruzzi.");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctCelebrity + ".");
        }
    }
}
