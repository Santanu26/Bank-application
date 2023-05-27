DROP TABLE IF EXISTS loan;

CREATE TABLE loan (
  loan_number INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  start_dt DATE NOT NULL,
  loan_type VARCHAR(255) NOT NULL,
  total_loan INT NOT NULL,
  amount_paid INT NOT NULL,
  outstanding_amount INT NOT NULL,
  create_dt VARCHAR(255) NOT NULL
);

INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) VALUES (1, '2023-05-18', 'Home Loan', 500000, 200000, 300000, '2023-05-18');
INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) VALUES (1, '2023-05-18', 'Office Loan', 700000, 200000, 500000, '2023-05-18');
INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) VALUES (2, '2023-05-18', 'Office Loan', 700000, 200000, 500000, '2023-05-18');
INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) VALUES (3, '2023-05-18', 'Office Loan', 700000, 200000, 500000, '2023-05-18');
INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) VALUES (4, '2023-05-18', 'Office Loan', 700000, 200000, 500000, '2023-05-18');
