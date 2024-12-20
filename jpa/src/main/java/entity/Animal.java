package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "animal", schema = "demo")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", nullable = false)
    private Integer id;

    @Column(name = "animal_name", nullable = false)
    private String animalName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_country_id")
    private Country animalCountry;

    @Column(name = "animal_quiz", length = 225)
    private String animalQuiz;

    public String getAnimalQuiz() {
        return animalQuiz;
    }

    public void setAnimalQuiz(String animalQuiz) {
        this.animalQuiz = animalQuiz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Country getAnimalCountry() {
        return animalCountry;
    }

    public void setAnimalCountry(Country animalCountry) {
        this.animalCountry = animalCountry;
    }

    @Override
    public String toString() {
        return "id=" + id + ", Name='" + animalName + ", Country=" + animalCountry;
    }
}
