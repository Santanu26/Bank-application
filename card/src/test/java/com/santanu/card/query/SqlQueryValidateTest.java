package com.santanu.card.query;

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
    private static final String CREATE_TABLE_CARD = """
            CREATE TABLE card (
              card_id INT PRIMARY KEY AUTO_INCREMENT,
              customer_id INT NOT NULL,
              card_number VARCHAR(255) NOT NULL,
              card_type VARCHAR(255) NOT NULL,
              total_limit INT NOT NULL,
              amount_used INT NOT NULL,
              available_amount INT NOT NULL,
              create_dt DATE NOT NULL
            )
            """;
    private static final String UPDATE_CARD = """
               INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt)
                VALUES (?, ?, ?, ?, ?,?, ?)
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateTables() {
        jdbcTemplate.execute(DROP_TABLE_STR + "card");

        isTableCreatedSuccessfully(false, CREATE_TABLE_CARD);
        assertTrue(true, "Card table card Successfully");
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
    public void testInsertCard() {
        int customerId = 123;
        String cardNumber = "1234567890123456";
        String cardType = "VISA";
        int totalLimit = 5000;
        int amountUsed = 2000;
        int availableAmount = 3000;
        String createDt = "2023-05-18";

        String sql = "INSERT INTO card (customer_id, card_number, card_type, total_limit, amount_used, available_amount, create_dt) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        int rowsAffected = jdbcTemplate.update(sql, customerId, cardNumber, cardType, totalLimit, amountUsed, availableAmount, createDt);

        assertEquals(1, rowsAffected, "Expected one row to be inserted");
    }


}
