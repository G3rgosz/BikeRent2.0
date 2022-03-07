--- új renters
DELIMITER $$
CREATE PROCEDURE add_renter(IN name VARCHAR(100), IN email VARCHAR(100), 
                            IN phone VARCHAR(20), IN address VARCHAR(255),
                            IN identity VARCHAR(20))
    BEGIN
        INSERT INTO renters (name, email, phone, address, identity) VALUES
                            (name, email, phone, address, identity);
    END $$
DELIMITER ;
--módosítás renters
DELIMITER $$
CREATE PROCEDURE edit_renter(IN i_id INT, IN i_name VARCHAR(100), 
                            IN i_email VARCHAR(100),IN i_phone VARCHAR(20), 
                            IN i_address VARCHAR(255), IN i_identity VARCHAR(20))
    BEGIN
        UPDATE renters 
        SET name = i_name, 
            email = i_email, 
            phone = i_phone, 
            address = i_address, 
            identity = i_identity
        WHERE id = i_id;
    END $$
DELIMITER ;
--új bike
DELIMITER $$
CREATE PROCEDURE add_bike(IN code CHAR(5), IN speed INT, 
                        IN brand_id VARCHAR(20), IN brake_id VARCHAR(20),
                        IN design_id VARCHAR(20), IN size_id CHAR(10),
                        IN type_id VARCHAR(20))
    BEGIN
        DECLARE brand_i INT DEFAULT 0;
        DECLARE brake_i INT DEFAULT 0;
        DECLARE design_i INT DEFAULT 0;
        DECLARE size_i INT DEFAULT 0;
        DECLARE type_i INT DEFAULT 0;
        SELECT id INTO brand_i FROM brands WHERE brand = brand_id;
        SELECT id INTO brake_i FROM brakes WHERE brake = brake_id;
        SELECT id INTO design_i FROM designs WHERE design = design_id;
        SELECT id INTO size_i FROM sizes WHERE size = size_id;
        SELECT id INTO type_i FROM types WHERE type = type_id;
        INSERT INTO bikes (code, speed, brand_id, brake_id, design_id, size_id, type_id) VALUES
                            (code, speed, brand_i, brake_i, design_i, size_i, type_i);
    END $$
DELIMITER ;
/*bmx
10
férfi
TREK
tárcsa*/
--új bike
DELIMITER $$
CREATE PROCEDURE edit_bike(IN b_id INT, IN code CHAR(5), IN speed INT, 
                        IN brand_id VARCHAR(20), IN brake_id VARCHAR(20),
                        IN design_id VARCHAR(20), IN size_id CHAR(10),
                        IN type_id VARCHAR(20))
    BEGIN
        DECLARE brand_i INT DEFAULT 0;
        DECLARE brake_i INT DEFAULT 0;
        DECLARE design_i INT DEFAULT 0;
        DECLARE size_i INT DEFAULT 0;
        DECLARE type_i INT DEFAULT 0;
        SELECT id INTO brand_i FROM brands WHERE brand = brand_id;
        SELECT id INTO brake_i FROM brakes WHERE brake = brake_id;
        SELECT id INTO design_i FROM designs WHERE design = design_id;
        SELECT id INTO size_i FROM sizes WHERE size = size_id;
        SELECT id INTO type_i FROM types WHERE type = type_id;
        UPDATE bikes 
        SET code = code, speed = speed, brand_id = brand_i, brake_id = brand_i, 
            design_id = design_i , size_id = size_i, type_id = type_i
        WHERE id = b_id;
    END $$
DELIMITER ;
