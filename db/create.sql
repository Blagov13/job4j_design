create table users (
id serial primary key,
name varchar(255),
items_id int references items(id),
);

create table roles (
id serial primary key,
users_id int references users(id),
name text
);

create table rules (
id serial primary key,
name text
);

create table rules_roles (
id serial primary key,
rules_id int references rules(id),
roles_id int references roles(id)
);

create table items (
id serial primary key,
name text,
attachs_id int references attachs(id),
comment_id int references comment(id)
);

create table comment (
id serial primary key,
name text
);

create table attachs (
id serial primary key,
name text
);

create table states (
id serial primary key,
name text,
items_id int references items(id)
);

create table categories (
id serial primary key,
name text,
items_id int references items(id)
);