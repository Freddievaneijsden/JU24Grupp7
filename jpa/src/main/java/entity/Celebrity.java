package entity;

import jakarta.persistence.*;


@Entity
@Table(name = "celebrity")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "celebrity_id")
    private int celebrityId;

    @Column(name = "celebrity_name", nullable = false, unique = true)
    private String celebrityName;

    @ManyToOne
    @JoinColumn(name = "celebrity_country_id", nullable = false)
    private Country country;

    // Constructors, getters, setters, and toString()
    public Celebrity() {}

    public Celebrity(String celebrityName, Country country) {
        this.celebrityName = celebrityName;
        this.country = country;
    }

    public int getCelebrityId() {
        return celebrityId;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "celebrityId=" + celebrityId +
                ", celebrityName='" + celebrityName + '\'' +
                ", country=" + country.getCountryName() +
                '}';
    }
}

