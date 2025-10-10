-- students
INSERT INTO tb_student (name, email) VALUES ('João Silva', 'joao@email.com');
INSERT INTO tb_student (name, email) VALUES ('Maria Oliveira', 'maria@email.com');
INSERT INTO tb_student (name, email) VALUES ('Carlos Souza', 'carlos@email.com');
INSERT INTO tb_student (name, email) VALUES ('Ana Costa', 'ana.costa@email.com');
INSERT INTO tb_student (name, email) VALUES ('Pedro Lima', 'pedro.lima@email.com');
INSERT INTO tb_student (name, email) VALUES ('Fernanda Alves', 'fernanda.alves@email.com');
INSERT INTO tb_student (name, email) VALUES ('Lucas Rocha', 'lucas.rocha@email.com');
INSERT INTO tb_student (name, email) VALUES ('Juliana Reis', 'juliana.reis@email.com');
INSERT INTO tb_student (name, email) VALUES ('Bruno Mendes', 'bruno.mendes@email.com');
INSERT INTO tb_student (name, email) VALUES ('Mariana Torres', 'mariana.torres@email.com');

-- courses
INSERT INTO tb_course (name, description) VALUES ('Java Básico', 'Introdução à programação em Java');
INSERT INTO tb_course (name, description) VALUES ('Spring Boot', 'Construindo APIs com Spring Boot');
INSERT INTO tb_course (name, description) VALUES ('SQL Avançado', 'Consultas complexas e modelagem');
INSERT INTO tb_course (name, description) VALUES ('Python para Iniciantes', 'Fundamentos de Python e automação de tarefas');
INSERT INTO tb_course (name, description) VALUES ('Git e GitHub', 'Controle de versão e colaboração em projetos');

-- registrations
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (1, 1, '2025-09-01');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (1, 2, '2025-09-05');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (2, 3, '2025-09-10');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (3, 1, '2025-09-12');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (3, 4, '2025-09-15');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (4, 5, '2025-09-18');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (5, 2, '2025-09-19');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (5, 3, '2025-09-20');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (6, 1, '2025-09-22');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (6, 4, '2025-09-25');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (7, 2, '2025-09-28');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (7, 5, '2025-09-30');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (8, 3, '2025-10-01');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (8, 1, '2025-10-02');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (9, 4, '2025-10-03');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (9, 5, '2025-10-04');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (10, 2, '2025-10-05');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (10, 3, '2025-10-06');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (10, 4, '2025-10-07');
INSERT INTO tb_registration (student_id, course_id, registration_date) VALUES (10, 5, '2025-10-08');
