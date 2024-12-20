package CRUD;

import entity.Country;
import entity.Leaderboard;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;

public class LeaderboardCRUD {

    public static void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<Leaderboard> query = entityManager.createQuery("SELECT l FROM Leaderboard l", Leaderboard.class);
            List<Leaderboard> players = query.getResultList();
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + 1 + ". " + players.get(i).getLeaderboardPlayer() + " | Score: " + players.get(i).getLeaderboardScore()
                + " | QuizType: " + players.get(i).getLeaderboardQuizType());
            }
        });
    }

    public static  void insertOne(String player, int score, int quizType) {
        if (player == null || player.isEmpty()) {
            System.out.println("Name cannot be empty or null");
        }
        inTransaction(entityManager -> {
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.setLeaderboardPlayer(player);
            leaderboard.setLeaderboardScore(score);
            leaderboard.setLeaderboardQuizType(quizType);

            entityManager.persist(leaderboard);
            System.out.println("Inserted successfully: " + player + " " + score + " " + quizType);
        });
    }

    public static void selectAllDesc() {
        inTransaction(entityManager -> {
            TypedQuery<Leaderboard> query = entityManager.createQuery("SELECT l FROM Leaderboard l ORDER BY l.leaderboardScore DESC" , Leaderboard.class);
            List<Leaderboard> players = query.getResultList();
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + 1 + ". " + players.get(i).getLeaderboardPlayer() + " | Score: " + players.get(i).getLeaderboardScore()
                        + " | QuizType: " + players.get(i).getLeaderboardQuizType());
            }
        });
    }

    public static void showNumberElementsInLeaderboard() {
        inTransaction(entityManager -> {
            TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(l.leaderboardPlayer) FROM Leaderboard l" , Long.class);
                           var numberOfPlayers = query.getSingleResult();
            System.out.println("Number of players on leaderboard: " + numberOfPlayers);
        });

    }
}



