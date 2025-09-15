-- ========================================
-- Insertar Entrenamientos
-- ========================================
INSERT INTO entrenamientos (nombre, descripcion, nivel, duracion_semanas)
VALUES ('Full Body Principiante', 'Rutina básica de cuerpo completo para iniciar en el gimnasio', 'PRINCIPIANTE', 8),
        ('Hipertrofia Intermedio', 'Rutina enfocada en aumento de masa muscular', 'INTERMEDIO', 12),
        ('Definición Avanzado', 'Entrenamiento de alta intensidad para definición muscular', 'AVANZADO', 10),
        ('Fuerza 5x5', 'Programa clásico de fuerza con ejercicios compuestos pesados', 'INTERMEDIO', 12),
        ('Cardio & Resistencia', 'Entrenamiento combinado de carrera, bicicleta y HIIT', 'PRINCIPIANTE', 6),
        ('Push Pull Legs', 'División semanal por empuje, tirón y piernas para hipertrofia', 'AVANZADO', 14),
        ('Entrenamiento Funcional', 'Rutina con enfoque en movilidad, coordinación y fuerza funcional', 'INTERMEDIO', 10);
-- ========================================
-- Insertar historial de entrenamiento
-- ========================================
-- Laura (id_usuario = 4) -> Full Body Principiante
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (1, 4, '2025-09-06', NULL, FALSE);

-- Diego (id_usuario = 5) -> Hipertrofia Intermedio
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (2, 5, '2025-09-06', NULL, FALSE);

-- Sofia (id_usuario = 6) -> Cardio & Resistencia (completado)
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (5, 6, '2025-07-01', '2025-08-15', TRUE);

-- Luis (id_usuario = 7) -> Definición Avanzado
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (3, 7, '2025-09-06', NULL, FALSE);

-- Camila (id_usuario = 8) -> Entrenamiento Funcional
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (7, 8, '2025-09-06', NULL, FALSE);

-- Javier (id_usuario = 9) -> Fuerza 5x5
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (4, 9, '2025-09-06', NULL, FALSE);

-- Valentina (id_usuario = 10) -> Push Pull Legs
INSERT INTO historial_entrenamientos (id_entrenamiento, id_usuario, fecha_inicio, fecha_fin, completado)
VALUES (6, 10, '2025-09-06', NULL, FALSE);
