DROP TABLE IF EXISTS procedures;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(200)                 NOT NULL,
  email            VARCHAR(100)                 NOT NULL,
  password         VARCHAR(64)                 NOT NULL,
  registered       TIMESTAMP DEFAULT now()      NOT NULL,
  role             VARCHAR(20) DEFAULT 'ROLE_USER' NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE procedures
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(200),
  specialist       VARCHAR(255),
  price            NUMERIC(20,2),
--   date
  date             VARCHAR(20),
  room             INTEGER,
  CONSTRAINT procedures_unique_idx UNIQUE (specialist, date, room)
);