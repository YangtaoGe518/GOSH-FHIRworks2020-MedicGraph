package uk.ac.ucl.medicgraph.domain.patient.extension.extensionContent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.extension.Extension;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueString extends Extension {
    private String valueString;
}
