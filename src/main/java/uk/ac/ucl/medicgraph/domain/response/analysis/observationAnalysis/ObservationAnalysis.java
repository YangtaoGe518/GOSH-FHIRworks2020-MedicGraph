package uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservationAnalysis {
    private Integer total;
    private List<IndicatorItem> indicators;
}
