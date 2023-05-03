INSERT INTO especificaciones_tecnicas(descripcion, componentes) VALUES ('Descripción 1', 'Componentes 1');
INSERT INTO especificaciones_tecnicas(descripcion, componentes) VALUES ('Descripción 2', 'Componentes 2');
INSERT INTO especificaciones_tecnicas(descripcion, componentes) VALUES ('Descripción 3', 'Componentes 3');
INSERT INTO especificaciones_tecnicas(descripcion, componentes) VALUES ('Descripción 4', 'Componentes 4');

INSERT INTO productos(nombre, cantidad, precio, create_at, especificacion_id) VALUES ('Producto 1', 1, 100, NOW(), 1);
INSERT INTO productos(nombre, cantidad, precio, create_at, especificacion_id) VALUES ('Producto 2', 2, 200, NOW(), 2);
INSERT INTO productos(nombre, cantidad, precio, create_at, especificacion_id) VALUES ('Producto 3', 3, 300, NOW(), 3);
INSERT INTO productos(nombre, cantidad, precio, create_at, especificacion_id) VALUES ('Producto 4', 4, 400, NOW(), 4);

INSERT INTO ventas(cantidad, valor, fecha, producto_id) VALUES (10, 1000, NOW(), 1);
INSERT INTO ventas(cantidad, valor, fecha, producto_id) VALUES (20, 2000, NOW(), 2);
INSERT INTO ventas(cantidad, valor, fecha, producto_id) VALUES (30, 3000, NOW(), 3);
INSERT INTO ventas(cantidad, valor, fecha, producto_id) VALUES (40, 4000, NOW(), 4);
INSERT INTO ventas(cantidad, valor, fecha, producto_id) VALUES (50, 5000, NOW(), 3);