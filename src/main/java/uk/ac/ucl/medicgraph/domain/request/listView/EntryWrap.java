package uk.ac.ucl.medicgraph.domain.request.listView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryWrap<T>{
    private String fullUrl;
    private T resource;
}
