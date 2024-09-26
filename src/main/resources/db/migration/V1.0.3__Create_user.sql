CREATE TABLE users
(
    id       BIGINT                   NOT NULL,
    name     VARCHAR(20)              NOT NULL,
    password VARCHAR(255)             NOT NULL,
    salt     VARCHAR(10)              NOT NULL,
    created  TIMESTAMP with time zone NOT NULL,
    version  INTEGER,
    role_id  BIGINT                   NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_name UNIQUE (name);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES user_role (id);