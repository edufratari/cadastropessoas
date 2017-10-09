CREATE TABLE IF NOT EXISTS person(
  id VARCHAR(50) NOT NULL,
  name VARCHAR(100) Not NULL,
  cpf VARCHAR(50) Not NULL,
  rg VARCHAR(50) Not NULL,
  address VARCHAR(100) Not NULL,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  CONSTRAINT person_key PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE person
  OWNER TO postgres;

