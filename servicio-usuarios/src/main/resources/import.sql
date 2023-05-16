INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES ('ROLE_USER');

INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('admin', '12345', 1, 'Santiago', 'Noguera', 'santi.nog23@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user1', '67890', 1, 'Johela', 'Picón', 'lizecita111@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user2', '09876', 0, 'Omar', 'Noguera', 'omano@hotmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES ('user3', '54321', 1, 'Sandra', 'Pardo', 'smpardov@gmail.com');

INSERT INTO usuario_roles(usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (3, 2);
INSERT INTO usuario_roles(usuario_id, role_id) VALUES (4, 2);