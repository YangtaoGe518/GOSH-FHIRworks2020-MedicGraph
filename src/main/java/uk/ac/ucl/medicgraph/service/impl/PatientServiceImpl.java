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
import uk.ac.ucl.medicgraph.domain.request.patient.communication.Communication;
import uk.ac.ucl.medicgraph.domain.request.patient.identifier.Identifier;
import uk.ac.ucl.medicgraph.domain.request.patient.name.Name;
import uk.ac.ucl.medicgraph.domain.request.patient.telecom.Telecom;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.IndicatorItem;
import uk.ac.ucl.medicgraph.domain.response.transfer.PatientRes;
import uk.ac.ucl.medicgraph.domain.response.transfer.identifier.IdentifierRes;
import uk.ac.ucl.medicgraph.domain.response.transfer.telecom.TelecomRes;
import uk.ac.ucl.medicgraph.service.PatientService;
import uk.ac.ucl.medicgraph.util.HttpRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Override
    public PatientRes generatePatientInfo(String pId) {

        String patientUrl = dataSourceConfig.getDataUrl() + "/api/Patient/" + pId;
        String observationUrl = dataSourceConfig.getDataUrl() + "/api/Observation/" + pId;

        String patientJson = HttpRequest.requestJson(patientUrl);
        String observationJson = HttpRequest.requestJson(observationUrl);
        Gson gson = new Gson();

        Patient patient = gson.fromJson(patientJson, Patient.class);

        Type observationType = new TypeToken<List<ListView<Observation>>>(){}.getType();
        List<ListView<Observation>> observationListViews = gson.fromJson(observationJson, observationType);

        // id
        String id = patient.getId();
        // identifiers
        List<IdentifierRes> identifiers = new ArrayList<>();
        for(Identifier identifier : patient.getIdentifiers()){

            if(identifier.getType() == null){
                continue;
            }

            String type = identifier.getType().getText();
            String value = identifier.getValue();

            identifiers.add(new IdentifierRes(type, value));
        }
        // name
        List<Name> names = patient.getNames();
        // telecom
        List<TelecomRes> telecoms = new ArrayList<>();
        for(Telecom telecom : patient.getTelecoms()){
            String type = telecom.getUse();
            String value = telecom.getValue();

            telecoms.add(new TelecomRes(type, value));
        }
        // gender
        String gender = patient.getGender();
        // birth date
        String birthDate = patient.getBirthDate();
        // Address
        List<Address> addresses = patient.getAddresses();
        // marital
        String maritalStatus = patient.getMaritalStatus().getText();
        // Communication
        List<String> communications = new ArrayList<>();
        for(Communication communication : patient.getCommunications()){
            String language = communication.getLanguage().getText();
            communications.add(language);
        }

        // observation
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


        PatientRes patientInfo = new PatientRes(
                id,
                identifiers,
                names,
                telecoms,
                gender,
                birthDate,
                addresses,
                maritalStatus,
                communications,
                indicatorList
        );


        return patientInfo;
    }

    @Override
    public String generateOriginalPatient(String pId) {
        String url = dataSourceConfig.getDataUrl() + "/api/Patient/" + pId;
        String json = HttpRequest.requestJson(url);


        return json;
    }
}
