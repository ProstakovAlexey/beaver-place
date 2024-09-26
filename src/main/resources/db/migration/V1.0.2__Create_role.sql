CREATE TABLE user_role
(
    id   BIGINT NOT NULL,
    name VARCHAR(20),
    CONSTRAINT pk_user_role PRIMARY KEY (id)
);

ALTER TABLE user_role
    ADD CONSTRAINT uc_user_role_name UNIQUE (name);

INSERT INTO user_role (id, name) VALUES (1, 'admin');
INSERT INTO user_role (id, name) VALUES (2, 'user');