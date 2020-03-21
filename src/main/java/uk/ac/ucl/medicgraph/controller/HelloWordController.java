package uk.ac.ucl.medicgraph.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.medicgraph.domain.Hello;

@RestController
@RequestMapping(value = "/hello")
@Api(value = "Hello World Controller", tags = {"Hello World Controller"})
public class HelloWordController {

    @GetMapping("/{name}")
    @ApiOperation(value = "Test path variable")
    public Hello sayHelloTo(@PathVariable("name") String name){
        Hello hello = new Hello(name, ", Nice to meet you");
        return hello;
    }
}
