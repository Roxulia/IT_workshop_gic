//package com.example.gicws2.demo;

package com.example.gicws2.demo;

import java.sql.Connection;
import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceConfigTests {

    @Autowired
    @Qualifier("mainDataSource")
    private DataSource mainDataSource;

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDataSource;

    @Test
    void testMainDataSources() {
        assertNotNull(mainDataSource, "Main DataSource should not be null");
    }

    @Test
    void testSecondaryDataSources() {

        assertNotNull(secondaryDataSource, "Secondary DataSource should not be null");

    }

    @Test
    void testMultipleDataSources() {
        assertNotEquals(mainDataSource, secondaryDataSource, "DataSources should be different");
    }
}

