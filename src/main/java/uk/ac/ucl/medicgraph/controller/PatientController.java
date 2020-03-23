package uk.ac.ucl.medicgraph.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.domain.request.patient.Patient;
import uk.ac.ucl.medicgraph.domain.response.transfer.PatientRes;
import uk.ac.ucl.medicgraph.service.PatientService;

@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/info/{pid}")
    public PatientRes getPatientInfo(@PathVariable("pid") String pId){
        return patientService.generatePatientInfo(pId);
    }

    @GetMapping("/original/{pid}")
    public String getPatient(@PathVariable("pid") String pId){
        return patientService.generateOriginalPatient(pId);
    }
}
