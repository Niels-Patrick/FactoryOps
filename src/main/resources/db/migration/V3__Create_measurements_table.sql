CREATE TABLE IF NOT EXISTS measurements (
	id UUID PRIMARY KEY,
	machine_id UUID NOT NULL,
	measurement_timestamp TIMESTAMP NOT NULL,
	temperature NUMERIC(10, 2) NOT NULL,
	vibration NUMERIC(10, 2) NOT NULL,
	pressure NUMERIC(10, 2) NOT NULL,
	FOREIGN KEY (machine_id) REFERENCES machines(id)
);
