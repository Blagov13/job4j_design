/*Создаем таблицу*/
create table transactions
(
    id       serial primary key,
    name     varchar(50),
    surname  varchar(50),
    score    integer,
    saving    integer
);

/*Добавляем данные*/
INSERT INTO transactions(name, surname, score, saving) VALUES ('Tom', 'Li', 2000, 1000);
INSERT INTO transactions(name, surname, score, saving) VALUES ('Bob', 'Hi', 3000, 100);
INSERT INTO transactions(name, surname, score, saving) VALUES ('Ken', 'Pi', 1000, 5000);

/*Начинаем транзакцию */
begin;

/*Проверяем таблицу*/
select * from transactions;

/*Изменяем данные*/
update transactions set saving = 5000 where name = 'Tom';

/*Создаем точку сохранения*/
savepoint first_point;

/*Удаляем значения */
delete from transactions where saving < 5000;

/*Создаем вторую точку сохранения*/
savepoint two_point;

/*Откатываемся к первой точке*/
rollback to first_point;

/*Проверяем содержимое таблицы*/
select * from transactions;