create table rules (
id serial primary key,
name text
);

create table roles (
id serial primary key,
name text
);

create table states (
id serial primary key,
name text
);

create table categories (
id serial primary key,
name text
);

create table rules_roles (
id serial primary key,
rules_id int references rules(id),
roles_id int references roles(id)
);

create table users (
id serial primary key,
name varchar(255),
roles_id int references roles(id)
);

create table items (
id serial primary key,
name text,
categories_id int references categories(id),
users_id int references users(id),
states_id int references states(id)
);

create table comment (
id serial primary key,
name text,
items_id int references items(id)
);

create table attachs (
id serial primary key,
name text,
items_id int references items(id)
);