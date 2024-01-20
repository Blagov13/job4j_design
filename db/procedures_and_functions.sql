/*Создаем таблицу*/
create table products(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

/*Создаем процедуру*/
create
or replace procedure delete_data(u_count integer, tax float, u_id integer)
language 'plpgsql'
as $$
    BEGIN
       if u_count = 0 THEN
            DELETE from products
            where id = u_id;
        end if;
    END;
$$;

/*Вызываем процедуру*/
call update_data(0, 0, 1);

/*Создаем функцию*/
create
or replace function f_delete_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        DELETE from products WHERE count <= 0;
        return result;
    end;
$$;

/*Вызываем функцию*/
select f_delete_data(0, 0.2, 0);





