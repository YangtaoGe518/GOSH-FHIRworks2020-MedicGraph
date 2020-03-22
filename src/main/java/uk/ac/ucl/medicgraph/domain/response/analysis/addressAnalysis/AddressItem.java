package uk.ac.ucl.medicgraph.domain.response.analysis.addressAnalysis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressItem {
    private String name;
    private Integer num;
}
