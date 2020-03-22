package uk.ac.ucl.medicgraph.requestTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.observation.Observation;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.util.List;

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

    @Test
    public void testDeserializeMulti(){
        String url = dataSourceConfig.getDataUrl() + "/api/Observation/aa0c4f0f-6a93-4f65-a9a9-2faf189d24d9";

        Type observationListType = new TypeToken<List<ListView<Observation>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
//        System.out.println(json);


        Gson gson = new Gson();

        List<ListView<Observation>> observationListView = gson.fromJson(json, observationListType);

        System.out.println(observationListView);
    }


}
