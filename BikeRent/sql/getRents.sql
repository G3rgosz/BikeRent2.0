CALL getRents();


/*
Alap sql:
SELECT name, code, startdate, enddate, deposit FROM rents 
INNER JOIN bikes ON rents.bike_id = bikes.id 
INNER JOIN renters ON rents.renter_id = renters.id; 

Új delimiter:
DELIMITER $$
	CREATE PROCEDURE getRents()
    BEGIN
        SELECT name, code, startdate, enddate, deposit FROM rents 
        INNER JOIN bikes ON rents.bike_id = bikes.id 
        INNER JOIN renters ON rents.renter_id = renters.id; 
    END $$
DELIMITER ;
*/

