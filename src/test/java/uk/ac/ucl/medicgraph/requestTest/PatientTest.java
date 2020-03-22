package uk.ac.ucl.medicgraph.requestTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Test
    public void testDeserializeOne(){
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/b905139e-1601-403c-9d85-f8e3997cdd19";
//        System.out.println(url);
        String json = HttpRequest.requestJson(url);

        Gson gson = new Gson();

        Patient patient = gson.fromJson(json, Patient.class);

        System.out.println(patient);
    }

    @Test
    public void testDeserializeMulti(){
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/pages/1";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
//        System.out.println(json);


        Gson gson = new Gson();

        List<ListView<Patient>> patientListView = gson.fromJson(json, patientListType);

        System.out.println(patientListView);

    }
}
