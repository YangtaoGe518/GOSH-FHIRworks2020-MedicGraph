package uk.ac.ucl.medicgraph.domain.response.analysis.ageAnalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeAnalysis {
    List<AgeItem> ages;
}
