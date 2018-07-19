create database Proyecto 

use proyecto

create table historial(
id_historial int primary key,
id_cuadroclinico int,
fecha date)

create table cuadro_clinico(
id_cuadroclinico int primary key,
unidad_medica varchar(30),
fecha_elabo date,
id_paciente int,
tipo_interrogatorio )

create table pacientes(
id_paciente int primary key,
nombre varchar(30),
apellido_p varchar(30),
apellido_m varchar(30
edad int,
sexo varchar(15),
temperatura varchar(5),
frecuencia_cardiaca varchar(10),
frecuencia_respiratoria(10),
talla varchar(5),
peso varchar(5),
tension_arterial (5))

create table medicos(
id_medico int primary key,
nombre varchar(30),
apellido_p varchar(30),
apellido_m varchar(30),
especialidad varchar(20),
direccion varchar(30),
correo varchar(30),
celular varchar(30),
telefono varchar(30))

create table prescripcion(
id_prescripcion int primary key,
id_medico int,
fecha date,
medicamento varchar(30),
dosis varchar(30),
frecuencia(30),
recomendacion (100))

create table usuarios_med(
id_usuario int primary key,
id_medico int,
usuario varchar(30)
contraseña varchar(30))



select * from historial
