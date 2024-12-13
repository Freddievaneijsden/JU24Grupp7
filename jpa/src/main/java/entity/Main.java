package entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

import static util.JPAUtil.getEntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        System.out.print("Enter search term: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // Validate user input
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.countryName = :name", Country.class);
        query.setParameter("name", name);
        List<Country> countries = query.getResultList();
        countries.forEach(System.out::println);
    }
}
