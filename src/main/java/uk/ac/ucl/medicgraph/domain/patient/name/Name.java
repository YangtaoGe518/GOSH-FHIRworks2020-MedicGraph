package uk.ac.ucl.medicgraph.domain.patient.name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    private String use;
    private String family;
    private List<String> given;
    private List<String> prefix;
}
