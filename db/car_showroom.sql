create table body_type(
    id serial primary key,
   type varchar(255)
);

create table car(
    id serial primary key,
    model varchar(255),
    body_type_id int references body_type(id) unique
);

insert into body_type(type) values ('седан');
insert into body_type(type) values ('пикап');
insert into body_type(type) values ('универсал');

insert into car (model, body_type_id) values ('BMW', 1);
insert into car (model, body_type_id) values ('RAM', 2);
insert into car (model, body_type_id) values ('Volvo', 3);

select c.model, b.type
from car as c join body_type as b on c.body_type_id = b.id;

select c.model as Модель, b.type as Тип
from car as с join body_type as b on c.body_type_id = b.id;

select c.model as "Модель авто", b.type "Тип кузова"
from car as с join body_type as b on c.body_type_id = b.id;