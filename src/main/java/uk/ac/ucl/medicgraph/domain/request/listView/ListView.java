package uk.ac.ucl.medicgraph.domain.request.listView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListView<T>{
    private String id;
    private String resourceType;
    private List<EntryWrap<T>> entry;

}
