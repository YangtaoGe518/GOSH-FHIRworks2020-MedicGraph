package uk.ac.ucl.medicgraph.service;

import uk.ac.ucl.medicgraph.domain.response.transfer.PatientRes;

public interface PatientService {
    public PatientRes generatePatientInfo(String pId);
    public String generateOriginalPatient(String pId);


}
