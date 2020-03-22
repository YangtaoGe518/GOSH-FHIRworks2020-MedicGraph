package uk.ac.ucl.medicgraph.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.config.BaseUrlConfig;
import uk.ac.ucl.medicgraph.domain.response.analysis.AgeAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.SexAnalysis;
import uk.ac.ucl.medicgraph.service.AnalysisService;

@RestController
@RequestMapping(value = "/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/patients/age")
    public AgeAnalysis getAgeAnalysis() throws Exception{
        return analysisService.generateAgeAnalysis();
    }

    @GetMapping("/patients/sex")
    public SexAnalysis getSexAnalysis() throws Exception{
        return analysisService.generateSexAnalysis();
    }

}
