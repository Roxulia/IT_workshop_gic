//package com.example.gicws2.demo;

package com.example.gicws2.demo;

import java.sql.Connection;
import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceConfigTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws Exception {
        assertNotNull(dataSource);
        try (Connection conn = dataSource.getConnection()) {
            assertTrue(conn.isValid(2));
            System.out.println("Connected to DB: " + conn.getMetaData().getURL());
        }
    }
}

