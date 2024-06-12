CREATE TABLE IF NOT EXISTS film (
id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
director VARCHAR(255) NOT NULL,
budget DECIMAL(10,2) NOT NULL,
duration DECIMAL(10,2) NOT NULL,
release_date DATE NOT NULL,
genre VARCHAR(50),
box_office DECIMAL(30,2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS scene (
id SERIAL PRIMARY KEY,
description VARCHAR(255) NOT NULL,
minutes DECIMAL(10,2) NOT NULL,
location VARCHAR(100) NOT NULL,
setting VARCHAR(100),
film_id INT,
FOREIGN KEY (film_id) REFERENCES film(id)
    );

CREATE TABLE IF NOT EXISTS characters (
id SERIAL PRIMARY KEY,
description VARCHAR(255) NOT NULL,
cost DECIMAL(10,2) NOT NULL,
name_actor VARCHAR(100) NOT NULL,
rol VARCHAR(100) NOT NULL,
importance VARCHAR(50) NOT NULL,
scene_id INT,
FOREIGN KEY (scene_id) REFERENCES scene(id)
    );

CREATE VIEW scenes_with_film AS
SELECT s.id AS scene_id, s.description AS scene_description, s.minutes, s.location, s.setting, f.title AS film_title
FROM scene s
         JOIN film f ON s.film_id = f.id;

CREATE VIEW characters_with_scene AS
SELECT c.id AS character_id, c.description AS character_description, c.cost, c.name_actor, c.rol, c.importance, s.description AS scene_description
FROM characters c
         JOIN scene s ON c.scene_id = s.id;
