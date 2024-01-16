create table passport(
    id serial primary key,
    seria int,
);

create table car(
    id serial primary key,
    model varchar(255)
);

create table passport_car(
    id serial primary key,
    passport_id int references passport(id) unique,
    car_id int references car(id) unique
);