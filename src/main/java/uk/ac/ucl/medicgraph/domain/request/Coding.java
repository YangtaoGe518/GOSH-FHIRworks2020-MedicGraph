package uk.ac.ucl.medicgraph.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coding {
    private String system;
    private String code;
    private String display;
}
