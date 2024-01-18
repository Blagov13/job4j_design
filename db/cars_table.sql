create table car_bodies(
id serial primary key,
name varchar(255)
);

create table car_engines(
id serial primary key,
name varchar(255)
);

create table car_transmissions(
id serial primary key,
name varchar(255)
);

create table cars(
id serial primary key,
name varchar(255),
body_id int references car_bodies(id),
engine_id int references car_engines(id),
transmission_id int references car_transmissions(id)
);

CREATE TABLE price(
  id serial primary key,
  price FLOAT8
  );

CREATE TABLE color(
  id serial primary key,
  name VARCHAR(255)
  );

CREATE TABLE cars_showroom(
  id serial primary key,
  body_id int references car_bodies(id),
  engine_id int references car_engines(id),
  transmission_id int references car_transmissions(id),
  cars_id int REFERENCES cars(id),
  price_id int REFERENCES price(id),
  color_id int REFERENCES color(id),
  availability BOOLEAN
  );