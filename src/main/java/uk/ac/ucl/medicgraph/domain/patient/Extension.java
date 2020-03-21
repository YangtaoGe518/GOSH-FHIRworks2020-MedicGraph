package uk.ac.ucl.medicgraph.domain.patient;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Extension<T> {
    private String url;
    @SerializedName(value = "extension", alternate = {"valueDecimal"})
    private List<T> extension;
}
