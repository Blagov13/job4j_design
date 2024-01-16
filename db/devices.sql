create table devices (
    id serial primary key,
    name  varchar(255),
    price float
);

create table people (
    id serial primary key,
    name varchar(255)
);

create table devices_people (
    id serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values ('telephone', 98000.50);
insert into devices(name, price) values ('headphones', 15000.1);
insert into devices(name, price) values ('laptop', 120000.3);

insert into people(name) values ('Саша','Даша','Борис');

insert into devices_people(people_id, device_id) values (1, 3);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (3, 2);

select avg(price) from devices;

select p.name, avg(d.price)
from devices as d
join devices_people as dp
on d.id = dp.device_id
join people as p
on p.id = dp.people_id
group by p.name

select p.name, avg(d.price)
from devices as d
join devices_people as dp
on d.id = dp.device_id
join people as p
on p.id = dp.people_id
group by p.name
having avg(d.price) > 5000;


