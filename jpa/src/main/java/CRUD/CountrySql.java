package CRUD;

import entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;

public class CountrySql {

    public static void deleteCountry(String countryName) {
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

    public static void selectCountry(String countryName) {
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

    public static void insertCountry(String countryName, String countryLanguage) {
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

    public static void updateCountry(String countryName, String countryLanguage) {
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


}
