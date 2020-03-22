package uk.ac.ucl.medicgraph.domain.request.observation;


import lombok.AllArgsConstructor;
import lombok.Data;
import uk.ac.ucl.medicgraph.domain.request.Coding;

import java.util.List;

@Data
@AllArgsConstructor
public class Category {
    private List<Coding> coding;
}
