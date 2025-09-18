-- ========================================
-- Insertar Clases
-- ========================================
INSERT INTO clases(nombre, descripcion, nivel, duracion, capacidad_max)
VALUES
    ('Dragon Fit', 'Clase para los amantes del deporte', 'PRINCIPIANTE', 50, 10),

    ('Cardio Power', 'Entrenamiento cardiovascular de intensidad moderada', 'INTERMEDIO', 45, 15),

    ('Fuerza Total', 'Rutina enfocada en el aumento de fuerza y resistencia muscular', 'AVANZADO', 60, 12),

    ('Yoga Flow', 'Clase de yoga para mejorar flexibilidad y concentración', 'PRINCIPIANTE', 40, 20),

    ('Cross Training', 'Entrenamiento funcional de alta intensidad', 'AVANZADO', 55, 15),

    ('Baile Fit', 'Entrenamiento aeróbico con ritmos latinos', 'INTERMEDIO', 50, 18),

    ('Pilates Core', 'Clase para fortalecer el core y mejorar la postura', 'PRINCIPIANTE', 45, 12),

    ('HIIT Express', 'Entrenamiento intervalado de alta intensidad en corto tiempo', 'AVANZADO', 30, 10),

    ('Box Training', 'Clase de boxeo recreativo con enfoque en técnica y cardio', 'INTERMEDIO', 50, 14),

    ('Stretch & Relax', 'Sesión de estiramiento y relajación guiada', 'PRINCIPIANTE', 35, 20);

-- ========================================
-- Insertar horarios
-- ========================================
INSERT INTO horarios_clases (fecha_clase, hora_inicio, hora_fin, id_clase, id_usuario)
VALUES
    ('2025-09-20', '08:00:00', '08:50:00', 1, 2), -- Dragon Fit con entrenador 2
    ('2025-09-20', '09:30:00', '10:15:00', 2, 3), -- Cardio Power con entrenador 3
    ('2025-09-20', '10:30:00', '11:30:00', 3, 2), -- Fuerza Total con entrenador 2
    ('2025-09-21', '07:00:00', '07:40:00', 4, 3), -- Yoga Flow con entrenador 3
    ('2025-09-21', '08:00:00', '08:55:00', 5, 2), -- Cross Training con entrenador 2
    ('2025-09-21', '09:00:00', '09:50:00', 6, 3), -- Baile Fit con entrenador 3
    ('2025-09-22', '08:00:00', '08:45:00', 7, 2), -- Pilates Core con entrenador 2
    ('2025-09-22', '09:00:00', '09:30:00', 8, 3), -- HIIT Express con entrenador 3
    ('2025-09-22', '10:00:00', '10:50:00', 9, 2), -- Box Training con entrenador 2
    ('2025-09-22', '11:00:00', '11:35:00', 10, 3); -- Stretch & Relax con entrenador 3
