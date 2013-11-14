START TRANSACTION;

CREATE DATABASE IF NOT EXISTS jat;

USE jat;

CREATE TABLE jat_user (
	id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	login			VARCHAR(25) NOT NULL,
	password		VARCHAR(64) NOT NULL,
	email			VARCHAR(50) NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL,
	CONSTRAINT uk_user_login UNIQUE (login)
) ENGINE=InnoDB;

CREATE TABLE jat_group(
	id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name			VARCHAR(25) NOT NULL,
	email		    VARCHAR(25) NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL,
	CONSTRAINT uk_group_name UNIQUE (name)
) ENGINE=InnoDB;

CREATE TABLE jat_user_group(
	group_id		INT NOT NULL,
	user_id			INT NOT NULL,
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL,
	CONSTRAINT pk_user_group PRIMARY KEY (group_id, user_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES jat_user (id),
	CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES jat_group (id)
) ENGINE=InnoDB;

CREATE TABLE jat_customer(
	id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fist_name
	surname
	birth_date
	gender ENUM('M', 'F')
	actived			
	email			VARCHAR(50) NOT NULL,
	create_date		DATETIME    NOT NULL DEFAULT NOW(), 
	update_date		DATETIME    NOT NULL,
	update_user		VARCHAR(25) NOT NULL,

) ENGINE=InnoDB;

CREATE TABLE jat_customer_contact(

)ENGINE=InnoDB;

CREATE TABLE jat_customer_address(

)ENGINE=InnoDB;

COMMIT;
