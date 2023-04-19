package ru.netology.daolayerhibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.netology.daolayerhibernate.entity.City;
import ru.netology.daolayerhibernate.entity.Person;

import java.util.ArrayList;

@Repository
@Data
@Transactional
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ArrayList<Person> getPersonsByCity(String city) {
        long cityId = switch (city) {
            case "Moscow" -> 1L;
            case "Saint-Petersburg" -> 2L;
            case "Kazan" -> 3L;
            default -> 0;
        };

        var query = entityManager.createNativeQuery("SELECT * from persons where city_of_living = :city", Person.class);
        query.setParameter("city", cityId);
        @SuppressWarnings("unchecked")
        ArrayList<Person> personsList = (ArrayList<Person>) query.getResultList();
        System.out.println(personsList);
        return personsList;
    }

    public void persistPerson(Person person) {
        entityManager.persist(person);
    }

    public void persistCity(City city) {
        entityManager.persist(city);
    }
}
