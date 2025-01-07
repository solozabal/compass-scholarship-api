-- Criação das tabelas
CREATE TABLE organizers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE squads (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    squad_id BIGINT,
    FOREIGN KEY (squad_id) REFERENCES squads(id)
);

CREATE TABLE lessons (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL,
    description TEXT,
    squad_id BIGINT NOT NULL,
    FOREIGN KEY (squad_id) REFERENCES squads(id)
);

-- Inserção de dados
INSERT INTO organizers (id, name, role) VALUES (1, 'Alice', 'Coordinator');
INSERT INTO organizers (id, name, role) VALUES (2, 'Bob', 'Instructor');
INSERT INTO organizers (id, name, role) VALUES (3, 'Charlie', 'Scrum Master');

INSERT INTO squads (id, name) VALUES (1, 'Squad A');
INSERT INTO squads (id, name) VALUES (2, 'Squad B');

INSERT INTO students (id, name, email, squad_id) VALUES (1, 'David', 'david@example.com', 1);
INSERT INTO students (id, name, email, squad_id) VALUES (2, 'Eve', 'eve@example.com', 1);
INSERT INTO students (id, name, email, squad_id) VALUES (3, 'Frank', 'frank@example.com', 2);

INSERT INTO lessons (id, title, date, squad_id) VALUES (1, 'Introduction to Java', '2023-01-10 00:00:00', 1);
INSERT INTO lessons (id, title, date, squad_id) VALUES (2, 'Spring Boot Basics', '2023-01-17 00:00:00', 1);
INSERT INTO lessons (id, title, date, squad_id) VALUES (3, 'RESTful APIs', '2023-01-24 00:00:00', 2);