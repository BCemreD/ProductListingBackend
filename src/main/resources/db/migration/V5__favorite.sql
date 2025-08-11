CREATE TABLE favorite (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    CONSTRAINT fk_favorite_user FOREIGN KEY (user_id) REFERENCES "users"(id) ON DELETE CASCADE,
    CONSTRAINT fk_favorite_product FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
    CONSTRAINT unique_favorite UNIQUE (user_id, product_id)
);
