package uk.ac.ucl.medicgraph.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.EntryWrap;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.observation.Component;
import uk.ac.ucl.medicgraph.domain.request.observation.Observation;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.domain.request.patient.address.Address;
import uk.ac.ucl.medicgraph.domain.response.analysis.addressAnalysis.AddressAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.addressAnalysis.AddressItem;
import uk.ac.ucl.medicgraph.domain.response.analysis.ageAnalysis.AgeAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.SexAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.ageAnalysis.AgeItem;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.IndicatorItem;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.ObservationAnalysis;
import uk.ac.ucl.medicgraph.service.AnalysisService;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnalysisImpl implements AnalysisService {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Override
    public AgeAnalysis generateAgeAnalysis() throws Exception{
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Patient>> patientListViews = gson.fromJson(json, patientListType);

        Integer[] ages = new Integer[10];  // 10 as an interval
        Arrays.fill(ages, 0);

        for(ListView<Patient> listView: patientListViews) {
            List<EntryWrap<Patient>> entries = listView.getEntry();

            for (EntryWrap<Patient> entry : entries) {
                String birthDate = entry.getResource().getBirthDate();
                int age = calcAge(birthDate);

                if(age >=0 && age < 10) ages[0]++;
                if(age >=10 && age < 20) ages[1]++;
                if(age >=20 && age < 30) ages[2]++;
                if(age >=30 && age < 40) ages[3]++;
                if(age >=40 && age < 50) ages[4]++;
                if(age >=50 && age < 60) ages[5]++;
                if(age >=60 && age < 70) ages[6]++;
                if(age >=70 && age < 80) ages[7]++;
                if(age >=80 && age < 90) ages[8]++;
                if(age >=90) ages[9]++;
            }
        }

        List<Integer> ageList = Arrays.asList(ages);

        List<AgeItem> itemList= new ArrayList<>();

        Integer interval = 0;
        for(Integer age: ageList){
            Integer min = interval;
            Integer max = interval+10;

            StringBuilder sb = new StringBuilder();
            sb.append(min);
            sb.append(" to ");
            sb.append(max);
            String intervalSir = sb.toString();


            AgeItem item;
            if(max <= 90){
                item = new AgeItem(intervalSir, age);
            }else{
                item = new AgeItem("90 Above", age);
            }
            itemList.add(item);


            interval += 10;

        }


        return new AgeAnalysis(itemList);
    }

    private Integer calcAge(String birthday) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = df.parse(birthday);
        Calendar now = Calendar.getInstance();
        Calendar born = Calendar.getInstance();

        now.setTime(new Date());
        born.setTime(birth);

        if(born.after(now)){
            throw new IllegalArgumentException("Can't be born in the future");
        }

        int age = now.get(Calendar.YEAR)-born.get(Calendar.YEAR);
        if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
            age -= 1;
        }
        return age;
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

    @Override
    public AddressAnalysis generateCountryAnalysis() throws Exception {
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Patient>> patientListViews = gson.fromJson(json, patientListType);

        Map<String, Integer> addressMap = new HashMap<>();


        for(ListView<Patient> listView: patientListViews) {
            List<EntryWrap<Patient>> entries = listView.getEntry();

            for (EntryWrap<Patient> entry : entries) {
                List<Address> addresses = entry.getResource().getAddresses();
//
                if (addresses == null) continue;
//
                for(Address address : addresses){
                    String country = address.getCountry();
//
                    if(!addressMap.containsKey(country)){
                        addressMap.put(country, 1);
                    }else {
                        addressMap.put(country, addressMap.get(country) + 1);
                    }
                }
//
            }
        }

        List<AddressItem> addresses = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: addressMap.entrySet()){
            AddressItem item = new AddressItem(entry.getKey(), entry.getValue());

            addresses.add(item);
        }

        return new AddressAnalysis(addresses);
    }

    @Override
    public ObservationAnalysis generateAllObservationAnalysis(String id) throws Exception {
        String url = dataSourceConfig.getDataUrl() + "/api/Observation/" + id;

        Type observationType = new TypeToken<List<ListView<Observation>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Observation>> observationListViews = gson.fromJson(json, observationType);

        List<IndicatorItem> indicatorList = new ArrayList<>();

        for(ListView<Observation> listView : observationListViews){
            List<EntryWrap<Observation>> entries = listView.getEntry();

            for(EntryWrap<Observation> entry : entries){
                Observation observation = entry.getResource();

                String issuedTime = observation.getIssued();

                List<Component> components = observation.getComponents();
                if (observation.getValueQuantity() != null){
                    String indicator = observation.getCode().getText();
                    Double value = observation.getValueQuantity().getValue();
                    String unit = observation.getValueQuantity().getUnit();

                    IndicatorItem indicatorItem = new IndicatorItem(indicator, issuedTime, value, unit);
                    indicatorList.add(indicatorItem);
                } else if (components != null) {
                    for(Component component : components){
                        String indicator = component.getCode().getText();
                        Double value = component.getValueQuantity().getValue();
                        String unit = component.getValueQuantity().getUnit();

                        IndicatorItem indicatorItem = new IndicatorItem(indicator, issuedTime, value, unit);
                        indicatorList.add(indicatorItem);
                    }
                }

            }
        }

        return new ObservationAnalysis(indicatorList.size(), indicatorList);
    }
}
