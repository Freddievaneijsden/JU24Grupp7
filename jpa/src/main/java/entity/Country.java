package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country", schema = "demo")

public class Country {
    @Id
    @Column(name = "country_Id", nullable = false)
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_language")
    private String countryLanguage;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryCode(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(String countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", countryLanguage='" + countryLanguage + '\'' +
                '}';
    }
}