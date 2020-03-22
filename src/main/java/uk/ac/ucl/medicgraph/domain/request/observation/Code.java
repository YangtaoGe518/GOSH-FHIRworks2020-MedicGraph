package uk.ac.ucl.medicgraph.domain.request.observation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.request.Coding;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
    private List<Coding> coding;
    private String text;
}
