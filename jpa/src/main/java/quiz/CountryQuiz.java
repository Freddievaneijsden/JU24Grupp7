package quiz;

import CRUD.CountryCRUD;
import entity.Country;

import java.util.Scanner;

public class CountryQuiz implements Quiz {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
    }

    @Override
    public void questionOne() {
        System.out.println("1. What EU country has the largest population?");
        String questionOneAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "germany";

        Country country = CountryCRUD.selectCountryAndReturn(questionOneAnswer);

        if (country != null) {
            if (country.getCountryName().equalsIgnoreCase(correctCountry)) {
                System.out.println("Correct! " + country.getCountryName() + " has the largest population in the EU.");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
            }
        }
    }

    @Override
    public void questionTwo() {
        System.out.println("2. What country’s national anthem has no official lyrics and is known in English as ‘The Royal March’?");
        String questionTwoAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "spain";

        Country country = CountryCRUD.selectCountryAndReturn(questionTwoAnswer);

        if (country != null) {
            if (country.getCountryName().equalsIgnoreCase(correctCountry)) {
                System.out.println("Correct! " + country.getCountryName() + "´s national anthem is known as ‘The Royal March’");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
            }
        }
    }

    @Override
    public void questionThree() {
        System.out.println("""
                3. Which country is known as the Hexagon?
                
                France
                Spain
                Germany
                """);
        String questionThreeAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "france";

        Country country = CountryCRUD.selectCountryAndReturn(questionThreeAnswer);

        if (country != null) {
            if (country.getCountryName().equalsIgnoreCase(correctCountry)) {
                System.out.println("Correct! " + country.getCountryName() + " is know as the Hexagon!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
            }

        }
    }

    @Override
    public void questionFour() {
        System.out.println("4. What country is known as Land of a Thousand Lakes?");
        String questionFourAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "finland";

        Country country = CountryCRUD.selectCountryAndReturn(questionFourAnswer);

        if (country != null) {
            if (country.getCountryName().equalsIgnoreCase(correctCountry)) {
                System.out.println("Correct! " + country.getCountryName() + " is know as Land of a Thousand Lakes");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
            }
        }
    }

    @Override
    public void questionFive() {
        System.out.println("5. Which African country is famous for being home to the Great Pyramid of Giza and the Sphinx?");
        String questionFiveAnswer = scanner.nextLine().trim().toLowerCase();

        String correctCountry = "egypt";

        Country country = CountryCRUD.selectCountryAndReturn(questionFiveAnswer);

        if (country != null) {
            if (country.getCountryName().equalsIgnoreCase(correctCountry)) {
                System.out.println("Correct! " + country.getCountryName() + " is famous for being home to the Great Pyramid of Giza and the Sphinx");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctCountry + ".");
            }
        }

    }
}
