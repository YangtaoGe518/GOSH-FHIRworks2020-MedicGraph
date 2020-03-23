package uk.ac.ucl.medicgraph.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.domain.response.transfer.PatientRes;
import uk.ac.ucl.medicgraph.service.PatientService;

@RestController
@Api(value = "Patient Info Controller", tags = {"Patient Info Controller"})
@RequestMapping(value = "/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/info/{pid}")
    @ApiOperation(value = "Get the patient information of one patient by the patient id")
    public PatientRes getPatientInfo(@PathVariable("pid") String pId){
        return patientService.generatePatientInfo(pId);
    }

    @GetMapping("/original/{pid}")
    @ApiOperation(value = "Get the original FHIR json data of one patient by the patient id")
    public String getPatient(@PathVariable("pid") String pId){
        return patientService.generateOriginalPatient(pId);
    }
}
