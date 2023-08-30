drop table "user";

CREATE Table "user"(
    id BigSerial PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    password varchar(100),
    email VARCHAR(30),
    username VARCHAR(30),
    status BOOLEAN
);

INSERT INTO "user"
(first_name, last_name, email, username, password, status)
VALUES
('dilip', 'thakkar','dilip.thakkar@metacube.com','dilip.thakkar@metacube.com','$2a$10$z187kDFl80eFBLwQWIffD.0Q3gEArrvHQNqJIPus.rS5LdND1VVlS' ,true),
('bhagyesh', 'jain','bhagyesh.jain@metacube.com','bhagyesh.jain@metacube.com','$2a$10$z187kDFl80eFBLwQWIffD.0Q3gEArrvHQNqJIPus.rS5LdND1VVlS',  true),
('manuraj', 'hada','manuraj.hada@metacube.com','manuraj.hada@metacube.com','$2a$10$z187kDFl80eFBLwQWIffD.0Q3gEArrvHQNqJIPus.rS5LdND1VVlS' , false),
('apoorv', 'gehlot','apoorv.gehlot@metacube.com','apoorv.gehlot@metacube.com','$2a$10$z187kDFl80eFBLwQWIffD.0Q3gEArrvHQNqJIPus.rS5LdND1VVlS' , true);
