package uk.ac.ucl.medicgraph.domain.patient.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private List<Coding> coding;
    private String text;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class Coding{
        private String system;
        private String code;
        private String display;
    }
}
