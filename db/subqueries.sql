/*������� �������*/
CREATE TABLE customers(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

/*��������� ������*/
INSERT into customers (first_name, last_name, age, country)
VALUES ('ALex','Blagov', 31, 'Moskow');
INSERT into customers (first_name, last_name, age, country)
VALUES ('Roben','Betvenovich', 18, 'Gotem');
INSERT into customers (first_name, last_name, age, country)
VALUES ('Betmen','Ivanovich', 20, 'Gotem');
INSERT into customers (first_name, last_name, age, country)
VALUES ('Arnold','Schwarzenegger', 76, 'Austria');

/*���������� ������ ��������, ������� ������� �����������*/
SELECT *  FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

/*������� ������ �������*/
CREATE TABLE orders(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

/*��������� ������*/
INSERT into orders (amount, customer_id) VALUES (5, 1);
INSERT into orders (amount, customer_id) VALUES (4, 2);
INSERT into orders (amount, customer_id) VALUES (3, 3);
INSERT into orders (amount, customer_id) VALUES (0, 4);

/*����������� ������ �������������, ������� ��� �� ��������� �� ������ ������*/
SELECT * from customers
WHERE customers.id in
(SELECT customer_id from orders WHERE amount = 0);


















