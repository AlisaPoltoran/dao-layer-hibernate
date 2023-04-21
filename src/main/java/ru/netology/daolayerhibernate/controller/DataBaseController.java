package ru.netology.daolayerhibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.entity.PersonId;
import ru.netology.daolayerhibernate.service.DataBaseService;

import java.util.List;

@RestController
public class DataBaseController {

    private final DataBaseService dataBaseService;

    public DataBaseController(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/persons/all")
    @ResponseBody
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(dataBaseService.getAllPersons());
    }

    @GetMapping("/persons/by-person-id")
    @ResponseBody
    public ResponseEntity<Person> getPersonByPersonId(@RequestBody PersonId personId) throws Exception {
        return ResponseEntity.ok(dataBaseService.getPersonByPersonId(personId));
    }

    @PostMapping("/persons/add-new-person")
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(dataBaseService.createPerson(person));
    }

    @PutMapping("/persons/alter-person")
    @ResponseBody
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) throws Exception {
        return ResponseEntity.ok(dataBaseService.updatePerson(person));
    }

    @DeleteMapping("/persons/delete-person")
    public ResponseEntity<String> deletePerson(@RequestBody PersonId personId) {
        return ResponseEntity.ok(dataBaseService.deletePerson(personId));
    }

    @GetMapping("/persons/by-city")
    @ResponseBody
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam(name = "city") String city) {
        return ResponseEntity.ok(dataBaseService.getPersonsByCity(city));
    }

    @GetMapping("/persons/by-age-less-than")
    @ResponseBody
    public ResponseEntity<List<Person>> getPersonsByAgeLessThan(@RequestParam(name = "age") Integer age) {
        return ResponseEntity.ok(dataBaseService.getPersonsByAgeLessThan(age));
    }

    @GetMapping("/persons/by-name-and-surname")
    @ResponseBody
    public ResponseEntity<List<Person>> getPersonsByNameAndSurname(@RequestParam(name = "name") String name,
                                                                   @RequestParam(name = "surname") String surname) {
        return ResponseEntity.ok(dataBaseService.getPersonsByNameAndSurname(name, surname));
    }
}
