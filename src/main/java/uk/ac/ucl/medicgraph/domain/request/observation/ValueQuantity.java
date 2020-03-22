package uk.ac.ucl.medicgraph.domain.request.observation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueQuantity {
    private Double value;
    private String unit;
    private String system;
    private String code;
}
