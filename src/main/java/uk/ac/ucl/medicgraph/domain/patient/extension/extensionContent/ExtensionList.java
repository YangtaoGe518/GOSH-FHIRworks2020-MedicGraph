package uk.ac.ucl.medicgraph.domain.patient.extension.extensionContent;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.medicgraph.domain.patient.extension.Extension;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtensionList extends Extension {
    private List<Extension> extensions;
}
