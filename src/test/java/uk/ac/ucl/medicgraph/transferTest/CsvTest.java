package uk.ac.ucl.medicgraph.transferTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;

@SpringBootTest
public class CsvTest {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Test
    public void testConvertToCsv(){

    }
}
