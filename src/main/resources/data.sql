-- alunos
INSERT INTO tb_aluno (nome, email) VALUES ('João Silva', 'joao@email.com');
INSERT INTO tb_aluno (nome, email) VALUES ('Maria Oliveira', 'maria@email.com');
INSERT INTO tb_aluno (nome, email) VALUES ('Carlos Souza', 'carlos@email.com');

-- cursos
INSERT INTO tb_curso (nome, descricao) VALUES ('Java Básico', 'Introdução à programação em Java');
INSERT INTO tb_curso (nome, descricao) VALUES ('Spring Boot', 'Construindo APIs com Spring Boot');
INSERT INTO tb_curso (nome, descricao) VALUES ('SQL Avançado', 'Consultas complexas e modelagem');

-- matrículas
INSERT INTO tb_matricula (aluno_id, curso_id, data_matricula) VALUES (1, 1, '2025-09-01');
INSERT INTO tb_matricula (aluno_id, curso_id, data_matricula) VALUES (1, 2, '2025-09-05');
INSERT INTO tb_matricula (aluno_id, curso_id, data_matricula) VALUES (2, 3, '2025-09-10');
