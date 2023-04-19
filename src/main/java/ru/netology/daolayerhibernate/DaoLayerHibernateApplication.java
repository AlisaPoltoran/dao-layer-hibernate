package ru.netology.daolayerhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netology.daolayerhibernate.entity.City;
import ru.netology.daolayerhibernate.entity.Person;
import ru.netology.daolayerhibernate.entity.PersonId;
import ru.netology.daolayerhibernate.repository.DataBaseRepository;

import java.util.List;

@SpringBootApplication
public class DaoLayerHibernateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DaoLayerHibernateApplication.class, args);
    }

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @Override
    public void run(String... args) {
        List<City> cities = List.of(City.builder().name("Moscow").build(),
                City.builder().name("Saint-Petersburg").build(),
                City.builder().name("Kazan").build());

        cities.forEach(c -> dataBaseRepository.persistCity(c));

        Person firstPerson = Person.builder()
                .personId(PersonId.builder()
                        .name("Masha")
                        .surname("Ivanova")
                        .age(22)
                        .build())
                .phoneNumber("+79991234567")
                .city(City.builder()
                        .id(1L)
                        .name("Moscow")
                        .build())
                .build();

        Person secondPerson = Person.builder()
                .personId(PersonId.builder()
                        .name("Alina")
                        .surname("Balashova")
                        .age(28)
                        .build())
                .phoneNumber("+79991299567")
                .city(City.builder()
                        .id(1L)
                        .name("Moscow")
                        .build())
                .build();

        Person thirdPerson = Person.builder()
                .personId(PersonId.builder()
                        .name("Lesha")
                        .surname("Kapa")
                        .age(44)
                        .build())
                .phoneNumber("+79771299567")
                .city(City.builder()
                        .id(2L)
                        .name("Saint-Petersburg")
                        .build())
                .build();

        Person fourthPerson = Person.builder()
                .personId(PersonId.builder()
                        .name("Gena")
                        .surname("Hechaev")
                        .age(30)
                        .build())
                .phoneNumber("+79771421567")
                .city(City.builder()
                        .id(3L)
                        .name("Kazan")
                        .build())
                .build();

        dataBaseRepository.persistPerson(firstPerson);
        dataBaseRepository.persistPerson(secondPerson);
        dataBaseRepository.persistPerson(thirdPerson);
        dataBaseRepository.persistPerson(fourthPerson);

    }

}
