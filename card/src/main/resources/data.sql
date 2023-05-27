DROP TABLE IF EXISTS card;

CREATE TABLE card (
  card_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  card_number VARCHAR(255) NOT NULL,
  card_type VARCHAR(255) NOT NULL,
  total_limit INT NOT NULL,
  amount_used INT NOT NULL,
  available_amount INT NOT NULL,
  create_dt DATE NOT NULL
);

INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) VALUES (1, '1234567890123456', 'VISA', 5000, 2000, 3000, '2023-05-18');
INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) VALUES (2, '1234567890123456', 'VISA', 5000, 2000, 3000, '2023-05-18');
INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) VALUES (3, '1234567890123456', 'VISA', 5000, 2000, 3000, '2023-05-18');
INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) VALUES (4, '1234567890123456', 'VISA', 5000, 2000, 3000, '2023-05-18');
INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) VALUES (5, '1234567890123456', 'VISA', 5000, 2000, 3000, '2023-05-18');
