package uk.ac.ucl.medicgraph.domain.response.analysis.addressAnalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressAnalysis {
    private List<AddressItem> addresses;
}
