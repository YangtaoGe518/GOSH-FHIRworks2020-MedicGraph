package uk.ac.ucl.medicgraph.domain.patient.communication;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.Coding;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    private List<Coding> coding;
    private String text;
}
