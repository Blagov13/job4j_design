/*������� �������*/
create table products(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

/*������� ������� ��� 1) ��������*/
create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

/*������� 1) �������*/
create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

/*������� ������� ��� 2) ��������*/
create
or replace function tax_function_before()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2
        ;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

/*������� 2) �������*/
create trigger tax_trigger_before
    BEFORE insert
    on products
    for each row
    execute procedure tax_function_before();

/*������� ������� history_of_price*/
create table history_of_price(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

/*������� ������� ��� ������� ������ � ����� �������*/
CREATE OR REPLACE FUNCTION history_of_price()
  returns trigger as
$$
BEGIN
    INSERT INTO history_of_price(name, price, date)
    VALUES(new.name, new.price, now());
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

/*������� ������� ��� ������������ ������ � ����� �������*/
create trigger trigger_for_history_of_price
    AFTER insert
    on products
    for each row
    execute procedure history_of_price();