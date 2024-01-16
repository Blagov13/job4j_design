insert into users(name, items_id) values ('Aleksandr', 1);
insert into roles(name) values ('admin');
insert into rules(name) values ('full');
insert into rules_roles (roles_id, rules_id) values (1, 1);
insert into items (name, attachs_id, comment_id) values ('raport', 1, 1);
insert into comment(name) values ('fast');
insert into attachs(name) values ('file');
insert into states(name, items_id) values ('done', 1);
insert into categories(name, items_id) values ('important', 1);
