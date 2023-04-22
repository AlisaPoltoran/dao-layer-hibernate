package ru.netology.daolayerhibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.entity.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query("select p from Person p where p.city.name = :city")
    List<Person> findByCity_Name(@Param("city") String city);

    @Query("select p from Person p where p.personId.age < :age")
    List<Person> findByPersonId_AgeLessThanOrderByPersonId_AgeAsc(@Param("age") Integer age, Sort sort);

    @Query("select p from Person p where p.personId.name = :name and p.personId.surname = :surname")
    List<Person> findByPersonId_NameAndPersonId_Surname(@Param("name") String name,
                                                        @Param("surname") String surname);

}