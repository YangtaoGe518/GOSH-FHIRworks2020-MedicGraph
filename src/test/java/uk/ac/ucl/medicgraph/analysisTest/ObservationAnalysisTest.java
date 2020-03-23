package uk.ac.ucl.medicgraph.analysisTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.EntryWrap;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.observation.Observation;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.IndicatorItem;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ObservationAnalysisTest {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Test
    public void testPatientObservation(){
        String url = dataSourceConfig.getDataUrl() + "/api/Observation/aa0c4f0f-6a93-4f65-a9a9-2faf189d24d9";

        Type observationType = new TypeToken<List<ListView<Observation>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Observation>> observationListViews = gson.fromJson(json, observationType);

        List<IndicatorItem> indicatorList = new ArrayList<>();

        for(ListView<Observation> listView : observationListViews){
            List<EntryWrap<Observation>> entries = listView.getEntry();

            for(EntryWrap<Observation> entry : entries){
                Observation observation = entry.getResource();

                String indicator = observation.getCode().getText();
                String issuedTime = observation.getIssued();
//                Double value = observation.getValueQuantity().getValue();
//                String unit = observation.getValueQuantity().getUnit();

//                IndicatorItem indicatorItem = new IndicatorItem(indicator, issuedTime, value, unit);
                IndicatorItem indicatorItem = new IndicatorItem(indicator, issuedTime, 0.0, "test");
                indicatorList.add(indicatorItem);
            }
        }

        System.out.println(indicatorList);
    }
}
