package uk.ac.ucl.medicgraph.domain.response.analysis.ageAnalysis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeItem {
    private String interval;
    private Integer num;
}
