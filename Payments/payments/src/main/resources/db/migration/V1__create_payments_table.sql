CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT UNIQUE,
    transaction_id VARCHAR(255) UNIQUE,
    payment_date TIMESTAMP,
    status VARCHAR(255), -- Mapeado do Enum Status
    amount NUMERIC(10, 2),
    payment_method VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
