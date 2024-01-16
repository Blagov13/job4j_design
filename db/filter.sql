create table type (
    id serial primary key,
    name varchar(255)
);

create table product (
    id serial primary key,
    name  varchar(255),
    type_id int references type(id) unique,
    expiried_date date,
    price float
);

select p.product
from product p
join type t
on p.type_id = t.id
group by p.product
where t.name like 'СЫР';

select * from product where name like 'мороженое';

select * from product where expiried_date < current_date;

select max(price) from product;

select t.name, count(*)
from product p
join type t
on p.type_id = t.id
group by t.id;

select p.product
from product p
join type t
on p.type_id = t.id
group by p.product
where t.name like 'СЫР' or 'МОЛОКО';

select t.name, count(*)
from product p join type t
on p.type_id = t.id
group by t.id
having count(*) < 10;

select p.name, t.type
from product p
join type t
on p.type_id = t.id;