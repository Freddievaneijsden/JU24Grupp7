package meny;

import CRUD.AnimalCRUD;
import CRUD.CountryCRUD;
import CRUD.DishCRUD;
import CRUD.OneToMany;

import java.util.Scanner;

public class menyCRUD {

    private static String input;
    private static final Scanner scanner = new Scanner(System.in);
    static CountryCRUD countryCrud = new CountryCRUD();
    static AnimalCRUD animalCrud = new AnimalCRUD();
    static DishCRUD dishCrud = new DishCRUD();

    public static void insertMeny() {
        System.out.println("Which table would you like to insert?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                System.out.println("Enter language ");
                String language = scanner.nextLine();
                dishCrud.insertOne(countryName, language);
            }
            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                animalCrud.insertOne(animalName, countryName);
            }
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> {
                System.out.println("Enter dish name: ");
                String dishName = scanner.nextLine();
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                dishCrud.insertOne(dishName, countryName);
            }
            default -> System.out.println("Invalid input");
        }


    }

    public static void updateMeny() {
        System.out.println("From which table would you like to update?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("Enter country name: ");
            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                System.out.println("Enter new country name: ");
                String newCountryName = scanner.nextLine();
                animalCrud.updateOne(animalName, newCountryName);
            }
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> System.out.println("Enter dish name: ");
            default -> System.out.println("Invalid input");
        }


    }

    public static void selectMeny() {
        System.out.println("From which table would you like to select?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                5. Select all countries
                6. Select all animals
                7. Select all celebrities
                8. Select all dishes
                9. Select all dishes from country
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                countryCrud.selectOne(countryName);
            }
            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                animalCrud.selectOne(animalName);
            }
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> {
                System.out.println("Enter dish name: ");
                String dishName = scanner.nextLine();
                dishCrud.selectOne(dishName);
            }
            case "5" -> countryCrud.selectAll();
            case "6" -> animalCrud.selectAll();
            case "7" -> System.out.println("Select all celebrities: ");
            case "8" -> dishCrud.selectAll();
            case "9" -> OneToMany.selectAllDishesFromCountry("Sweden");
            default -> System.out.println("Invalid input");
        }
    }

    public static void deleteMeny() {
        System.out.println("From which table would you like to delete?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                countryCrud.deleteOne(countryName);
            }
            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                animalCrud.deleteOne(animalName);
            }
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> {
                System.out.println("Enter dish name: ");
                String dishName = scanner.nextLine();
                dishCrud.deleteOne(dishName);
            }
            default -> System.out.println("Invalid input");
        }

    }
}
