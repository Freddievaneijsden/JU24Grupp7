package meny;

import CRUD.*;

import java.util.Scanner;

public class MenyCRUD {

    private static String input;
    private static final Scanner scanner = new Scanner(System.in);
    private final CountryCRUD countryCrud = new CountryCRUD();
    private final AnimalCRUD animalCrud = new AnimalCRUD();
    private final CelebrityCRUD celebrityCrud = new CelebrityCRUD();
    private final DishCRUD dishCrud = new DishCRUD();

    public void insertMeny() {
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
                countryCrud.insertOne(countryName, language);
            }
            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                System.out.println("Enter country name: ");
                String countryName = scanner.nextLine();
                animalCrud.insertOne(animalName, countryName);
            }
            case "3" -> {
                System.out.println("Enter celebrity name: ");
                String celebrityName = scanner.nextLine();
                System.out.println("Enter new country name: ");
                String newCountryName = scanner.nextLine();
                celebrityCrud.insertOne(celebrityName, newCountryName);
            }
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

    public void updateMeny() {
        System.out.println("From which table would you like to update?");
        System.out.println("""
                1. Country
                2. Animal
                3. Celebrity
                4. Dish
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" ->  {
            System.out.println("Enter country name: ");
            String countryName = scanner.nextLine();
            System.out.println("Enter language ");
            String language = scanner.nextLine();
            countryCrud.updateOne(countryName, language);
            }

            case "2" -> {
                System.out.println("Enter animal name: ");
                String animalName = scanner.nextLine();
                System.out.println("Enter new country name: ");
                String newCountryName = scanner.nextLine();
                animalCrud.updateOne(animalName, newCountryName);
            }
            case "3" -> {
                System.out.println("Enter celebrity name: ");
                String celebrityName = scanner.nextLine();
                System.out.println("Enter new country name: ");
                String newCountryName = scanner.nextLine();
                celebrityCrud.updateOne(celebrityName, newCountryName);
            }
            case "4" -> System.out.println("Enter dish name: ");
            default -> System.out.println("Invalid input");
        }


    }

    public void selectMeny() {
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
                10. Select all celebrities from country 
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
            case "3" -> {
                System.out.println("Enter celebrity name: ");
                String celebrityName = scanner.nextLine();
                celebrityCrud.selectOne(celebrityName);
            }
            case "4" -> {
                System.out.println("Enter dish name: ");
                String dishName = scanner.nextLine();
                dishCrud.selectOne(dishName);
            }
            case "5" -> countryCrud.selectAll();
            case "6" -> animalCrud.selectAll();
            case "7" -> celebrityCrud.selectAll();
            case "8" -> dishCrud.selectAll();
            case "9" -> OneToMany.selectAllDishesFromCountry("Sweden");
            case "10" -> OneToMany.selectAllCelebritiesFromCountry("United States");
            default -> System.out.println("Invalid input");
        }
    }

    public void deleteMeny() {
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
            case "3" -> {
                System.out.println("Enter celebrity name: ");
                String celebrityName = scanner.nextLine();
                celebrityCrud.deleteOne(celebrityName);
            }
            case "4" -> {
                System.out.println("Enter dish name: ");
                String dishName = scanner.nextLine();
                dishCrud.deleteOne(dishName);
            }
            default -> System.out.println("Invalid input");
        }

    }
}
