package uk.ac.ucl.medicgraph.domain.patient.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.Extension;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
//    private Extension extension;
    private List<String> line;
    private String city;
    private String state;
    private String country;
}
