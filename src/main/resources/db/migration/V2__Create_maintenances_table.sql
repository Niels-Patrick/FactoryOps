CREATE TABLE IF NOT EXISTS maintenances (
	id UUID PRIMARY KEY,
	machine_id UUID NOT NULL,
	maintenance_date DATE NOT NULL,
	description TEXT,
	technician VARCHAR(100) NOT NULL,
	maintenance_type VARCHAR(30) NOT NULL,
	duration_hours INTEGER NOT NULL,
	FOREIGN KEY (machine_id) REFERENCES machines(id)
);
