package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quizType", schema = "demo")
public class QuizType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizType_id", nullable = false)
    private int quizTypeId;

    @Column(name = "quizType_name")
    private String quizTypeName;

    @OneToMany(mappedBy = "quizType")
    private List<Leaderboard> leaderboards = new ArrayList<>();

    public int getQuizTypeId() {
        return quizTypeId;
    }

    public void setQuizTypeId(int quizTypeId) {
        this.quizTypeId = quizTypeId;
    }

    public String getQuizTypeName() {
        return quizTypeName;
    }

    public void setQuizTypeName(String quizTypeName) {
        this.quizTypeName = quizTypeName;
    }

    public List<Leaderboard> getLeaderboards() {
        return leaderboards;
    }

    public void setLeaderboards(List<Leaderboard> leaderboards) {
        this.leaderboards = leaderboards;
    }


    @Override
    public String toString() {
        return quizTypeName;
    }
}
