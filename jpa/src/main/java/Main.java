
import CRUD.LeaderboardCRUD;
import meny.MenyCRUD;
import meny.MenyQuiz;
import quiz.CountryQuiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenyCRUD menyCRUD = new MenyCRUD();
        MenyQuiz menyQuiz = new MenyQuiz();



        boolean running = true;
        String input = "";

        while (running) {
            System.out.println("""
                    1. Quiz
                    2. Leaderboard 
                    3. Insert into database
                    4. Delete from database
                    5. Update from database
                    6. Select from database
                    7. Statistics from database
                    8. Exit 
                    """);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> menyQuiz.chooseQuiz();
                case "2" -> LeaderboardCRUD.selectAllDesc();
                case "3" -> menyCRUD.insertMeny();
                case "4" -> menyCRUD.deleteMeny();
                case "5" -> menyCRUD.updateMeny();
                case "6" -> menyCRUD.selectMeny();
                case "7" -> System.out.println("Statistics from database");
                case "8" -> running = false;
                default -> System.out.println("Invalid input, please try again!");
            }
        }
    }

}
