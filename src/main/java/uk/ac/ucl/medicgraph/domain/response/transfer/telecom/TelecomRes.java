package uk.ac.ucl.medicgraph.domain.response.transfer.telecom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelecomRes {
    private String type;
    private String value;
}
