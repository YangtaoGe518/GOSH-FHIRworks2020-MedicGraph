package uk.ac.ucl.medicgraph.domain.patient.maritalStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.Coding;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaritalStatus {
    private List<Coding> coding;
    private String text;
}
