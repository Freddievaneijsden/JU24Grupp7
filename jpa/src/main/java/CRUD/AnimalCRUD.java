package CRUD;
import entity.Animal;
import entity.Country;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
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

    public static List<Animals> getAnimals() {
        List<Animals> animals = new ArrayList<>();
        try {
            inTransaction(entityManager -> {
                TypedQuery query = entityManager.createQuery("SELECT a FROM Animal a", Animal.class);
                List <Animal> animalList = query.getResultList();
                animalList.forEach(animal -> {animals.add(new Animals(animal.getAnimalName(),
                        countryName(animal),
                        animal.getAnimalQuiz()));});
            });
        } catch (Exception e) {
            System.out.println("An error occurred while fetching the animals: " + e.getMessage());
        }
        return animals;
    }

    public static String countryName (Animal animal) {
        if (animal.getAnimalCountry() == null) {
            return null;
        } else {
            return animal.getAnimalCountry().getCountryName();
        }
    }

    public static class Animals {
        private String animalName;
        private String animalCountry;
        private String animalQuiz;

        public Animals(String animalName, String animalCountry, String animalQuiz) {
            this.animalName = animalName;
            this.animalCountry = animalCountry;
            this.animalQuiz = animalQuiz;
        }

        public String getAnimalCountry() {
            return animalCountry;
        }

        public String getAnimalQuiz() {
            return animalQuiz;
        }

        @Override
        public String toString() {
            return "Animals{" +
                    "animalName='" + animalName + '\'' +
                    ", animalCountry='" + animalCountry + '\'' +
                    ", animalQuiz='" + animalQuiz + '\'' +
                    '}';
        }

        public String getAnimalName() {
            return animalName;
        }

    }
}
