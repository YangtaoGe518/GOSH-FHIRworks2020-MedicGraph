package uk.ac.ucl.medicgraph.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.service.TransferService;

@RestController
@Api(value = "Transfer Controller", tags = {"Transfer Controller"})
@RequestMapping(value = "/api/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @GetMapping("/xml/{pid}")
    @ApiOperation(value = "Generate a xml file based on patient id (pid)")
    public String getSinglePatientInfoInXml(@PathVariable("pid") String pId) throws Exception{
        return transferService.generateSingleXmlPatientInfo(pId);
    }

    @GetMapping("/xml")
    @ApiOperation(value = "Generate all xml files for all patients")
    public String getAllPatientInfoInXml() throws Exception{
        return transferService.generateMultiXmlPatientInfo();
    }

    @GetMapping("/csv")
    @ApiOperation(value = "Generate a csv files for all patients")
    public String getAllPatientInfoInCsv() throws Exception{
        return transferService.generateMultiCsvPatientInfo();

    }

}
