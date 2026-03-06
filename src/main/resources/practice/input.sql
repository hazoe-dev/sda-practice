DROP TABLE IF EXISTS temp_orders;

CREATE TABLE temp_orders
(
    order_id    INT PRIMARY KEY,
    customer_id INT            NOT NULL,
    amount      DECIMAL(10, 2) NOT NULL,
    order_date  DATE           NOT NULL
);

INSERT INTO temp_orders (order_id, customer_id, amount, order_date)
VALUES (1, 101, 500, '2024-01-05'),
       (2, 102, 300, '2024-01-10'),
       (3, 101, 700, '2024-02-01'),
       (4, 103, 200, '2024-02-15'),
       (5, 102, 800, '2024-03-01'),
       (6, 101, 100, '2024-03-20');