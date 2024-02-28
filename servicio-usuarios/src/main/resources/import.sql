INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES ('ROLE_USER');

INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$BV1fW1cNB3occhx/5sKKVuKSaZ3gl/YLD4n2SEuIlY4QWEn8aQntO', 1, 'Santiago', 'Noguera', 'santi.nog23@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user1', '$2a$10$we/0.AO5TYrb1PS7ltEsIev1sVayNxUNVEB...uic9Iv6SakSJ04u', 1, 'Johela', 'Picón', 'lizecita111@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user2', '$2a$10$VrL5BlrCBBd5bbi7KRRJvuUiZYwX07ZMWdAWpLc16BYFP1yGyQKdW', 0, 'Omar', 'Noguera', 'omano@hotmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user3', '$2a$10$2MauTJiLWptZ/Ho4CdDuGea6PO/XZc.Y4Ns5N9Fwg.xdBHvhmdJxy', 1, 'Sandra', 'Pardo', 'smpardov@gmail.com');

INSERT INTO usuario_roles(usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (3, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (4, 2);