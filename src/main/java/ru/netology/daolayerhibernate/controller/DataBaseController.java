package ru.netology.daolayerhibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured("ROLE_READ")
    @ResponseBody
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(dataBaseService.getAllPersons());
    }

    @PostMapping("/persons/add-new-person")
    @RolesAllowed("WRITER")
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(dataBaseService.createPerson(person));
    }

    @PutMapping("/persons/alter-person")
    @PostAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @ResponseBody
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) throws Exception {
        return ResponseEntity.ok(dataBaseService.updatePerson(person));
    }

    @DeleteMapping("/persons/delete-person")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public ResponseEntity<String> deletePerson(@RequestBody PersonId personId) {
        return ResponseEntity.ok(dataBaseService.deletePerson(personId));
    }

    @GetMapping("/persons/say-hi")
    @PreAuthorize("#username == authentication.principal.username")
    @ResponseBody
    public ResponseEntity<String> getMyRoles(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok("Hello " + username);
    }

    @GetMapping("/persons/by-person-id")
    @ResponseBody
    public ResponseEntity<Person> getPersonByPersonId(@RequestBody PersonId personId) throws Exception {
        return ResponseEntity.ok(dataBaseService.getPersonByPersonId(personId));
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
