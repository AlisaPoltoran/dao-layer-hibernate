package ru.netology.daolayerhibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.repository.DataBaseRepository;

import java.util.ArrayList;

@Service
public class DataBaseService {

    private final DataBaseRepository dataBaseRepository;

    public DataBaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public ArrayList<Person> getPersonsByCity (String city) {
        return dataBaseRepository.getPersonsByCity(city);
    }
}

