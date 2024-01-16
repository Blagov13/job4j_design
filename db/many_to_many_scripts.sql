create table terminal(
     id serial primary key,
     name varchar(255)
 );

 create table pass(
     id serial primary key,
     model varchar(255)
 );

 create table checkpoint(
     id serial primary key,
     terminal_id int references pass(id),
     pass_id int references terminal(id)
 );

insert into terminal(name) values ('bus');
insert into terminal(name) values ('train');
insert into terminal(name) values ('metro');

insert into pass(model) values ('one-time');
insert into pass(model) values ('subscription');
insert into pass(model) values ('preferential');

insert into checkpoint(terminal_id, pass_id) values (1, 1);
insert into checkpoint(terminal_id, pass_id) values (1, 2);
insert into checkpoint(terminal_id, pass_id) values (1, 3);
insert into checkpoint(terminal_id, pass_id) values (2, 1);
insert into checkpoint(terminal_id, pass_id) values (2, 2);
insert into checkpoint(terminal_id, pass_id) values (3, 3);
insert into checkpoint(terminal_id, pass_id) values (3, 2);