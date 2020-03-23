package uk.ac.ucl.medicgraph.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.domain.response.analysis.addressAnalysis.AddressAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.ageAnalysis.AgeAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.SexAnalysis;
import uk.ac.ucl.medicgraph.domain.response.analysis.observationAnalysis.ObservationAnalysis;
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

    @GetMapping("/patients/country")
    public AddressAnalysis getCountryAnalysis() throws Exception{
        return analysisService.generateCountryAnalysis();
    }

    @GetMapping("/observation/{pid}")
    public ObservationAnalysis getAllObservationAnalysis(
            @PathVariable("pid") String id) throws Exception {
        return analysisService.generateAllObservationAnalysis(id);
    }

    @GetMapping("/observation/{pid}/{indicator-id}")
    public ObservationAnalysis getSingleObservationAnalysis(
            @PathVariable("pid") String pId,
            @PathVariable("indicator-id") String indicatorId) throws Exception{
        return analysisService.generateSingleObservationAnalysis(pId, indicatorId);
    }

}
