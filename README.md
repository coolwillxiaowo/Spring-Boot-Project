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

Unit Test with JUnit:

```
open the Unit Test cases, and run as jUnit Test 
```



After that, I used Postman to test the REST API and double checked the API and passin the Json object and check the validity of the JSON object I received.

Testing the REST API functionality with Postman:

```
1. Lunch the Spring boot project and open Postman
1. Testing the valid shipping rules by using the default value I give, for example: GET: localhost:8080/api/validshipping/?title=hi&seller=Walmart&category=1&price=1000
And this should received a response with message true

2. Show/Add/Remove seller from the preapproved list:
GET: localhost:8080/api/seller
POST: localhost:8080/api/seller
DELETE: localhost:8080/api/seller
For POST and DELETE request, passing Json Object in the body, for example : 
{
	"sellerName" : "Sams"
}
and set Content-Type in the headers as application/json

3. Show/Add/Remove category from the preapproved list:
GET: localhost:8080/api/category
POST: localhost:8080/api/category
DELETE: localhost:8080/api/category
For POST and DELETE request, passing Json Object in the body, for example : 
{
	"categoryNumber" : 2
}
and set Content-Type in the headers as application/json

4. Show/Update the minium price rule from the preapproved list:
GET: localhost:8080/api/price
PUT: localhost:8080/api/category

For PUT request, passing Json Object in the body, for example : 
{
	"price" : 10.1
}
and set Content-Type in the headers as application/json

5. Testing the valid shipping rules by using the value you have passed in, for example: GET: localhost:8080/api/validshipping/?title=hi&seller=Sams&category=2&price=10.2

```



## Documentation

The services also implemented swagger-ui to provide readable UI for the administrator. To access the UI, after lunching the service, go to:

http://localhost:8080/swagger-ui.html#/

