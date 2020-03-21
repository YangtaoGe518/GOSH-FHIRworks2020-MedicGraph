package uk.ac.ucl.medicgraph.domain.request.patient.telecom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telecom {
    private String system;
    private String value;
    private String use;
}
