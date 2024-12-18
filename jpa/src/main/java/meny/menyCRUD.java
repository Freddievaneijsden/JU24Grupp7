package meny;

import CRUD.OneToMany;

import java.util.Scanner;

public class menyCRUD {

    private static String input;
    private static final Scanner scanner = new Scanner(System.in);

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
            case "1" -> System.out.println("Enter country name: ");
            case "2" -> System.out.println("Enter animal name: ");
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> System.out.println("Enter dish name: ");
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
            case "2" -> System.out.println("Enter animal name: ");
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
                5. Select all dishes from country
                """);
        input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("Enter country name: ");
            case "2" -> System.out.println("Enter animal name: ");
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> System.out.println("Enter dish name: ");
            case "5" -> OneToMany.selectAllDishesFromCountry("Sweden");
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
            case "1" -> System.out.println("Enter country name: ");
            case "2" -> System.out.println("Enter animal name: ");
            case "3" -> System.out.println("Enter celebrity name: ");
            case "4" -> System.out.println("Enter dish name: ");
            default -> System.out.println("Invalid input");
        }

    }
}
