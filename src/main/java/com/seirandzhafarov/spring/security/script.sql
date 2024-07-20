-- сохраняем данные о User -ах в БД без шифрования

CREATE TABLE users (
                       username VARCHAR(15) PRIMARY KEY,
                       password VARCHAR(100),
                       enabled BOOLEAN
);

CREATE TABLE authorities (
                             username VARCHAR(15),
                             authority VARCHAR(25),
                             FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES
    ('zaur', '{noop}zaur', TRUE),
    ('elena', '{noop}elena', TRUE),
    ('ivan', '{noop}ivan', TRUE);

INSERT INTO authorities (username, authority)
VALUES
    ('zaur', 'ROLE_EMPLOYEE'),
    ('elena', 'ROLE_HR'),
    ('ivan', 'ROLE_HR'),
    ('ivan', 'ROLE_MANAGER');
