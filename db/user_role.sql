CREATE TABLE USER_ROLE(

    id BIGSERIAL,
    user_id Int,
    role_id Int
)


insert into USER_ROLE(user_id, role_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(3, 1),
(3, 2),
(3, 3),
(4, 2),
(4, 3);