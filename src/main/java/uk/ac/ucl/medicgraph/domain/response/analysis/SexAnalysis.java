package uk.ac.ucl.medicgraph.domain.response.analysis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SexAnalysis {
    private Integer total;
    private Integer femaleCount;
    private Integer maleCount;
}
