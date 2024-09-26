CREATE TABLE animal
(
    id   BIGINT NOT NULL,
    name VARCHAR(20),
    CONSTRAINT pk_animal PRIMARY KEY (id)
);

ALTER TABLE animal
    ADD CONSTRAINT uc_animal_name UNIQUE (name);

INSERT INTO animal (id, name)
VALUES (1, 'beaver');
INSERT INTO animal (id, name)
VALUES (2, 'duck');