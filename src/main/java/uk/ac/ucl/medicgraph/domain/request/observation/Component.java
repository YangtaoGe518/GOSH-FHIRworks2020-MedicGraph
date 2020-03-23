package uk.ac.ucl.medicgraph.domain.request.observation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Component {
    private Code code;
    private ValueQuantity valueQuantity;
}
