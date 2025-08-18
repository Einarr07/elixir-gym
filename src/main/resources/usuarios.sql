INSERT INTO usuarios (nombre, apellido, email, password, telefono, fecha_nacimiento, peso,
                      altura, fecha_registro, estado_usuario)
VALUES
    ('Martin', 'Mejia', 'martin@example.com', 'password123', '0987564231',
     '1990-01-01', 70.5, 1.75, CURRENT_DATE, TRUE),
    ('Ana', 'Perez', 'ana@example.com', 'password123', '0987654321',
     '1992-05-12', 60.0, 1.65, CURRENT_DATE, TRUE),
    ('Carlos', 'Lopez', 'carlos@example.com', 'password123', '0987654322',
     '1985-03-23', 80.0, 1.80, CURRENT_DATE, TRUE),
    ('Laura', 'Gomez', 'laura@example.com', 'password123', '0987654323',
     '1993-07-15', 55.5, 1.62, CURRENT_DATE, TRUE),
    ('Diego', 'Ramirez', 'diego@example.com', 'password123', '0987654324',
     '1988-11-30', 75.0, 1.78, CURRENT_DATE, TRUE),
    ('Sofia', 'Torres', 'sofia@example.com', 'password123', '0987654325',
     '1995-02-20', 62.0, 1.68, CURRENT_DATE, TRUE),
    ('Luis', 'Martinez', 'luis@example.com', 'password123', '0987654326',
     '1987-09-10', 82.0, 1.82, CURRENT_DATE, TRUE),
    ('Camila', 'Hernandez', 'camila@example.com', 'password123', '0987654327',
     '1991-04-05', 58.0, 1.64, CURRENT_DATE, TRUE),
    ('Javier', 'Vargas', 'javier@example.com', 'password123', '0987654328',
     '1989-06-18', 77.0, 1.77, CURRENT_DATE, TRUE),
    ('Valentina', 'Castro', 'valentina@example.com', 'password123', '0987654329',
     '1994-12-12', 65.0, 1.70, CURRENT_DATE, TRUE)
    ON CONFLICT (email) DO NOTHING;
