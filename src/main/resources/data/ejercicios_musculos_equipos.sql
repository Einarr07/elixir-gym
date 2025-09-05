-- ========================================
-- Insertar Grupos Musculares
-- ========================================
INSERT INTO grupos_musculares (nombre, descripcion)
VALUES ('Pecho', 'Ejercicios para desarrollar la zona pectoral'),
       ('Espalda', 'Ejercicios para fortalecer la zona dorsal'),
       ('Bíceps', 'Ejercicios para trabajar la parte frontal del brazo'),
       ('Tríceps', 'Ejercicios para trabajar la parte posterior del brazo'),
       ('Hombros', 'Ejercicios para fortalecer deltoides y trapecios'),
       ('Piernas', 'Ejercicios para trabajar cuádriceps e isquiotibiales'),
       ('Glúteos', 'Ejercicios para la parte posterior e inferior del cuerpo'),
       ('Pantorrillas', 'Ejercicios para gemelos y sóleo'),
       ('Abdomen', 'Ejercicios para core y abdominales');

-- ========================================
-- Insertar Equipos
-- ========================================
INSERT INTO equipos (nombre, tipo, estado)
VALUES ('Barra olímpica', 'LIBRE', 'DISPONIBLE'),
       ('Mancuernas', 'LIBRE', 'DISPONIBLE'),
       ('Banco plano', 'MAQUINA', 'DISPONIBLE'),
       ('Máquina de prensa', 'MAQUINA', 'DISPONIBLE'),
       ('Polea', 'MAQUINA', 'DISPONIBLE'),
       ('Colchoneta', 'ACCESORIO', 'DISPONIBLE'),
       ('Paralelas', 'ESTRUCTURA', 'DISPONIBLE'),
       ('Barra fija', 'ESTRUCTURA', 'DISPONIBLE');

-- ========================================
-- Insertar Ejercicios para cada Grupo
-- ========================================

-- PECHO (id_grupo_muscular = 1)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Press de banca', 'Ejercicio básico para pecho con barra', NULL, NULL, 'Barra y banco', 1),
       ('Aperturas con mancuernas', 'Aislamiento de pectorales en banco plano', NULL, NULL, 'Mancuernas', 1),
       ('Fondos en paralelas', 'Trabajo de pecho y tríceps con peso corporal', NULL, NULL, 'Paralelas', 1);

-- ESPALDA (id_grupo_muscular = 2)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Dominadas', 'Ejercicio con peso corporal para dorsal ancho', NULL, NULL, 'Barra fija', 2),
       ('Remo con barra', 'Desarrollo de dorsales y trapecios', NULL, NULL, 'Barra olímpica', 2),
       ('Peso muerto', 'Ejercicio compuesto para espalda baja y glúteos', NULL, NULL, 'Barra olímpica', 2);

-- BÍCEPS (id_grupo_muscular = 3)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Curl con barra', 'Ejercicio básico para los bíceps', NULL, NULL, 'Barra recta o Z', 3),
       ('Curl alternado con mancuernas', 'Trabajo unilateral de bíceps', NULL, NULL, 'Mancuernas', 3),
       ('Curl en predicador', 'Aislamiento de bíceps en banco Scott', NULL, NULL, 'Banco Scott + barra', 3);

-- TRÍCEPS (id_grupo_muscular = 4)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Press francés', 'Ejercicio de aislamiento para tríceps', NULL, NULL, 'Barra Z', 4),
       ('Extensiones en polea', 'Trabajo directo de tríceps con polea alta', NULL, NULL, 'Polea', 4),
       ('Fondos en banco', 'Trabajo con peso corporal para tríceps', NULL, NULL, 'Banco', 4);

-- HOMBROS (id_grupo_muscular = 5)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Press militar', 'Ejercicio compuesto para deltoides', NULL, NULL, 'Barra o mancuernas', 5),
       ('Elevaciones laterales', 'Aislamiento del deltoides medio', NULL, NULL, 'Mancuernas', 5),
       ('Pájaros', 'Trabajo del deltoides posterior', NULL, NULL, 'Mancuernas', 5);

-- PIERNAS (id_grupo_muscular = 6)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Sentadillas', 'Ejercicio compuesto para cuádriceps y glúteos', NULL, NULL, 'Barra olímpica', 6),
       ('Prensa de pierna', 'Trabajo de cuádriceps y glúteos en máquina', NULL, NULL, 'Máquina de prensa', 6),
       ('Zancadas', 'Trabajo unilateral de piernas', NULL, NULL, 'Mancuernas o barra', 6);

-- GLÚTEOS (id_grupo_muscular = 7)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Hip thrust', 'Ejercicio principal para glúteos', NULL, NULL, 'Barra y banco', 7),
       ('Puente de glúteo', 'Ejercicio con peso corporal para glúteos', NULL, NULL, 'Colchoneta', 7),
       ('Patada de glúteo en polea', 'Ejercicio de aislamiento', NULL, NULL, 'Polea baja', 7);

-- PANTORRILLAS (id_grupo_muscular = 8)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Elevación de talones de pie', 'Trabajo de gemelos con peso corporal o carga', NULL, NULL,
        'Mancuernas o máquina', 8),
       ('Elevación de talones sentado', 'Trabajo del sóleo', NULL, NULL, 'Máquina específica', 8);

-- ABDOMEN (id_grupo_muscular = 9)
INSERT INTO ejercicios (nombre, descripcion, video_url, imagen_url, equipo_necesario, id_grupo_muscular)
VALUES ('Crunch abdominal', 'Ejercicio básico para abdominales', NULL, NULL, 'Colchoneta', 9),
       ('Plancha', 'Trabajo isométrico de core', NULL, NULL, 'Colchoneta', 9),
       ('Elevaciones de pierna', 'Trabajo de abdomen inferior', NULL, NULL, 'Barra fija o colchoneta', 9);

-- ========================================
-- Insertar relaciones Ejercicios - Equipos
-- (tabla intermedia: ejercicios_equipos)
-- ========================================

-- Press de banca -> Barra olímpica + Banco plano
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (1, 1),
       (1, 3);

-- Aperturas con mancuernas -> Mancuernas + Banco plano
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (2, 2),
       (2, 3);

-- Fondos en paralelas -> Paralelas
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (3, 7);

-- Dominadas -> Barra fija
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (4, 8);

-- Remo con barra -> Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (5, 1);

-- Peso muerto -> Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (6, 1);

-- Curl con barra -> Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (7, 1);

-- Curl alternado con mancuernas -> Mancuernas
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (8, 2);

-- Curl en predicador -> Banco plano + Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (9, 3),
       (9, 1);

-- Extensiones en polea -> Polea
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (11, 5);

-- Sentadillas -> Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (16, 1);

-- Prensa de pierna -> Máquina de prensa
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (17, 4);

-- Hip thrust -> Banco plano + Barra olímpica
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (19, 3),
       (19, 1);

-- Plancha -> Colchoneta
INSERT INTO ejercicios_equipos (id_ejercicio, id_equipo)
VALUES (26, 6);
