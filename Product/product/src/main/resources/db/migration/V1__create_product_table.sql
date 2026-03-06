CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    description VARCHAR(255),
    price NUMERIC(10, 2),
    category_id BIGINT,
    image_url VARCHAR(255),
    active BOOLEAN NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
