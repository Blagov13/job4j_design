/*������� ������ ���� ����� � ��� ����������� � ��� ������.*/
SELECT cars.id, cars.name as car_name, car_bodies.name as body_name,
car_engines.name as engine_name, car_transmissions.name as transmission_name
from cars
LEFT JOIN car_bodies
on cars.body_id = car_bodies.id
LEFT JOIN car_transmissions
on cars.transmission_id = car_transmissions.id
LEFT JOIN car_engines
on cars.engine_id = car_engines.id;

/*������� ������, ������� �� ������������ �� � ����� ������.*/
SELECT car_bodies.name from car_bodies
WHERE NOT EXISTS(SELECT 1 FROM cars WHERE cars.body_id = car_bodies.id);

/*������� ������� �������, ������� �� ������������ �� � ����� ������.*/
SELECT car_transmissions.name from car_transmissions
WHERE NOT EXISTS(SELECT * FROM cars WHERE cars.transmission_id = car_transmissions.id);

/*������� ���������, ������� �� ������������ �� � ����� ������.*/
SELECT car_engines.name from car_engines
WHERE NOT EXISTS(SELECT * FROM cars WHERE cars.engine_id = car_engines.id);