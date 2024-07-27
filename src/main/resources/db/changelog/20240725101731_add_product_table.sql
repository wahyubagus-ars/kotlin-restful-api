
-- Generated changelog file Timestamp: 20240725101731
-- Filepath: classpath:db/changelog/20240725101731_add_product_table.sql

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(19, 2) NOT NULL
);
