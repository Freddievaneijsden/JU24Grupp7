package meny;

import CRUD.AnimalCRUD;
import quiz.AnimalQuiz;
import quiz.CelebrityQuiz;
import quiz.CountryQuiz;
import quiz.DishQuiz;

import java.util.Scanner;

public class MenyQuiz {
    private static String input;
    private static final Scanner scanner = new Scanner(System.in);
    private CountryQuiz countryQuiz = new CountryQuiz();
    private AnimalQuiz animalQuiz = new AnimalQuiz();
    private CelebrityQuiz celebrityQuiz = new CelebrityQuiz();
    private DishQuiz dishQuiz = new DishQuiz();

    public void chooseQuiz() {
        System.out.println("Which quiz would you like to take?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                """);
        input = scanner.nextLine();
        switch (input) {
        case "1" -> countryQuiz.play();
        case "2" -> animalQuiz.play();
        case "3" -> celebrityQuiz.play();
        case "4" -> dishQuiz.play();
        }
    }
}
