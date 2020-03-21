package uk.ac.ucl.medicgraph.domain.patient;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.address.Address;
import uk.ac.ucl.medicgraph.domain.patient.communication.Communication;
import uk.ac.ucl.medicgraph.domain.patient.extension.Extension;
import uk.ac.ucl.medicgraph.domain.patient.identifier.Identifier;
import uk.ac.ucl.medicgraph.domain.patient.maritalStatus.MaritalStatus;
import uk.ac.ucl.medicgraph.domain.patient.name.Name;
import uk.ac.ucl.medicgraph.domain.patient.telecom.Telecom;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String id;
    @SerializedName(value = "extension")
    private List<Extension> extensions;
//    @SerializedName(value = "identifier")
//    private List<Identifier> identifiers;
//    @SerializedName(value = "name")
//    private List<Name> names;
//    @SerializedName(value = "telecom")
//    private List<Telecom> telecoms;
//    private String gender;
//    private String birthDate;
//    @SerializedName(value = "address")
//    private List<Address> addresses;
//    private MaritalStatus maritalStatus;
//    @SerializedName(value = "communication")
//    private List<Communication> communications;


}
