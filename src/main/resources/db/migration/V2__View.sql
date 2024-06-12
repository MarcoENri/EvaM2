CREATE VIEW scenes_with_film AS
SELECT s.*, s.description AS scene_description, s.minutes, s.location, s.setting, f.title AS film_title
FROM scene s
         JOIN film f ON s.film_id = f.id;

CREATE VIEW characters_with_scene AS
SELECT c.*, s.description AS scene_description
FROM characters c
         JOIN scene s ON c.scene_id = s.id;