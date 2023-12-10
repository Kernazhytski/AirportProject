DELIMITER //
CREATE PROCEDURE UpdateFlightStatus()
BEGIN
    DECLARE curr_time DATETIME;
    SET curr_time = (SELECT NOW());

UPDATE flight
SET flight_status =
        CASE
            WHEN curr_time < departure_time THEN 'Полет еще не начался'
            WHEN curr_time < arrival_time AND curr_time > departure_time THEN 'Полет идет'
            ELSE 'Полет закончен'
            END;
END
DELIMITER ;
