package uk.ac.ucl.medicgraph.service;

public interface TransferService {
    public String generateSingleXmlPatientInfo(String pId) throws Exception;
    public String generateMultiXmlPatientInfo() throws Exception;
}
