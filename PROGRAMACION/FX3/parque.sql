drop database if exists JurassicPark;
create database JurassicPark;
use JurassicPark;
CREATE TABLE Dinosaurio (
    id_dino INT,
    nombre VARCHAR(50),
    tamanyo VARCHAR(20),
    alimentacion VARCHAR(20),
    tipo VARCHAR(10),
    CONSTRAINT Dinosaurio_PK PRIMARY KEY (id_dino)
);
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (1, 'Guillemsaurio', 'grande', 'carnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (2, 'Yagorrex', 'mediano', 'omnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (3, 'Arellanorraptor', 'mediano', 'omnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (4, 'Lucapholis', 'grande', 'herbivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (5, 'Brullminus', 'peque', 'omnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (6, 'Fajardocus', 'peque', 'carnivoro', 'aire');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (7, 'Alacoterix', 'grande', 'omnivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (8, 'Alvesaurio', 'mediano', 'herbivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (9, 'Cesaroptero', 'mediano', 'herbivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (10, 'Agustinodocus', 'peque', 'herbivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (11, 'Barberasaurio', 'mediano', 'carnivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (12, 'Isaactopodo', 'grande', 'omnivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (13, 'SanAndriurrex', 'mediano', 'omnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (14, 'Ivanpholus', 'grande', 'omnivoro', 'aire');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (15, 'Abellantrix', 'peque', 'carnivoro', 'aire');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (16, 'Pablorraptor', 'peque', 'herbivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (17, 'Marcgidus', 'mediano', 'herbivoro', 'aire');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (18, 'Ronalephius', 'mediano', 'herbivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (19, 'Mariodiazelus', 'peque', 'carnivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (20, 'Hugorrexus', 'grande', 'omnivoro', 'agua');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (21, 'SaurarioRex', 'grande', 'carnivoro', 'tierra');
INSERT INTO Dinosaurio (id_dino, nombre, tamanyo, alimentacion, tipo) VALUES (22, 'Carlostrius', 'mediano', 'omnivoro', 'tierra');
CREATE TABLE Zona (
    id_zona INT,
    nombre VARCHAR(50),
    ubicacion VARCHAR(20),
    CONSTRAINT Zona_PK PRIMARY KEY (id_zona)
);
INSERT INTO Zona (id_zona, nombre, ubicacion) VALUES (1, 'WhiteMont', 'norte');
INSERT INTO Zona (id_zona, nombre, ubicacion) VALUES (2, 'StartSea', 'este');
INSERT INTO Zona (id_zona, nombre, ubicacion) VALUES (3, 'ArgentDesert', 'sur');
INSERT INTO Zona (id_zona, nombre, ubicacion) VALUES (4, 'SunBeach', 'oeste');
CREATE TABLE Atraccion (
    id_atraccion INT,
    id_zona INT NOT NULL,
    id_dino INT,
    nombre VARCHAR(50),
    capacidad INT,
    edad_minima INT,
    CONSTRAINT Atraccion_PK PRIMARY KEY (id_atraccion),
    FOREIGN KEY (id_zona) REFERENCES Zona (id_zona),
    FOREIGN KEY (id_dino) REFERENCES Dinosaurio (id_dino)
);

