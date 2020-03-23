package uk.ac.ucl.medicgraph.controller;

import lombok.Data;
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
    public String getPatientInfoInXml(@PathVariable("pid") String pId) throws Exception{
        return transferService.generateXmlPatientInfo(pId);
    }

}
