package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country", schema = "demo")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_language")
    private String countryLanguage;

    @OneToMany(mappedBy = "dishCountry")
    private List<Dish> dishes = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Dish> celebrities = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setCountry(this); // Set the country reference in Dish
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.setCountry(null); // Break the relationship
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getCelebrities() {
        return celebrities;
    }

    public void setCelebrities(List<Dish> celebrities) {
        this.celebrities = celebrities;
    }

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
