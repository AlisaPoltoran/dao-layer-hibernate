insert into postgres.city (name)
values ('Moscow'),
       ('Saint-Petersburg'),
       ('Kazan')
on conflict(id) do nothing;

insert into postgres.customers
    (age, name, surname, phone_number, city_of_living)
values (10, 'Maria', 'Balashova', '+74991234567', 1),
       (12, 'Pavel', 'Ivanov', '+74991234577', 1),
       (14, 'Igor', 'Bylinin', '+78121234567', 2),
       (14, 'Olga', 'Krivosheykina', '+74991235567', 1),
       (25, 'Anfisa', 'Baranova', '+74997766116', 3)
on conflict(age, name, surname) do nothing;