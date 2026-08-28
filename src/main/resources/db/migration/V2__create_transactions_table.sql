CREATE TYPE transaction_type AS ENUM ('INCOME', 'EXPENSE');

CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    type varchar(10) NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_transaction_category FOREIGN KEY (category_id) REFERENCES categories(id)
);