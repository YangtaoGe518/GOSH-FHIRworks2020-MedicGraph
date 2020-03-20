package uk.ac.ucl.medicgraph.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataSourceConfig {
    @Value("${uk.ac.ucl.medic-graph.datasource}")
    private String dataUrl;
}
