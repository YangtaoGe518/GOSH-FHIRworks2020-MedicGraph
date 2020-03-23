package uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorItem {
    private String indicator;
    private String issuedTime;
    private Double value;
    private String unit;
}
