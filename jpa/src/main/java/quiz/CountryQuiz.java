package quiz;

import CRUD.CountryCRUD;
import CRUD.LeaderboardCRUD;
import entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryQuiz  {
    private final Scanner scanner = new Scanner(System.in);
    private int score = 0;
    private final List<Country> countries = CountryCRUD.returnAllCountries();

    public void play() {
        System.out.println("Welcome to the Country Quiz!");
        System.out.println("Enter your name: ");
        String quizName = scanner.nextLine();
        int countryQuiz = 1;
        questionCountry("1. What EU country has the largest population?", "Germany");
        questionCountry("2. What country’s national anthem has no official lyrics and is known in English as ‘The Royal March’?", "Spain");
        questionCountry("3. Which country is known as the Hexagon?", "France");
        questionCountry("4. What country is known as Land of a Thousand Lakes?", "Finland");
        questionCountry("5. Which African country is famous for being home to the Great Pyramid of Giza and the Sphinx?", "Egypt");
        LeaderboardCRUD.insertOne(quizName, score, countryQuiz);
        Result.showResult(quizName, score);
    }

    public void questionCountry (String quizQuestion, String correctAnswer) {
        System.out.println(quizQuestion);
        String userAnswer = scanner.nextLine().trim().toLowerCase();
        List<String> namesOfCountries = new ArrayList<>(List.of());
        for (Country country : countries) {
            namesOfCountries.add(country.getCountryName().toLowerCase());
        }
        if (namesOfCountries.contains(userAnswer) && userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct! " + correctAnswer + " has the largest population in the EU.");
                score++;
        }
        else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
        }
    }
}
