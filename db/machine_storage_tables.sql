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

insert into car_bodies(name) values ('sedan');
insert into car_bodies(name) values ('SUV');
insert into car_bodies(name) values ('cabriolet');

insert into car_engines(name) values ('petrol');
insert into car_engines(name) values ('diesel');
insert into car_engines(name) values ('electric motor');

insert into car_transmissions(name) values ('automatic');
insert into car_transmissions(name) values ('manual');
insert into car_transmissions(name) values ('robot');

insert into cars(name, body_id, engine_id, transmission_id)
values ('BMW', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Hummer', 2, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Mercedes', 3, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Жигули', 1, 1, null );