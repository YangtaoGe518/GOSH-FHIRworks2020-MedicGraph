package uk.ac.ucl.medicgraph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MedicGraphApplicationTests {
	@Value("${uk.ac.ucl.medic-graph.datasource}")
	private String dataUrl;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGlobalProps(){
		assertEquals("localhost:5001", dataUrl);
	}

}
