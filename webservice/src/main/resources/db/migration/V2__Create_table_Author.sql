CREATE TABLE author (
  id SERIAL,
  first_name VARCHAR NOT NULL ,
  last_name VARCHAR NOT NULL ,
  age INTEGER ,
  gender VARCHAR ,
  PRIMARY KEY (id)
);