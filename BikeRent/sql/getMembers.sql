
CALL getMembers();

/*
Alap sql:
SELECT name, email, phone, address, identity FROM renters;

Új delimiter:
DELIMITER $$
	CREATE PROCEDURE getMembers()
    BEGIN
    	SELECT name, email, phone, address, identity FROM renters;
    END $$
DELIMITER ;
*/

