CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(100),
  href VARCHAR(255) DEFAULT '',
  image_src VARCHAR(255),
  image_alt VARCHAR(255),
  price DECIMAL(10, 2) NOT NULL
);
