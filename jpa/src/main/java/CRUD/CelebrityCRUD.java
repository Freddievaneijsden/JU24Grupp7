package CRUD;

import entity.Celebrity;
import entity.Country;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;

public class CelebrityCRUD implements Crudable {

    @Override
    public void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<Celebrity> query = entityManager.createQuery("SELECT c FROM Celebrity c", Celebrity.class);
            List<Celebrity> celebrities = query.getResultList();
            celebrities.forEach(System.out::println);
        });
    }

    @Override
    public void selectOne(String celebrityName) {
        inTransaction(entityManager -> {
            if (celebrityName == null || celebrityName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Celebrity> query = entityManager.createQuery("SELECT c FROM Celebrity c WHERE c.celebrityName = :name", Celebrity.class);
            query.setParameter("name", celebrityName);
            List<Celebrity> celebrities = query.getResultList();

            if (celebrities.isEmpty()) {
                System.out.println("Celebrity not found");
            } else {
                celebrities.forEach(System.out::println);
            }
        });
    }

    @Override
    public void insertOne(String celebrityName, String countryName) {
        if (celebrityName == null || celebrityName.isEmpty() || countryName == null || countryName.isEmpty()) {
            System.out.println("Name and country cannot be empty or null");
            return;
        }
        inTransaction(entityManager -> {
            // Fetch the country entity
            TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
            query.setParameter("name", countryName);
            List<Country> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Country not found: " + countryName);
                return;
            }

            Country country = countries.get(0);

            // Create and persist the celebrity
            Celebrity celebrity = new Celebrity();
            celebrity.setCelebrityName(celebrityName);
            celebrity.setCountry(country);
            entityManager.persist(celebrity);
            System.out.println("Inserted successfully: " + celebrityName);
        });
    }

    @Override
    public void updateOne(String celebrityName, String countryName) {
        if (celebrityName == null || celebrityName.isEmpty() || countryName == null || countryName.isEmpty()) {
            System.out.println("Name and country cannot be empty or null");
            return;
        }
        inTransaction(entityManager -> {
            // Fetch the celebrity
            TypedQuery<Celebrity> query = entityManager.createQuery("SELECT c FROM Celebrity c WHERE c.celebrityName = :name", Celebrity.class);
            query.setParameter("name", celebrityName);
            List<Celebrity> celebrities = query.getResultList();

            if (celebrities.isEmpty()) {
                System.out.println("Celebrity not found: " + celebrityName);
                return;
            }

            Celebrity celebrity = celebrities.get(0);

            // Fetch the new country
            TypedQuery<Country> countryQuery = entityManager.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
            countryQuery.setParameter("name", countryName);
            List<Country> countries = countryQuery.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Country not found: " + countryName);
                return;
            }

            Country country = countries.get(0);

            // Update the celebrity's country
            celebrity.setCountry(country);
            entityManager.merge(celebrity);
            System.out.println("Updated successfully: " + celebrityName);
        });
    }

    @Override
    public void deleteOne(String celebrityName) {
        inTransaction(entityManager -> {
            TypedQuery<Celebrity> query = entityManager.createQuery(
                    "SELECT c FROM Celebrity c WHERE c.celebrityName = :name", Celebrity.class);
            query.setParameter("name", celebrityName);
            List<Celebrity> celebrities = query.getResultList();

            if (celebrities.isEmpty()) {
                System.out.println("Celebrity not found");
            } else {
                celebrities.forEach(entityManager::remove);
                System.out.println("Deleted successfully: " + celebrityName);
            }
        });
    }

    public static Celebrity selectCelebrityAndReturn(String celebrityName) {
        final Celebrity[] celebrityHolder = new Celebrity[1];
        inTransaction(entityManager -> {
            if (celebrityName == null || celebrityName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Celebrity> query = entityManager.createQuery("SELECT c FROM Celebrity c WHERE c.celebrityName = :name", Celebrity.class);
            query.setParameter("name", celebrityName);
            List<Celebrity> celebrities = query.getResultList();

            if (celebrities.isEmpty()) {
                System.out.println("Celebrity not found");
            } else {
                celebrityHolder[0] = celebrities.get(0);
            }
        });
        return celebrityHolder[0];
    }
}
