package uk.ac.ucl.medicgraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.service.TransferService;

@RestController
@RequestMapping(value = "/api/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @GetMapping("/xml/{pid}")
    public String getSinglePatientInfoInXml(@PathVariable("pid") String pId) throws Exception{
        return transferService.generateSingleXmlPatientInfo(pId);
    }

    @GetMapping("/xml")
    public String getAllPatientInfoInXml() throws Exception{
        return transferService.generateMultiXmlPatientInfo();
    }

}
