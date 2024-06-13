DROP TABLE PRODUCT;
CREATE TABLE Product (
    id INT PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    inventory_status VARCHAR(50) NOT NULL,
    category VARCHAR(100) NOT NULL,
    image VARCHAR(255),
    rating INT
);