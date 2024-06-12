CREATE TABLE IF NOT EXISTS movie (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(1000),
    image_url VARCHAR(1000),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS auditorium (
    id INT NOT NULL AUTO_INCREMENT,
    seat INT NOT NULL,
    imax BOOLEAN,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS projection (
    id INT NOT NULL AUTO_INCREMENT,
    id_auditorium INT NOT NULL,
    id_movie INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_movie FOREIGN KEY (id_movie) REFERENCES movie(id),
    CONSTRAINT fk_auditorium FOREIGN KEY (id_auditorium) REFERENCES auditorium(id)
);