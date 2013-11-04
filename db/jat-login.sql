CREATE DATABASE jat;

USE jat;

CREATE TABLE jat_login (
	id				VARCHAR(25) NOT NULL PRIMARY KEY,
	password			VARCHAR(32) NOT NULL,
	email			VARCHAR(50) NOT NULL,
	update_date		DATETIME    NOT NULL,	
	update_user		VARCHAR(25) NOT NULL
);