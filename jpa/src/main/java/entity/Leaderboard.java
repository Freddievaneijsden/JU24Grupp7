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

    @Column (name = "leaderboard_quiz_type")
    private int leaderboardQuizType;

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

    public int getLeaderboardQuizType() {
        return leaderboardQuizType;
    }

    public void setLeaderboardQuizType(int leaderboardQuizType) {
        this.leaderboardQuizType = leaderboardQuizType;
    }

    public int getLeaderboardScore() {
        return leaderboardScore;
    }

    public void setLeaderboardScore(int leaderboardScore) {
        this.leaderboardScore = leaderboardScore;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "leaderboardId=" + leaderboardId +
                ", leaderboardPlayer='" + leaderboardPlayer + '\'' +
                ", leaderboardScore=" + leaderboardScore +
                ", leaderboardQuizType=" + leaderboardQuizType +
                '}';
    }
}
