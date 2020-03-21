package uk.ac.ucl.medicgraph.patientTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.patient.Patient;
import uk.ac.ucl.medicgraph.domain.patient.extension.Extension;
import uk.ac.ucl.medicgraph.domain.patient.extension.extensionContent.ExtensionList;
import uk.ac.ucl.medicgraph.domain.patient.extension.extensionContent.ValueString;
import uk.ac.ucl.medicgraph.util.HttpRequest;
import uk.ac.ucl.medicgraph.util.RuntimeTypeAdapterFactory;

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

        final TypeToken<Patient> patientTypeToken = new TypeToken<Patient>(){};

//        final RuntimeTypeAdapterFactory<Extension> typeFactory = RuntimeTypeAdapterFactory
//                .of(Extension.class)
//                .registerSubtype(ExtensionList.class ,"extension")
//                .registerSubtype(ValueString.class, "valueString");
//        final Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();

        Gson gson = new Gson();

        Patient patient = gson.fromJson(json, patientTypeToken.getType());

        System.out.println(patient);


    }
}
