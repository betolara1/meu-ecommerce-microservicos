CREATE TABLE inventory (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(255) UNIQUE,
    quantity INTEGER,
    status VARCHAR(255), -- Mapeado do Enum Status (AVAILABLE, RESERVED, OUT_OF_STOCK)
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
