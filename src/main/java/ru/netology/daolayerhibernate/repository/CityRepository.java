package ru.netology.daolayerhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.daolayerhibernate.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
