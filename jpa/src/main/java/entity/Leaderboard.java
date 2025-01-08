package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard", schema = "demo")
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leaderboard_id", nullable = false)
    private int leaderboardId;

    @Column(name = "leaderboard_player")
    private String leaderboardPlayer;

    @Column(name = "leaderboard_score")
    private int leaderboardScore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leaderboard_quizType_id", nullable = false)
    private QuizType quizType;

    public int getLeaderboardId() {
        return leaderboardId;
    }

    public void setLeaderboardId(int leaderboardId) {
        this.leaderboardId = leaderboardId;
    }

    public String getLeaderboardPlayer() {
        return leaderboardPlayer;
    }

    public void setLeaderboardPlayer(String leaderboardPlayer) {
        this.leaderboardPlayer = leaderboardPlayer;
    }


    public int getLeaderboardScore() {
        return leaderboardScore;
    }

    public void setLeaderboardScore(int leaderboardScore) {
        this.leaderboardScore = leaderboardScore;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }


    public int getQuizTypeId() {
        return quizType.getQuizTypeId();
    }



    @Override
    public String toString() {
        return "Leaderboard{" +
                "leaderboardId=" + leaderboardId +
                ", leaderboardPlayer='" + leaderboardPlayer + '\'' +
                ", leaderboardScore=" + leaderboardScore +
                ", quizType=" + quizType +
                '}';
    }
}
