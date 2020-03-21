package uk.ac.ucl.medicgraph.domain.request.patient;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.request.patient.address.Address;
import uk.ac.ucl.medicgraph.domain.request.patient.communication.Communication;
import uk.ac.ucl.medicgraph.domain.request.patient.identifier.Identifier;
import uk.ac.ucl.medicgraph.domain.request.patient.maritalStatus.MaritalStatus;
import uk.ac.ucl.medicgraph.domain.request.patient.name.Name;
import uk.ac.ucl.medicgraph.domain.request.patient.telecom.Telecom;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String id;
//    @SerializedName(value = "extension")
//    private List<Extension> extensions;
    @SerializedName(value = "identifier")
    private List<Identifier> identifiers;
    @SerializedName(value = "name")
    private List<Name> names;
    @SerializedName(value = "telecom")
    private List<Telecom> telecoms;
    private String gender;
    private String birthDate;
    @SerializedName(value = "address")
    private List<Address> addresses;
    private MaritalStatus maritalStatus;
    @SerializedName(value = "communication")
    private List<Communication> communications;


}
