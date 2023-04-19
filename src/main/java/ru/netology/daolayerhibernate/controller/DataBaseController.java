package ru.netology.daolayerhibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.service.DataBaseService;

import java.util.ArrayList;

@RestController
public class DataBaseController {

    private final DataBaseService dataBaseService;

    public DataBaseController(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/persons/by-city")
    @ResponseBody
    public ResponseEntity<ArrayList<Person>> getPersonsByCity(@RequestParam(name = "city") String city) {
        return ResponseEntity.ok(dataBaseService.getPersonsByCity(city));
    }
}
