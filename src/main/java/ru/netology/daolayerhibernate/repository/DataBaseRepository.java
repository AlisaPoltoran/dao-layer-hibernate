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
        String nativeSqlQuery = "SELECT * FROM persons WHERE city_of_living IN (SELECT id FROM city WHERE name = :city)";
        var query = entityManager.createNativeQuery(nativeSqlQuery, Person.class);
        query.setParameter("city", city);
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
