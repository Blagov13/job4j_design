/*���� 2 ������� �������� ������ � ��*/
CREATE TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

/*1. � ����� ������� ��������
- ����� ���� person, ������� �� ������� � �������� � id = 5;
- �������� �������� ��� ������� ��������.*/
SELECT person.name, company.name from person
JOIN company
on company_id = company.id
WHERE not EXISTS(SELECT * from company WHERE company_id = 5);

/*2. ���������� ������� �������� �������� � ������������ ����������� ������� + ���������� ������� � ���� ��������.
����� ������, ��� ����� �������� ����� ���� ���������.*/
create view max_count as
select company.name, count(person.id) as count
from company join person
on company.id = person.company_id
group by company.name;

select * from max_count
where max_count.count =
(select max(count) from (
select * from max_count));



