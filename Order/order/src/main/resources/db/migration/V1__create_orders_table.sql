CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT,
    order_date TIMESTAMP,
    status VARCHAR(255), -- Mapeado do Enum Status
    total_amount NUMERIC(10, 2),
    shipping_address VARCHAR(255),
    sku VARCHAR(255),
    quantity INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
