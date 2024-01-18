create table teens (
id serial primary key,
name varchar(255),
gender varchar(255)
);

insert into teens (name, gender) values ('Aleks', 'man');
insert into teens (name, gender) values ('Jesika', 'woman');
insert into teens (name, gender) values ('Tom', 'man');
insert into teens (name, gender) values ('Darla', 'woman');

select m.name as g1, w.name as g2 from teens m cross join teens w
where m.gender != w.gender and m.gender like 'wo%'

