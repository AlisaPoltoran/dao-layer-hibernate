create schema if not exists postgres;

create table if not exists postgres.city
(
    id   SERIAL primary key,
    name varchar(255) not null
);

create table if not exists postgres.customers
(
    name           varchar(255) not null,
    surname        varchar(255) not null,
    age            integer      not null,
    phone_number   varchar(255) not null,
    city_of_living integer not null,
    FOREIGN KEY (city_of_living) references postgres.city (id),
    CONSTRAINT person_id PRIMARY KEY (name, surname, age)
);