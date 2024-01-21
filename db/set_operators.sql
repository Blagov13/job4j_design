/*Создаем таблицы*/
CREATE TABLE movie(
    id       SERIAL PRIMARY KEY,
    name     text,
    director text
);

CREATE TABLE book(
    id     SERIAL PRIMARY KEY,
    title  text,
    author text
);

/*Добавляем данные*/
INSERT INTO movie (name, director)
VALUES ('Марсианин', 'Ридли Скотт'),
       ('Матрица', 'Братья Вачовски'),
       ('Властелин колец', 'Питер Джексон'),
       ('Гарри Поттер и узник Азкабана', 'Альфонсо Куарон'),
       ('Железный человек', 'Джон Фавро');

INSERT INTO book (title, author)
VALUES ('Гарри Поттер и узник Азкабана', 'Джоан Роулинг'),
       ('Властелин колец', 'Джон Толкин'),
       ('1984', 'Джордж Оруэлл'),
       ('Марсианин', 'Энди Уир'),
       ('Божественная комедия', 'Данте Алигьери');

/*Названия фильмов снятые по книге*/
SELECT name from movie
INTERSECT
SELECT title from book;

/*Книги без экранизации*/
SELECT title from book
EXCEPT
SELECT name from movie;

/*Уникальные названия произведений из таблиц movie и book*/
SELECT name from movie
EXCEPT
SELECT title from book
UNION ALL
(SELECT title from book
EXCEPT
SELECT name from movie);