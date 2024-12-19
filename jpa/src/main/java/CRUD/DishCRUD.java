package CRUD;

import entity.Country;
import entity.Dish;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;

public class DishCRUD implements Crudable{

    @Override
    public void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<Dish> query = entityManager.createQuery("SELECT c FROM Dish c", Dish.class);
            List<Dish> dishes = query.getResultList();
            dishes.forEach(System.out::println);
        });
    }

    @Override
    public void selectOne(String dishName) {
        inTransaction(entityManager -> {
            if (dishName == null || dishName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Dish> query = entityManager.createQuery("SELECT c FROM Dish c WHERE c.dishName = :name", Dish.class);
            query.setParameter("name", dishName);
            List<Dish> dishes = query.getResultList();

            if (dishes.isEmpty()) {
                System.out.println("Dish not found");
            } else dishes.forEach(System.out::println);

        });
    }

    @Override
    public void deleteOne(String dishName) {
        inTransaction(entityManager -> {
            TypedQuery<Dish> query = entityManager.createQuery(
                    "SELECT c FROM Dish c WHERE c.dishName = :name", Dish.class);
            query.setParameter("name", dishName);
            List<Dish> dishes = query.getResultList();

            if (dishes.isEmpty()) {
                System.out.println("Dish not found");
            } else {

                dishes.forEach(entityManager::remove);
                System.out.println("Deleted successfully: " + dishName);
            }
        });
    }

    @Override
    public void insertOne(String dishName, String countryName) {
        try {
            if (dishName == null || dishName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            inTransaction(entityManager -> {
                TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c WHERE  c.countryName = :name", Country.class);
                query.setParameter("name", countryName);
                Country country = query.getSingleResult();

                Dish dish = new Dish();
                dish.setDishName(dishName);
                dish.setCountry(country);
                entityManager.persist(dish);
                System.out.println("Inserted successfully: " + dishName);

            });
        } catch (Exception e) {
            System.out.println("Exception occurred when inserting dish: " + e.getMessage());
        }

    }

    @Override
    public void updateOne(String dishName, String countryName) {
        try {
            inTransaction(entityManager -> {
                Query query = entityManager.createQuery(
                        "UPDATE Dish a SET a.country = (SELECT c FROM Country c WHERE c.countryName = :countryName) WHERE a.dishName = :name"
                );
                query.setParameter("countryName", countryName);
                query.setParameter("name", dishName);

                int rowsUpdated = query.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Updated successfully: " + dishName);
                } else {
                    System.out.println(dishName + " not found or update failed.");
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while updating the dish: " + e.getMessage());
        }
    }

    public static Dish selectDishAndReturn(String dishName) {
        final Dish[] dishHolder = new Dish[1];
        try {
            inTransaction(entityManager -> {
                if (dishName == null || dishName.isEmpty()) {
                    System.out.println("Name cannot be empty or null");
                    return;
                }

                TypedQuery<Dish> query = entityManager.createQuery(
                        "SELECT a FROM Dish a WHERE a.dishName = :name", Dish.class);
                query.setParameter("name", dishName);

                dishHolder[0] = query.getSingleResult();
            });
        } catch (Exception e) {
            System.out.println("An error occurred while fetching the dish: " + e.getMessage());
        }
        return dishHolder[0];
    }
}
