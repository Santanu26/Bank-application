DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE customer (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  mobile_number VARCHAR(255) NOT NULL,
  create_dt DATE
);

CREATE TABLE account (
  account_number BIGINT PRIMARY KEY,
  customer_id INT NOT NULL,
  account_type VARCHAR(255) NOT NULL,
  branch_address VARCHAR(255) NOT NULL,
  create_dt DATE
);

INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('John Doe', 'johndoe@example.com', '1234567890', '2023-05-18');
INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('Santanu', 'santanu@example.com', '1234567890', '1999-05-18');
INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('Bill', 'bill@example.com', '34392874', '2022-05-18');
INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('elon', 'elon@example.com', '1234567890', '2023-05-18');
INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('shone', 'shone@example.com', '1234567890', '1989-05-18');
INSERT INTO customer (name, email, mobile_number, create_dt) VALUES ('Younus', 'younus@example.com', '123423567890', '1980-05-18');

INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (65776872344, 1, 'Sales', '123 Main Street', '2023-05-18');
INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (12645812744, 2, 'Savings', '123 Main Street', '1999-05-18');
INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (12987082417, 3, 'Savings', '123 asd Street', '2022-05-18');
INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (12498712324, 4, 'Savings', '123 vvd Street', '2023-05-18');
INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (34590348754, 5, 'Savings', '123 gsf Street', '2023-05-18');
INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt) VALUES (34958734573, 6, 'Savings', '123 Main Street', '2023-05-18');
