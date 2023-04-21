package ru.netology.daolayerhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.entity.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCity_Name(String city);

    List<Person> findByPersonId_AgeLessThanOrderByPersonId_AgeAsc(Integer age);

    List<Person> findByPersonId_NameAndPersonId_Surname(String name, String surname);

}