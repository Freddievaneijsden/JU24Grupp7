package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dish", schema = "demo")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id", nullable = false)
    private int dishId;

    @Column(name = "dish_name")
    private String dishName;

    @ManyToOne
    @JoinColumn(name = "dish_country_id", nullable = false)
    private Country dishCountry;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Country getDishCountry() {
        return dishCountry;
    }

    public void setDishCountry(Country country) {
        this.dishCountry = country;
    }
}
