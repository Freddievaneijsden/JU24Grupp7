package CRUD;
import entity.Country;
import jakarta.persistence.TypedQuery;
import java.util.List;
import static util.JPAUtil.inTransaction;
import entity.Animal;


public class AnimalCRUD implements Crudable {
    @Override
    public void selectAll() {
        inTransaction(entityManager -> {
            TypedQuery<String> query = entityManager.createQuery("SELECT c.animalName FROM Animal c", String.class);
            List<String> animals = query.getResultList();
            for (String animalNames : animals) {
                System.out.println(animalNames);
            }
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
            List<Animal> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("Animal not found");
            } else countries.forEach(System.out::println);

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
        if (animalName == null || animalName.isEmpty()) {
            System.out.println("Name cannot be empty or null");
        }

        inTransaction(entityManager -> {
            Animal animal = new Animal();
            animal.setAnimalName(animalName);
            //animal.setAnimalCountry();
            entityManager.persist(animal);
            System.out.println("Inserted successfully: " + animalName);
        });
    }

    @Override
    public void updateOne(String countryName, String countryLanguage) {
    };

    public static Animal selectCountryAndReturn(String countryName) {
        inTransaction(entityManager -> {});
        return null;
    };

}
