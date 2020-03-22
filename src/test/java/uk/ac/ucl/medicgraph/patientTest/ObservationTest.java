package uk.ac.ucl.medicgraph.patientTest;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.observation.Observation;
import uk.ac.ucl.medicgraph.domain.request.observation.Subject;
import uk.ac.ucl.medicgraph.util.HttpRequest;

@SpringBootTest
public class ObservationTest {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Test
    public void testDeserializeOne(){
        String url = dataSourceConfig.getDataUrl() + "/api/Observation/single/7806cd39-99ce-4f21-9d36-bf4a9b7fd12d";
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Gson gson = new Gson();

        Observation observation = gson.fromJson(json, Observation.class);

        System.out.println(observation);

    }


}
