create table training(
id serial primary key,
name varchar(255),
repeat int8,
description text
);
insert into training(name, repeat, description)
values('��� ����', 20, '��� ���� �� ������');
update training set description = '��� ���� �� ���������';
delete from training;
