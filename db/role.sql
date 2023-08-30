drop table roles;

CREATE TABLE roles(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(20),
    priority INT
);

INSERT INTO roles(name, priority)
VALUES
('SUPER_ADMIN', 1),
('ADMIN', 2),
('USER', 3);