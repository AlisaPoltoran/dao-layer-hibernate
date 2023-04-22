package ru.netology.daolayerhibernate.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.entity.PersonId;
import ru.netology.daolayerhibernate.exception.InvalidPersonId;
import ru.netology.daolayerhibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DataBaseService {

    private final PersonRepository dataBaseRepository;

    public DataBaseService(PersonRepository personRepository) {
        this.dataBaseRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return dataBaseRepository.findAll();
    }

    public Person getPersonByPersonId(PersonId personId) throws Exception {
        return dataBaseRepository.findById(personId)
                .orElseThrow(() -> new InvalidPersonId("The person with specified " +
                        "PersonId is not found, please check the PersonId"));
    }

    public Person createPerson(Person person) {
        if (!dataBaseRepository.findById(person.getPersonId()).isPresent()) {
            return dataBaseRepository.save(person);
        } else {
            throw new InvalidPersonId("The person with specified PersonId has already been created");
        }
    }

    public Person updatePerson(Person person) throws Exception {
        if (dataBaseRepository.findById(person.getPersonId()).isPresent()) {
            return dataBaseRepository.save(person);
        } else {
            throw new InvalidPersonId("The person with specified " +
                    "PersonId is not found, please check the PersonId");
        }
    }

    public String deletePerson(PersonId personId) {
        Optional<Person> person = dataBaseRepository.findById(personId);
        if (person.isPresent()) {
            dataBaseRepository.delete(person.get());
            return "The person " + personId.toString() + " is successfully deleted";
        }
        throw new InvalidPersonId("The person with specified " +
                "PersonId is not found, please check the PersonId");
    }

    public List<Person> getPersonsByCity(String city) {
        return dataBaseRepository.findByCity_Name(city);
    }

    public List<Person> getPersonsByAgeLessThan(Integer age) {
        return dataBaseRepository.findByPersonId_AgeLessThanOrderByPersonId_AgeAsc(age,
                Sort.by("personId.age").ascending());
    }

    public List<Person> getPersonsByNameAndSurname(String name, String surname) {
        return dataBaseRepository.findByPersonId_NameAndPersonId_Surname(name, surname);
    }
}

