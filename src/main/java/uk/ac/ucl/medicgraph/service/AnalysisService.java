package uk.ac.ucl.medicgraph.service;

import uk.ac.ucl.medicgraph.domain.response.analysis.AgeAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.SexAnalysis;

public interface AnalysisService {
    public AgeAnalysis generateAgeAnalysis() throws Exception;
    public SexAnalysis generateSexAnalysis() throws Exception;
}
