package uk.ac.ucl.medicgraph.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.EntryWrap;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.domain.response.analysis.AgeAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.SexAnalysis;
import uk.ac.ucl.medicgraph.service.AnalysisService;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AnalysisImpl implements AnalysisService {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Override
    public AgeAnalysis generateAgeAnalysis() throws Exception{
        return null;
    }

    @Override
    public SexAnalysis generateSexAnalysis() throws Exception {
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Patient>> patientListViews = gson.fromJson(json, patientListType);

        int total = 0;
        int female = 0;
        int male = 0;

        for(ListView<Patient> listView: patientListViews){
            List<EntryWrap<Patient>> entries = listView.getEntry();

            for(EntryWrap<Patient> entry: entries){
                String gender = entry.getResource().getGender();

                if (gender.equals("female")){
                    female++;
                } else if(gender.equals("male")){
                    male++;
                } else{
                    throw new Exception("Sex: Error Type");
                }
                total++;
            }
        }

        return new SexAnalysis(total, female, male);
    }
}
