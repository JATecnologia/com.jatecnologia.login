CREATE DATABASE IF NOT EXISTS jat;

USE jat;

CREATE TABLE jat_user (
	login			VARCHAR(25) NOT NULL,
	password		VARCHAR(32) NOT NULL,
	email			VARCHAR(50) NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE jat_group(
	name			VARCHAR(25) NOT NULL,
	email		    VARCHAR(25) NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE jat_user_group(
	name_group		VARCHAR(25) NOT NULL,
	user_login		VARCHAR(25) NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL
) ENGINE=InnoDB;

ALTER TABLE jat_user ADD CONSTRAINT pk_user PRIMARY KEY (login);

ALTER TABLE jat_group ADD CONSTRAINT pk_group PRIMARY KEY (name);

ALTER TABLE jat_user_group ADD CONSTRAINT pk_user_group PRIMARY KEY (name_group, user_login);

ALTER TABLE jat_user_group ADD CONSTRAINT fk_user_login FOREIGN KEY (user_login) REFERENCES jat_user (login);

ALTER TABLE jat_user_group ADD CONSTRAINT fk_name_group FOREIGN KEY (name_group) REFERENCES jat_group (name);