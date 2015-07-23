/*
 * HSQLDB script.
 * Create the database schema for the application.
 */
DROP TABLE temps IF EXISTS;

CREATE TABLE temps(
	time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, 
	sensnum numeric, temp numeric);
