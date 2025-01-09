package quiz;

import CRUD.CountryCRUD;
import CRUD.LeaderboardCRUD;
import entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountryQuiz  {
    private final Scanner scanner = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "Welcome to the Country Quiz!";
    private int score = 0;
    private final List<Country> countries = CountryCRUD.returnAllCountries();
    private final List<String> namesOfCountries = countries.stream()
            .map(country -> country.getCountryName().toLowerCase())
            .toList();
    private final Map<String, String> questionsAndAnswers = Map.of(
            "What EU country has the largest population?", "Germany",
            "What country’s national anthem has no official lyrics and is known in English as ‘The Royal March’?", "Spain",
            "Which country is known as the Hexagon?", "France",
            "What country is known as Land of a Thousand Lakes?", "Finland",
            "Which African country is famous for being home to the Great Pyramid of Giza and the Sphinx?", "Egypt"
    );

    public void play() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Enter your name: ");
        String quizName = scanner.nextLine();
        int countryQuiz = 1;
        askQuestions();
        LeaderboardCRUD.insertOne(quizName, score, countryQuiz);
        Result.showResult(quizName, score);
    }

    private void askQuestions() {
        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            questionCountry(entry.getKey(), entry.getValue());
        }
    }

    public void questionCountry (String quizQuestion, String correctAnswer) {
        System.out.println(quizQuestion);
        String userAnswer = scanner.nextLine().trim().toLowerCase();
        if (namesOfCountries.contains(userAnswer) && userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println(correctAnswer +  " is correct!");
                score++;
        }
        else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
        }
    }
}
