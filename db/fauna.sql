create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('dog', 3650, '1758-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('fly', 30, '1817-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('mouse', 540, '1700-01-01');

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select name from fauna where discovery_date < '1950-01-01'

