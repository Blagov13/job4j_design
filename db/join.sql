create table departments (
    id serial primary key,
    name varchar(255)
);

create table employees (
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('security', 'admin', 'accountant');
insert into employees(name, departments_id) values ('Aleks', 1);
insert into employees(name, departments_id) values ('Rob', 2);
insert into employees(name, departments_id) values ('Tom', 1);

select * from employees e left join departments d
on d.employees_id = e.id;

select * from employees e right join departments d
on d.employees_id = e.id;

select * from employees e full join departments d
on d.employees_id = e.id;

select * from employees e cross join departments d;

select * from employees e left join departments d
on d.employees_id = e.id
where e.id is null;

