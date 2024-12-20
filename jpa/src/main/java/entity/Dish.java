package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dish", schema = "demo")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id", nullable = false)
    private Integer id;

    @Column(name = "dish_name", nullable = false)
    private String dishName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dish_country_id", nullable = false)
    private Country dishCountry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setDishCountry(Country dishCountry) {
        this.dishCountry = dishCountry;
    }

}
