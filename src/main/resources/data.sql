DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL
  
);

INSERT INTO account (first_name, last_name, password, email)
VALUES
  ('Aliko', 'Dangote', '123456', 'aliko@test.com'),
  ('Bill', 'Gates', '123456', 'bill@test.com'),
  ('Folrunsho', 'Alakija', '123456', 'folrunsho@test.com');