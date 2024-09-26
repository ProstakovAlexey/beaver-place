CREATE TABLE place
(
    id              BIGINT                   NOT NULL,
    created         TIMESTAMP with time zone NOT NULL,
    version         INTEGER,
    photo_file_name TEXT,
    text            TEXT                     NOT NULL,
    latitude        DOUBLE PRECISION         NOT NULL,
    longitude       DOUBLE PRECISION         NOT NULL,
    user_id         BIGINT                   NOT NULL,
    animal_id       BIGINT                   NOT NULL,
    CONSTRAINT pk_place PRIMARY KEY (id)
);

ALTER TABLE place
    ADD CONSTRAINT FK_PLACE_ON_ANIMAL FOREIGN KEY (animal_id) REFERENCES animal (id);

ALTER TABLE place
    ADD CONSTRAINT FK_PLACE_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);