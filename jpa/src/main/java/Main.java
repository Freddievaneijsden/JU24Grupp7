import CRUD.CountrySql;
import com.google.protobuf.Value;
import meny.menyCRUD;
import quiz.CountryQuiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountryQuiz quiz = new CountryQuiz();

        boolean running = true;
        String input = "";

        while (running) {
            System.out.println("""
                    1. Quiz
                    2. Insert into database
                    3. Delete from database
                    4. Update from database
                    5. Select from database
                    6. Statistics from database
                    7. Exit
                    """);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> quiz.play();
                case "2" -> menyCRUD.insertOneMeny();
                case "3" -> menyCRUD.deleteOneMeny();
                case "4" -> menyCRUD.updateOneMeny();
                case "5" -> menyCRUD.selectOneMeny();
                case "6" -> System.out.println("Statistics from database");
                case "7" -> running = false;
                default -> System.out.println("Invalid input, please try again!");
            }
        }
    }

}
