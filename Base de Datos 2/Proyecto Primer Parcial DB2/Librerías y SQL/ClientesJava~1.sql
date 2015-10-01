CREATE TABLE Cliente
(
  IdCliente INTEGER NOT NULL,
  Nombre VARCHAR(50),
  Apellido VARCHAR(50),
  Direccion VARCHAR(70),
  Fecha_nacimiento date,
  PRIMARY KEY (IdCliente)
);

CREATE TABLE Proveedor
(
  IdProveedor INTEGER NOT NULL,
  Nombre VARCHAR(50),
  Direccion VARCHAR(70),
  PRIMARY KEY (IdProveedor)
);

CREATE TABLE Producto
(
  IdProducto INTEGER NOT NULL,
  Nombre VARCHAR(50),
  Precio NUMBER(10),
  IdProveedor INTEGER NOT NULL,
  PRIMARY KEY (IdProducto),
  CONSTRAINT fk_proveedor
  FOREIGN KEY (IdProveedor)
  REFERENCES Proveedor(IdProveedor)
);

CREATE TABLE ClienteProducto
(
  IdCliente INTEGER NOT NULL,
  IdProducto INTEGER NOT NULL,
  CONSTRAINT cp_pk PRIMARY KEY (IdCliente, IdProducto),
  CONSTRAINT fk_cliente
  FOREIGN KEY (IdCliente)
  REFERENCES Cliente(IdCliente),
  CONSTRAINT fk_producto
  FOREIGN KEY (IdProducto)
  REFERENCES Producto(IdProducto)
);

COMMIT;

ALTER SESSION SET NLS_DATE_FORMAT = 'dd/mm/yyyy';

INSERT INTO Cliente VALUES(1, 'Angel Santiago', 'Jaime Zavala', 'Padua #325, Roma', '28/10/1992');
INSERT INTO Proveedor VALUES(1, 'Ibanez', 'North Hill #34, CA, EU');
INSERT INTO Producto VALUES(1, 'Ibanez s470', 5000.00, 1);
INSERT INTO ClienteProducto VALUES(1, 1);

SELECT * FROM Cliente;
SELECT * FROM Proveedor;
SELECT * FROM Producto;
SELECT * FROM ClienteProducto;

COMMIT;
