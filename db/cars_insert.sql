INSERT INTO color(name) VALUES('Черный');
INSERT INTO color(name) VALUES('Белый');
INSERT INTO color(name) VALUES('Красный');
INSERT INTO color(name) VALUES('Оранжевый');

INSERT INTO price(price) VALUES(20000);
INSERT INTO price(price) VALUES(10000);
INSERT INTO price(price) VALUES(40000);
INSERT INTO price(price) VALUES(5000);

INSERT into cars_showroom(cars_id, price_id, availability,
                          body_id, engine_id, transmission_id, color_id)
VALUES(1, 1, TRUE, 1, 1, 1, 2);
INSERT into cars_showroom(cars_id, price_id, availability,
                          body_id, engine_id, transmission_id, color_id)
VALUES(2, 2, FALSE, 2, 1, 1, 1);
INSERT into cars_showroom(cars_id, price_id, availability,
                          body_id, engine_id, transmission_id, color_id)
VALUES(4, 4, TRUE, 1, 1, 2, 3);
INSERT into cars_showroom(cars_id, price_id, availability,
                          body_id, engine_id, transmission_id, color_id)
VALUES(3, 3, TRUE, 1, 2, 1, 1);