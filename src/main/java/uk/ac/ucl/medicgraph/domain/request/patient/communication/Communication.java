package uk.ac.ucl.medicgraph.domain.request.patient.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Communication {
    private Language language;
}
