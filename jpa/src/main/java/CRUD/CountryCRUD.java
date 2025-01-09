package CRUD;

import entity.Country;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static util.JPAUtil.inTransaction;

public class CountryCRUD implements Crudable{


    @Override
    public void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<String> query = entityManager.createQuery("SELECT c.countryName FROM Country c", String.class);
            List<String> countries = query.getResultList();
            for (String countryName : countries) {
                System.out.println(countryName);
            }
        });
    }

    @Override
    public void selectOne(String countryName) {
        inTransaction(entityManager -> {
            if (countryName == null || countryName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
            query.setParameter("name", countryName);
            List<Country> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Country not found");
            } else countries.forEach(System.out::println);

        });
    }

    @Override
    public void deleteOne(String countryName) {
        inTransaction(entityManager -> {
            TypedQuery<Country> query = entityManager.createQuery(
                    "SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
            query.setParameter("name", countryName);
            List<Country> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Country not found");
            } else {
                // Delete each country found (usually one if countryName is unique)
                countries.forEach(entityManager::remove);
                System.out.println("Deleted successfully: " + countryName);
            }
        });
    }

    @Override
    public void insertOne(String countryName, String countryLanguage) {
        if (countryName == null || countryName.isEmpty()) {
            System.out.println("Name cannot be empty or null");
        }
        inTransaction(entityManager -> {
            Country country = new Country();
            country.setCountryName(countryName);
            country.setCountryLanguage(countryLanguage);
            entityManager.persist(country);
            System.out.println("Inserted successfully: " + countryName);
        });
}

    @Override
    public void updateOne(String countryName, String countryLanguage) {
       try {
           inTransaction(entityManager -> {
               TypedQuery<Country> query = entityManager.createQuery(
                       "SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
               query.setParameter("name", countryName);
               List<Country> countries = query.getResultList();

               if (countries.isEmpty()) {
                   System.out.println("Country not found: " + countryName);
                   return;
               }
               Country country = countries.get(0);
               country.setCountryLanguage(countryLanguage);
               entityManager.merge(country);
               System.out.println("Updated successfully: " + countryName);
           });
       } catch (Exception e) {
           System.out.println("An error occurred while updating the country: " + e.getMessage());
       }
    };

    public static Country selectCountryAndReturn(String countryName) {
        final Country[] countryHolder = new Country[1];
        inTransaction(entityManager -> {
            if (countryName == null || countryName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
            }

            TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
            query.setParameter("name", countryName);
            List<Country> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Country not found");
            }
            else countryHolder[0] = countries.get(0);
        });
        return countryHolder[0];
    }

    public static List<Country> returnAllCountries() {
        List <Country> countries = new ArrayList<>();
        inTransaction(entityManager -> {
            TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c", Country.class);
            List<Country> countriesHolder = query.getResultList();
            countries.addAll(countriesHolder);
        });
        return countries;
    }
}

