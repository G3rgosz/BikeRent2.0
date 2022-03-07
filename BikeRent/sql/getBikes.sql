CALL getBikes();

/*
Alap sql:
SELECT type, design, size, brake, speed, brand, code FROM bikes 
INNER JOIN types ON bikes.type_id = types.id 
INNER JOIN designs ON bikes.design_id = designs.id 
INNER JOIN sizes ON bikes.size_id = sizes.id 
INNER JOIN brakes ON bikes.brake_id = brakes.id 
INNER JOIN brands ON bikes.brand_id = brands.id;

Új delimiter:
DELIMITER $$
	CREATE PROCEDURE getBikes()
    BEGIN
    	SELECT type, design, size, brake, speed, brand, code FROM bikes 
        INNER JOIN types ON bikes.type_id = types.id 
        INNER JOIN designs ON bikes.design_id = designs.id 
        INNER JOIN sizes ON bikes.size_id = sizes.id 
        INNER JOIN brakes ON bikes.brake_id = brakes.id 
        INNER JOIN brands ON bikes.brand_id = brands.id;
    END $$
DELIMITER ;
*/