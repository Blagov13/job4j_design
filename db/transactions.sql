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


