package meny;

import CRUD.CountrySql;

import java.util.Scanner;

public class menyCRUD {

    private static String input;
    private static final Scanner scanner = new Scanner(System.in);

    public static void insertOneMeny() {
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

    public static void updateOneMeny() {
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

    public static void selectOneMeny() {
        System.out.println("From which table would you like to select?");
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

    public static void deleteOneMeny() {
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
