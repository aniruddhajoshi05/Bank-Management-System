# Spring Reactive Case Study - Bank Management System
## 1. Update Account microservice - Spring reactive microservice integrated with R2DBC Mysql used to update the account details of the user.

## To run the project
spring.r2dbc.url=r2dbc:pool:mysql://localhost:3306/userdb

spring.r2dbc.username=root

spring.r2dbc.password=

server.port=8082

Change this credentials according your local

## Postman Api --- Update Account
PUT Request 

Controller - localhost:8082/update-account/{userId}

Router - localhost:8082/fun/update-account/{userId}

Request Body -

{
    "username": "Ani123",
    "password": "1234",
	"name": "Aniruddh Joshi",
	"address": "Park View",
	"state": "Maharashtra",
	"country": "India",
	"emailAddress": "abc@gmail",
	"pan": "12bgh56",
	"contactNumber": "7798753587",
	"dob": "04/03/1998",
	"accountType": "Current"
}

Response - 

{
    "statusCode": 200,
    "status": "OK",
    "id": 1,
    "message": "Account Updated!"
}


## 2. Apply Loan microservice - Spring reactive microservice integrated with R2DBC Mysql used to apply loan and receive loan details from the user.

## To run the project
spring.r2dbc.url=r2dbc:pool:mysql://localhost:3306/userdb

spring.r2dbc.username=root

spring.r2dbc.password=

server.port=8081

Change this credentials according your local

## Postman Api --- Apply Loan
POST Request 

Controller - localhost:8081/loan/apply/{userId}

Request Body -

{
    "loanType":"home",
    "loanAmount":"600000",
    "date":"27/08/2021",
    "rateOfInterest":"7.85",
    "durationOfLoan":"72"
}


Response -   

{​​​​​​​​
"loanId": 2,
"loanType": "home",
"loanAmount": 600000.0,
"date": "27/08/2021",
"rateOfInterest": 7.85,
"durationOfLoan": 72.0,
"userId": 8
}​​​​​​​​

## Postman Api --- Get Loan by loanId
GET Request 

Controller - localhost:8081/loan/{loanId}

Response - 

{​​​​​​​​
"loanId": 2,
"loanType": "home",
"loanAmount": 600000.0,
"date": "27/08/2021",
"rateOfInterest": 7.85,
"durationOfLoan": 72.0,
"userId": 8
}

## Postman Api --- Get Loan Details by loanType
GET Request 

Controller - localhost:8081/loan/type/{loanType}

Response - 

[{​​​​​​​​
"loanId": 2,
"loanType": "home",
"loanAmount": 600000.0,
"date": "27/08/2021",
"rateOfInterest": 7.85,
"durationOfLoan": 72.0,
"userId": 8
}]

## Postman Api --- Get Loan Details by accountId
GET Request 

Controller - localhost:8081/loan/account/{accountId}

Response - 

[{​​​​​​​​
"loanId": 2,
"loanType": "home",
"loanAmount": 600000.0,
"date": "27/08/2021",
"rateOfInterest": 7.85,
"durationOfLoan": 72.0,
"userId": 8
}]
