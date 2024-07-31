CREATE TABLE festival (
  id_festival INT PRIMARY KEY,
  nombre VARCHAR(50),
  fecha DATE,
  localizacion VARCHAR(100)
);

CREATE TABLE grupo (
  cif VARCHAR(10) PRIMARY KEY,
  nombre VARCHAR(50),
  genero VARCHAR(30),
  integrantes SMALLINT(9),
  id_festival INT,
  FOREIGN KEY (id_festival) REFERENCES festival(id_festival)
);

INSERT INTO festival VALUES (1001, 'Hijos del Rock and Roll', '2023-07-25', 'Madrid');

INSERT INTO grupo VALUES ('A1234', 'Metallica', 'Metal', 4, 1001);
INSERT INTO grupo VALUES ('B5678', 'Pink Floyd', 'Rock', 4, 1001);
INSERT INTO grupo VALUES ('C9012', 'Pantera', 'Metal', 4, 1001);
INSERT INTO grupo VALUES ('D3456', 'Scorpions', 'Rock', 4, 1001);
INSERT INTO grupo VALUES ('E7890', 'Red Hot Chili Peppers', 'Rock', 4, 1001);
INSERT INTO grupo VALUES ('F9019', 'Miguel Rios', 'Rock', 1, 1001);
INSERT INTO grupo VALUES ('G0020', 'BMTH', 'Metal', 4, 1001);
INSERT INTO grupo VALUES ('H1222', 'Kiss', 'Rock', 4, 1001);

