# GOSH-FHIRworks2020-MedicGraph

> A Java Spring API package for analyzing, graph, and data transform to CSV or XML


This file explains the problem statement, proposed solution and all the other detail required to familiarise with the
bundle of MedicGraph API.

## Problem Statement
My topic is **Graphing data from FHIR records** in different analysis perspectives

In the modern society, medical assistance and medical services are highly demanded since the expansion of amount of population 
and growing value of average life time. However, the number of medical staff and qualified doctors do not match the pace 
of growing speed. Those medical staff need to analysis more medical records than before to give suitable medical suggestions

Also, medical scientists requires more human-readable and intuitive data representation to produce investigations for the 
future medical trend. For example, if they have the data of the average age of getting heart attack, they could design better
treatment solutions to prevent or mitigate the diseases.

Overall, two barriers are listed below which MedicGraph tends to tackle:
* Lack of visualization against time period for the individual patient
* Lack of visualization for representing the herd behaviours of some diseases

## Proposed Solution
In order to solve the problems we stated above, I decided to develop a API provider booted on Spring boot called MedicGraph
for plot graphs for the frontend

This API bundle has these following key features:
* Functions:
    * Analysis of the average age with percentage for specific health condition
    * Analysis of the location of patients on the map
    * Analysis of the medical condition of one patient within a time period
    * Generate patient data in CSV and XML format
* Other Features: 
    * Interactive API document by Swagger for developers to operate
    * Easy to change the data sources for all data implemented in FHIR standard
    
## How to deploy
This API provider bundle is built on Spring Boot along with its dependencies, hence `Java` and `maven` is required for running it.

In order to operate this bundle on your local machine:

* Clone this GitHub repository by
```
git clone https://github.com/YangtaoGe518/GOSH-FHIRworks2020-MedicGraph.git
```
* Redirect to the directory `./src/main/resources/appication.properties` and change the data source you want to use 
(default is using `localhost:5001` current testing api provided by FHIR hackathon)
```
uk.ac.ucl.medic-graph.datasource: {data url you want to get from}
```
* To build the project by
```
mvn clean package
```
* Then run the package on `localhost:8080` by
```
mvn spring-boot:run
```

