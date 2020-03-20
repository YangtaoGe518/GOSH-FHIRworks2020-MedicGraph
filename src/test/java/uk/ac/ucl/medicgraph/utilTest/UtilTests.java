package uk.ac.ucl.medicgraph.utilTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;


@SpringBootTest
public class UtilTests {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Test
    public void testHttpRequest(){
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/pages/1";
//        System.out.println(url);
        String json = HttpRequest.requestJson(url);
        System.out.println(json);
    }


}
