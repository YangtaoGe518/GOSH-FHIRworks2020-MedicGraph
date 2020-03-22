package uk.ac.ucl.medicgraph.domain.request.observation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.request.Coding;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Observation {
    private String id;
    private String resourceType;
    private List<Category> category;
    private Code code;
    private Subject subject;
    private String effectiveDateTime;
    private String issued;
    private ValueQuantity valueQuantity;

}
