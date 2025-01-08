package quiz;

import CRUD.AnimalCRUD;
import CRUD.LeaderboardCRUD;
import entity.Animal;

import java.util.List;
import java.util.Scanner;

public class AnimalQuiz implements Quiz { ;

    private final Scanner scanner = new Scanner(System.in);
    private int score = 0;


    public void play() {
        System.out.println("Welcome to the Animal Quiz!");
        System.out.println("Enter your name: ");
        String quizName = scanner.nextLine();
        int animalQuiz = 2;
        List<AnimalCRUD.Animals> animals = AnimalCRUD.getAnimals();
        if (animals == null) {
            return;
        }

        for (int count = 0; count < 5; count++) {
            int question = (int) (Math.random() * (animals.size()-1));
            AnimalCRUD.Animals animal = animals.get(question);
            if (animal.getAnimalCountry() == null) {
                quizFormQuizField(animal);
            } else if (animal.getAnimalQuiz() == null) {
                quizFromCountryField(animal);
            }
            animals.remove(question);
        }

        LeaderboardCRUD.insertOne(quizName, score, animalQuiz);
        Result.showResult(quizName, score);
    }

    private void quizFromCountryField(AnimalCRUD.Animals animal) {
        System.out.println("What country has " + animal.getAnimalName() + " as there national animal?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(animal.getAnimalCountry())) {
            System.out.println("Correct");
            score++;
        } else {
            System.out.println("Incorrect, the answer is " + animal.getAnimalCountry());
        }
    }

    public void quizFormQuizField (AnimalCRUD.Animals animal) {
        System.out.println(animal.getAnimalQuiz());
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(animal.getAnimalName())) {
            System.out.println("Correct");
            score++;
        } else {
            System.out.println("Incorrect, the answer is: " + animal.getAnimalName());
        }

    }
}
