package uk.ac.ucl.medicgraph.domain.request.patient.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {
    private Type type;
    private String system;
    private String value;

}
