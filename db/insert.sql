insert into users(name, roles_id) values ('Aleksandr', 1);
insert into roles(name) values ('admin');
insert into rules(name) values ('full');
insert into rules_roles (roles_id, rules_id) values (1, 1);
insert into items (name, categories_id, states_id, users_id) values ('raport', 1, 1, 1);
insert into comment(name, items_id) values ('fast', 1);
insert into attachs(name, items_id) values ('file', 1);
insert into states(name) values ('done');
insert into categories(name) values ('important');
