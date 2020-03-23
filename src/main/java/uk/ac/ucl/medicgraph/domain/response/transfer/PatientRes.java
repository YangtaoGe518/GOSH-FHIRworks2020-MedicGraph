package uk.ac.ucl.medicgraph.domain.response.transfer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.request.patient.address.Address;
import uk.ac.ucl.medicgraph.domain.request.patient.name.Name;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.IndicatorItem;
import uk.ac.ucl.medicgraph.domain.response.transfer.identifier.IdentifierRes;
import uk.ac.ucl.medicgraph.domain.response.transfer.telecom.TelecomRes;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "patient")
public class PatientRes {
    String id;
    List<IdentifierRes> identifiers;
    List<Name> names;
    List<TelecomRes> telecoms;
    String gender;
    String birthDate;
    List<Address> addresses;
    String maritalStatus;
    List<String> communications;

    List<IndicatorItem> indicators;   // from observation

    public PatientRes(String id, List<IdentifierRes> identifiers, List<Name> names, List<TelecomRes> telecoms, String gender, String birthDate, List<Address> addresses, String maritalStatus, List<String> communications, List<IndicatorItem> indicators) {
        this.id = id;
        this.identifiers = identifiers;
        this.names = names;
        this.telecoms = telecoms;
        this.gender = gender;
        this.birthDate = birthDate;
        this.addresses = addresses;
        this.maritalStatus = maritalStatus;
        this.communications = communications;
        this.indicators = indicators;
    }

    public PatientRes() {
    }
}
