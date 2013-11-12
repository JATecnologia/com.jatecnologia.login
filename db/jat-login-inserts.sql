DELETE FROM jat_user_group;

DELETE FROM jat_group;

DELETE FROM jat_user;

INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'administrator@jatecnologia.com', SYSDATE(), 'root' );
INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('alexandre.magno', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'alexandre.magno@jatecnologia.com', SYSDATE(), 'root' );
INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('jorge.filho', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'jorge.filho@jatecnologia.com', SYSDATE(), 'root' );

INSERT INTO jat_group (name, email, update_date, update_user) VALUES ('Administrators', 'administrators@jatecnologia.com', SYSDATE(), 'root');
INSERT INTO jat_group (name, email, update_date, update_user) VALUES ('Developers', 'developers@jatecnologia.com', SYSDATE(), 'root');

INSERT INTO jat_user_group (group_id, user_id, update_date, update_user) VALUES ((SELECT id FROM jat_group WHERE name = 'Administrators'), (SELECT id FROM jat_user WHERE login = 'admin'), SYSDATE(), 'root');
INSERT INTO jat_user_group (group_id, user_id, update_date, update_user) VALUES ((SELECT id FROM jat_group WHERE name = 'Developers'), (SELECT id FROM jat_user WHERE login = 'alexandre.magno'), SYSDATE(), 'root');
INSERT INTO jat_user_group (group_id, user_id, update_date, update_user) VALUES ((SELECT id FROM jat_group WHERE name = 'Developers'), (SELECT id FROM jat_user WHERE login = 'jorge.filho'), SYSDATE(), 'root');



