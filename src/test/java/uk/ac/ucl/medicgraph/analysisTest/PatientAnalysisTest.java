package uk.ac.ucl.medicgraph.analysisTest;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.models.auth.In;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.ucl.medicgraph.config.DataSourceConfig;
import uk.ac.ucl.medicgraph.domain.request.listView.EntryWrap;
import uk.ac.ucl.medicgraph.domain.request.listView.ListView;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.domain.request.patient.address.Address;
import uk.ac.ucl.medicgraph.domain.request.patient.communication.Communication;
import uk.ac.ucl.medicgraph.domain.request.patient.communication.Language;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class PatientAnalysisTest {
    @Autowired
    DataSourceConfig dataSourceConfig;


    @Test
    public void testSexOne() throws Exception{
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/pages/1";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Patient>> patientListView = gson.fromJson(json, patientListType);

        List<EntryWrap<Patient>> entries = patientListView.get(0).getEntry();

        int total = 0;
        int female = 0;
        int male = 0;

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

        System.out.println(total);
        System.out.println(female);
        System.out.println(male);
    }

    @Test
    public void testSexMulti() throws Exception{
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

        System.out.println(total);
        System.out.println(female);
        System.out.println(male);
    }

    @Test
    public void testAge() throws Exception {
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

        System.out.println(ageList);
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

    @Test
    public void testLanguage() throws Exception{
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/";

        Type patientListType = new TypeToken<List<ListView<Patient>>>(){}.getType();

        String json = HttpRequest.requestJson(url);
        Gson gson = new Gson();

        List<ListView<Patient>> patientListViews = gson.fromJson(json, patientListType);

        Map<String, Integer> languageMap = new HashMap<>();


        for(ListView<Patient> listView: patientListViews) {
            List<EntryWrap<Patient>> entries = listView.getEntry();

            for (EntryWrap<Patient> entry : entries) {
                List<Communication> communications = entry.getResource().getCommunications();

                if(communications == null) continue;

                for (Communication communication : communications){
                    String language = communication.getLanguage().getText();

                    if(!languageMap.containsKey(language)){
                        languageMap.put(language, 1);
                    } else {
                        languageMap.put(language, languageMap.get(language) + 1);
                    }
                }
            }
        }

        System.out.println(languageMap);
    }

    @Test
    public void testAddress(){
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

        System.out.println(addressMap);



    }





}
