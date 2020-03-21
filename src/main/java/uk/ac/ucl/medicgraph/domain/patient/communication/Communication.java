package uk.ac.ucl.medicgraph.domain.patient.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Communication {
    private Language language;
}
