package CRUD;

import entity.Country;
import entity.Leaderboard;
import entity.QuizType;
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
                + " | QuizType: " + players.get(i).getQuizType());
            }
        });
    }

    public static  void insertOne(String player, int score, int quizTypeId) {
        if (player == null || player.isEmpty()) {
            System.out.println("Name cannot be empty or null");
        }
        inTransaction(entityManager -> {
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.setLeaderboardPlayer(player);
            leaderboard.setLeaderboardScore(score);

            QuizType quizType = entityManager.find(QuizType.class, quizTypeId);
            if (quizType == null) {
                System.out.println("Invalid quiz type ID: " + quizTypeId);
                return;
            }
            leaderboard.setQuizType(quizType);

            entityManager.persist(leaderboard);
        });
    }

    public static void selectAllDesc() {
        inTransaction(entityManager -> {
            TypedQuery<Leaderboard> query = entityManager.createQuery("SELECT l FROM Leaderboard l ORDER BY l.leaderboardScore DESC" , Leaderboard.class);
            List<Leaderboard> players = query.getResultList();
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + 1 + ". " + players.get(i).getLeaderboardPlayer() + " | Score: " + players.get(i).getLeaderboardScore()
                        + " | QuizType: " + players.get(i).getQuizType());
            }
            System.out.println();
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



