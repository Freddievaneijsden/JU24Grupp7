package CRUD;
import entity.Animal;
import entity.Country;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static util.JPAUtil.inTransaction;


public class AnimalCRUD implements Crudable {
    @Override
    public void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<Animal> query = entityManager.createQuery("SELECT c FROM Animal c", Animal.class);
            List<Animal> animals = query.getResultList();
            animals.forEach(System.out::println);
        });
    }

    @Override
    public void selectOne(String animalName) {
        inTransaction(entityManager -> {
            if (animalName == null || animalName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            TypedQuery<Animal> query = entityManager.createQuery("SELECT c FROM Animal c WHERE c.animalName = :name", Animal.class);
            query.setParameter("name", animalName);
            List<Animal> animals = query.getResultList();

            if (animals.isEmpty()) {
                System.out.println("Animal not found");
            } else animals.forEach(System.out::println);

        });
    }

    @Override
    public void deleteOne(String animalName) {
        inTransaction(entityManager -> {
            TypedQuery<Animal> query = entityManager.createQuery(
                    "SELECT c FROM Animal c WHERE c.animalName = :name", Animal.class);
            query.setParameter("name", animalName);
            List<Animal> animals = query.getResultList();

            if (animals.isEmpty()) {
                System.out.println("Animal not found");
            } else {

                animals.forEach(entityManager::remove);
                System.out.println("Deleted successfully: " + animalName);
            }
        });
    }

    @Override
    public void insertOne(String animalName, String countryName) {
        try {
            if (animalName == null || animalName.isEmpty()) {
                System.out.println("Name cannot be empty or null");
                return;
            }

            inTransaction(entityManager -> {
                TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c WHERE  c.countryName = :name", Country.class);
                query.setParameter("name", countryName);
                Country country = query.getSingleResult();

                    Animal animal = new Animal();
                    animal.setAnimalName(animalName);
                    animal.setAnimalCountry(country);
                    entityManager.persist(animal);
                    System.out.println("Inserted successfully: " + animalName);

            });
        } catch (Exception e) {
            System.out.println("Exception occurred when inserting Animal: " + e.getMessage());
        }

    }

    @Override
    public void updateOne(String animalName, String countryName) {
        try {
            inTransaction(entityManager -> {
                Query query = entityManager.createQuery(
                        "UPDATE Animal a SET a.animalCountry = (SELECT c FROM Country c WHERE c.countryName = :countryName) WHERE a.animalName = :name"
                );
                query.setParameter("countryName", countryName);
                query.setParameter("name", animalName);

                int rowsUpdated = query.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Updated successfully: " + animalName);
                } else {
                    System.out.println(animalName + " not found or update failed.");
                }
            });
        } catch (Exception e) {
            System.out.println("An error occurred while updating the animal: " + e.getMessage());
        }
    }

    public static Animal selectAnimalAndReturn(String animalName) {
        final Animal[] animalHolder = new Animal[1];
        try {
            inTransaction(entityManager -> {
                if (animalName == null || animalName.isEmpty()) {
                    System.out.println("Name cannot be empty or null");
                    return;
                }

                TypedQuery<Animal> query = entityManager.createQuery(
                        "SELECT a FROM Animal a WHERE a.animalName = :name", Animal.class);
                query.setParameter("name", animalName);

                animalHolder[0] = query.getSingleResult();
            });
        } catch (Exception e) {
            System.out.println("An error occurred while fetching the animal: " + e.getMessage());
        }
        return animalHolder[0];
    }

}
