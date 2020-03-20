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
		assertEquals("localhost:5001", dataUrl);

		assertEquals("localhost:5001", dataSourceConfig.getDataUrl());
	}

	@Test
	public void testApiRoot(){
		assertEquals("localhost:5001/api/", dataSourceConfig.getDataUrl()+ BaseUrlConfig.root);
	}

}
