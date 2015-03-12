--Habitaciones
Create table Habitaciones (
ID_Habitacion Int NOT NULL AUTO_INCREMENT,
Numero_Habitacion Int,
Capacidad Int,
Numero_Ocupantes Int,
Activo Bool,
Unique (Numero_Habitacion),
Primary Key (ID_Habitacion)
);

--Residentes

Create table Residentes (
ID_Residente Int NOT NULL AUTO_INCREMENT,
ID_Habitacion Int NOT NULL,
DNI Char(9),
Nombre Char(40),
Apellidos Char(60),
Sexo Char(1),
Activo Bool,
Unique (DNI),
Primary Key (ID_Residente),
Foreign Key (ID_Habitacion) references Habitaciones (ID_Habitacion) on delete restrict on update restrict
);

-- ResidentesEstudiantes

Create table ResidentesEstudiantes (
ID_Residente Int NOT NULL,
Email Char(40),
Primary Key (ID_Residente),
Foreign Key (ID_Residente) references Residentes (ID_Residente) on delete restrict on update restrict
);

--ResidentesNoEstudiantes

Create table ResidentesNoEstudiantes (
ID_Residente Int NOT NULL,
Telefono Int,
Domicilio Char(40),
Primary Key (ID_Residente),
Foreign Key (ID_Residente) references Residentes (ID_Residente) on delete restrict on update restrict
);

--Facturas

Create table Facturas (
ID_Factura Int NOT NULL AUTO_INCREMENT,
ID_Residente Int NOT NULL,
Pagado bool,
Fecha Date,
Cuota Float,
En_metalico Bool,
NumeroCuenta Char(50),
Activo Bool,
Primary Key (ID_Factura),
Foreign Key (ID_Residente) references Residentes (ID_Residente)
);

--HabitacionFactura (Relación n-n)

Create table HabitacionFactura (
ID_Factura Int,
ID_Habitacion Int NOT NULL,
Primary Key (ID_Factura, ID_Habitacion),
Foreign Key (ID_Factura) references Facturas (ID_Factura) on delete restrict on update restrict,
Foreign Key (ID_Habitacion) references Habitaciones (ID_Habitacion) on delete restrict on update restrict
);