package uk.ac.ucl.medicgraph.patientTest;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.patient.Patient;
import uk.ac.ucl.medicgraph.util.HttpRequest;

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

        System.out.println(patient.getAddresses());


    }
}
