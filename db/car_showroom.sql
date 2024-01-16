create table body_type(
    id serial primary key,
   type varchar(255)
);

create table car(
    id serial primary key,
    model varchar(255),
    body_type_id int references body_type(id) unique
);

insert into body_type(type) values ('�����');
insert into body_type(type) values ('�����');
insert into body_type(type) values ('���������');

insert into car (model, body_type_id) values ('BMW', 1);
insert into car (model, body_type_id) values ('RAM', 2);
insert into car (model, body_type_id) values ('Volvo', 3);

select c.model, b.type
from car as c join body_type as b on c.body_type_id = b.id;

select c.model as ������, b.type as ���
from car as � join body_type as b on c.body_type_id = b.id;

select c.model as "������ ����", b.type "��� ������"
from car as � join body_type as b on c.body_type_id = b.id;