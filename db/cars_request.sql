/*Делаю запрос на выборку машин*/
SELECT cars_showroom.id, cars.name as car_name, car_bodies.name as body_name,
car_engines.name as engine_name, car_transmissions.name as transmission_name,
price.price as price, max(price.price), color.name as color
from cars_showroom
left join cars
on cars_showroom.cars_id = cars.id
LEFT JOIN car_bodies
on cars.body_id = car_bodies.id
LEFT JOIN car_transmissions
on cars.transmission_id = car_transmissions.id
LEFT JOIN car_engines
on cars.engine_id = car_engines.id
LEFT JOIN price
on cars_showroom.price_id = price.id
left join color
on cars_showroom.color_id = color.id
GROUP by (cars_showroom.id, cars.name, car_bodies.name,
car_engines.name, car_transmissions.name,
price.price, color.name)
having max(price.price) > 5000;

/*Создаю представление*/
CREATE VIEW expensive_cars
as
SELECT cars_showroom.id, cars.name as car_name, car_bodies.name as body_name,
car_engines.name as engine_name, car_transmissions.name as transmission_name,
price.price as price, max(price.price), color.name as color
from cars_showroom
left join cars
on cars_showroom.cars_id = cars.id
LEFT JOIN car_bodies
on cars.body_id = car_bodies.id
LEFT JOIN car_transmissions
on cars.transmission_id = car_transmissions.id
LEFT JOIN car_engines
on cars.engine_id = car_engines.id
LEFT JOIN price
on cars_showroom.price_id = price.id
left join color
on cars_showroom.color_id = color.id
GROUP by (cars_showroom.id, cars.name, car_bodies.name,
car_engines.name, car_transmissions.name,
price.price, color.name)
having max(price.price) > 5000;

/*Проверяю*/
SELECT * FROM expensive_cars;