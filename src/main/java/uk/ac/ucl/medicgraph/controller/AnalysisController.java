package uk.ac.ucl.medicgraph.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Analysis Controller", tags = {"Analysis Controller"})
@RequestMapping(value = "/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/patients/age")
    @ApiOperation(value = "Analysis the age of patients with their corresponding number")
    public AgeAnalysis getAgeAnalysis() throws Exception{
        return analysisService.generateAgeAnalysis();
    }

    @GetMapping("/patients/sex")
    @ApiOperation(value = "Analysis the gender of patients with their corresponding number")
    public SexAnalysis getSexAnalysis() throws Exception{
        return analysisService.generateSexAnalysis();
    }

    @GetMapping("/patients/country")
    @ApiOperation(value = "Analysis the address (Country) of patients with their corresponding number")
    public AddressAnalysis getCountryAnalysis() throws Exception{
        return analysisService.generateCountryAnalysis();
    }

    @GetMapping("/observation/{pid}")
    @ApiOperation(value = "Analysis the patient health indicator history of a patient with their corresponding value")
    public ObservationAnalysis getAllObservationAnalysis(
            @PathVariable("pid") String id) throws Exception {
        return analysisService.generateAllObservationAnalysis(id);
    }

    @GetMapping("/observation/{pid}/{indicator-id}")
    @ApiOperation(value = "Analysis the patient health indicator history of a patient with their corresponding value with specific indicator id")
    public ObservationAnalysis getSingleObservationAnalysis(
            @PathVariable("pid") String pId,
            @PathVariable("indicator-id") String indicatorId) throws Exception{
        return analysisService.generateSingleObservationAnalysis(pId, indicatorId);
    }

}
