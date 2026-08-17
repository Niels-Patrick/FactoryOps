ALTER TABLE machines
	ADD COLUMN max_temperature NUMERIC(10, 2),
	ADD COLUMN max_vibration NUMERIC(10, 2),
	ADD COLUMN max_pressure NUMERIC(10, 2);

UPDATE machines
SET
	max_temperature = 80.00,
	max_vibration = 5.00,
	max_pressure = 180.00;

ALTER TABLE machines
	ALTER COLUMN max_temperature SET NOT NULL,
	ALTER COLUMN max_vibration SET NOT NULL,
	ALTER COLUMN max_pressure SET NOT NULL;
