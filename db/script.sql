create table training(
id serial primary key,
name varchar(255),
repeat int8,
description text
);
insert into training(name, repeat, description)
values('Жим лежа', 20, 'Жим лежа на скамье');
update training set description = 'Жим лежа на наклонной';
delete from training;
