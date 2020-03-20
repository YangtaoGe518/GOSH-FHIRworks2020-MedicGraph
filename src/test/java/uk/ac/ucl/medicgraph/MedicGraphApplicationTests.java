package uk.ac.ucl.medicgraph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.BaseUrlConfig;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MedicGraphApplicationTests {
	@Value("${uk.ac.ucl.medic-graph.datasource}")
	private String dataUrl;

	@Autowired
	private DataSourceConfig dataSourceConfig;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGlobalProps(){
		assertEquals("http://localhost:5000", dataUrl);

		assertEquals("http://localhost:5000", dataSourceConfig.getDataUrl());
	}

	@Test
	public void testApiRoot(){
		assertEquals("http://localhost:8080/api/", "http://localhost:8080" + BaseUrlConfig.root);
	}

}
