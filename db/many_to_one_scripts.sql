create table engine(
    id serial primary key,
    name varchar(255),
    type varchar(255)
);

create table car(
    id serial primary key,
    model varchar(255),
    engine_id int references engine(id)
);

insert into engine(name, type) values ('programmer', 'diesel');
insert into car(model, engine_id) VALUES ('BMW', 1);

select * from car;

select * from engine where id in (select engine_id from car);