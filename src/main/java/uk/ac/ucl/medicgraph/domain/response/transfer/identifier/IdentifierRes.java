package uk.ac.ucl.medicgraph.domain.response.transfer.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentifierRes {
    private String type;
    private String value;
}
