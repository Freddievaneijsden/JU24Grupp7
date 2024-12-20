package CRUD;

import entity.Celebrity;
import entity.Country;
import entity.Dish;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;

public class OneToMany {

    public static void selectAllDishesFromCountry (String countryName) {
        inTransaction(entityManager -> {
            if (countryName == null || countryName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Dish> query = entityManager.createQuery("SELECT d FROM Dish d WHERE d.country.countryName = LOWER(:name)", Dish.class);
            query.setParameter("name", countryName.toLowerCase());
            List<Dish> dishes = query.getResultList();

            if (dishes.isEmpty()) {
                System.out.println("Country not found");
            }
            else {
                System.out.println("Dishes from " + countryName + ":");
                dishes.forEach(dish -> System.out.println(dish.getDishName())); }

        });
    }

    public static void selectAllCelebritiesFromCountry(String countryName) {
        inTransaction(entityManager -> {
            if (countryName == null || countryName.isEmpty()) {
                System.out.println("Country name cannot be empty or null");
                return;
            }

            TypedQuery<Celebrity> query = entityManager.createQuery(
                    "SELECT c FROM Celebrity c WHERE LOWER(c.country.countryName) = LOWER(:name)", Celebrity.class);
            query.setParameter("name", countryName.toLowerCase());
            List<Celebrity> celebrities = query.getResultList();

            if (celebrities.isEmpty()) {
                System.out.println("No celebrities found in " + countryName + ".");
            } else {
                System.out.println("Celebrities from " + countryName + ":");
                celebrities.forEach(celebrity -> System.out.println(celebrity.getCelebrityName()));
            }
        });
    }
}
