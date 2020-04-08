# User Manual

## Install

Follow these step to install locally:

```
1. Unzip ValidShipping.zip
2. Open Eclipse STS/Intellij IDEA --> Import Maven Project --> select ValidShipping
```

The project is built under JavaSE - 1.8, please make sure to use compliance from execution environment 'JavaSE-1.8' on the Java Build Path

#### IDE

Chose your preferred IDE such as Eclipse Spring Tool Suite or IntelliJ IDEA or some other IDE you prefer. 



## Project Description and Assumptions Made

Based on the client requirment, this project mainly have two functionalities. First functionality is the main goal, which is a REST API that identifies whether or not an item is eligible for the new eBay shipping program.

Second Functionality is exposing configurable items (Shipping Rules) through some REST APIs that could be used as a basis for browser based tooling for eBay administrators to make changes to those rules. These configurable items includes the Seller Rules(seller qualified to enroll the shipping program), Category Rules(pre-approved category), and Price Rule. For price rule, I made an assumption that the approved price is greater or equal to a certain amount.

After the project is finised, I implemented Junit test and Mokito to test the service layer and the Spring Rest Controller and passed all the test cases I implemented.

After that, I used Postman to test the REST API and double checked the API and passin the Json object and check the validity of the JSON object I received.

## Documentation

The services also implemented swagger-ui to provide readable UI for the administrator. To access the UI, after lunching the service, go to:

http://localhost:8080/swagger-ui.html#/

