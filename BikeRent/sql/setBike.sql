SELECT id FROM brands WHERE brand = ?;
SELECT id FROM brakes WHERE brake = ?;
SELECT id FROM designs WHERE design = ?;
SELECT id FROM sizes WHERE size = ?;
SELECT id FROM types WHERE type = ?;

INSERT INTO bikes( code, speed, brand_id, brake_id, design_id, size_id, type_id)
VALUES (?, ?, ?, ?, ?, ?, ?);

