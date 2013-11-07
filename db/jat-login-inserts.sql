DELETE FROM jat_user_group;

DELETE FROM jat_group;

DELETE FROM jat_user;


INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'administrator@jatecnologia.com', SYSDATE(), 'root' );
INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('alexandre.magno', '732002cec7aeb7987bde842b9e00ee3b', 'alexandre.magno@jatecnologia.com', SYSDATE(), 'root' );
INSERT INTO jat_user (login, password, email, update_date, update_user) VALUES ('jorge.filho', '732002cec7aeb7987bde842b9e00ee3b', 'jorge.filho@jatecnologia.com', SYSDATE(), 'root' );

INSERT INTO jat_group (name, email, update_date, update_user) VALUES ('Administrators', 'administrators@jatecnologia.com', SYSDATE(), 'root');
INSERT INTO jat_group (name, email, update_date, update_user) VALUES ('Developers', 'developers@jatecnologia.com', SYSDATE(), 'root');


INSERT INTO jat_user_group (name_group, user_login, update_date, update_user) VALUES ('Administrators', 'admin', SYSDATE(), 'root');
INSERT INTO jat_user_group (name_group, user_login, update_date, update_user) VALUES ('Developers', 'alexandre.magno', SYSDATE(), 'root');
INSERT INTO jat_user_group (name_group, user_login, update_date, update_user) VALUES ('Developers', 'jorge.filho', SYSDATE(), 'root');

