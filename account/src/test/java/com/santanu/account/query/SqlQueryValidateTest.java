package com.santanu.account.query;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SqlQueryValidateTest {

    private static final String DROP_TABLE_STR = "DROP TABLE IF EXISTS ";
    private static final String CREATE_TABLE_CUSTOMER = """
            CREATE TABLE customer (
              customer_id INT PRIMARY KEY AUTO_INCREMENT,
              name VARCHAR(255) NOT NULL,
              email VARCHAR(255),
              mobile_number VARCHAR(255) NOT NULL,
              create_dt DATE
            )""";
    private static final String CREATE_TABLE_ACCOUNT = """
            CREATE TABLE account (
              account_number BIGINT PRIMARY KEY,
              customer_id INT NOT NULL,
              account_type VARCHAR(255) NOT NULL,
              branch_address VARCHAR(255) NOT NULL,
              create_dt DATE
            )""";

    private static final String UPDATE_ACCOUNT = """
                INSERT INTO account (account_number, customer_id, account_type, branch_address, create_dt)
                VALUES (?, ?, ?, ?, ?)
            """;
    private static final String UPDATE_CUSTOMER = """
                INSERT INTO customer (name, email, mobile_number, create_dt) 
                VALUES (?, ?, ?, ?)
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateTables() {
        jdbcTemplate.execute(DROP_TABLE_STR + "customer");
        jdbcTemplate.execute(DROP_TABLE_STR + "account");

        isTableCreatedSuccessfully(false, CREATE_TABLE_CUSTOMER);
        assertTrue(true, "Customer table creation Successfully");

        isTableCreatedSuccessfully(false, CREATE_TABLE_ACCOUNT);
        assertTrue(true, "Account table creation Successfully");
    }

    private boolean isTableCreatedSuccessfully(boolean tableCreated, String SQL_QUERY) {
        try {
            jdbcTemplate.execute(SQL_QUERY);
            tableCreated = true;
        } catch (Exception e) {
            log.error(SQL_QUERY + " fail. Check the sql", e);
        }
        return tableCreated;
    }

    @Test
    public void testInsertData() {
        String name = "John Doe";
        String email = "johndoe@example.com";
        String mobileNumber = "1234567890";
        LocalDate createDt = LocalDate.parse("2023-05-18");

        int customerInsertCount = jdbcTemplate.update(UPDATE_CUSTOMER, name, email, mobileNumber, createDt);
        assertEquals(1, customerInsertCount, "Customer data insertion Successfully");

        long accountNumber = 999L;
        int customerId = 1001;
        String accountType = "Savings";
        String branchAddress = "123 Main Street";

        int accountInsertCount = jdbcTemplate.update(
                UPDATE_ACCOUNT, accountNumber, customerId, accountType, branchAddress, createDt);
        assertEquals(1, accountInsertCount, "Account data insertion Successfully");
    }
}
