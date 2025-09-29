-- students
INSERT INTO tb_student (name, email) VALUES ('João Silva', 'joao@email.com');
INSERT INTO tb_student (name, email) VALUES ('Maria Oliveira', 'maria@email.com');
INSERT INTO tb_student (name, email) VALUES ('Carlos Souza', 'carlos@email.com');

-- courses
INSERT INTO tb_course (name, description) VALUES ('Java Básico', 'Introdução à programação em Java');
INSERT INTO tb_course (name, description) VALUES ('Spring Boot', 'Construindo APIs com Spring Boot');
INSERT INTO tb_course (name, description) VALUES ('SQL Avançado', 'Consultas complexas e modelagem');

-- registrations
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (1, 1, '2025-09-01');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (1, 2, '2025-09-05');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (2, 3, '2025-09-10');
