CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(100),
  password VARCHAR(255) Not Null
);
