/*������� �������*/
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

/*��������� ������*/
INSERT INTO movie (name, director)
VALUES ('���������', '����� �����'),
       ('�������', '������ ��������'),
       ('��������� �����', '����� �������'),
       ('����� ������ � ����� ��������', '�������� ������'),
       ('�������� �������', '���� �����');

INSERT INTO book (title, author)
VALUES ('����� ������ � ����� ��������', '����� �������'),
       ('��������� �����', '���� ������'),
       ('1984', '������ ������'),
       ('���������', '���� ���'),
       ('������������ �������', '����� ��������');

/*�������� ������� ������ �� �����*/
SELECT name from movie
INTERSECT
SELECT title from book;

/*����� ��� �����������*/
SELECT title from book
EXCEPT
SELECT name from movie;

/*���������� �������� ������������ �� ������ movie � book*/
SELECT name from movie
EXCEPT
SELECT title from book
UNION ALL
(SELECT title from book
EXCEPT
SELECT name from movie);