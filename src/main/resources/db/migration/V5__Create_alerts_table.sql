CREATE TABLE IF NOT EXISTS alerts (
	id UUID PRIMARY KEY,
	machine_id UUID NOT NULL,
	measurement_id UUID NOT NULL,
	alert_type VARCHAR(30) NOT NULL,
	measured_value NUMERIC(10, 2) NOT NULL,
	threshold_value NUMERIC(10, 2) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	acknowledged BOOLEAN NOT NULL DEFAULT FALSE,
	FOREIGN KEY (machine_id) REFERENCES machines(id),
	FOREIGN KEY (measurement_id) REFERENCES measurements(id)
);
