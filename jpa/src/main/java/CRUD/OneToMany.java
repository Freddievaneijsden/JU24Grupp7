package CRUD;

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

            TypedQuery<Dish> query = entityManager.createQuery("SELECT d FROM Dish d WHERE d.dishCountry.countryName = LOWER(:name)", Dish.class);
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
}
