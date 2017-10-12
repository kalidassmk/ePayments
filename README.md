# ePayments

This example application is the money transfer application, This is a way of architecting highly scalable and available applications that is based on microservices, Asynchronus, and Non Blocking I/O
Applications consist of loosely coupled components that communicate Aysnchronus way.

# About the example application

This example application provides a REST API for creating and viewing bank accounts and transferring money between them.

There are the following  services:

* Accounts Service - REST API for creating accounts
* Transactions Service - REST API for transferring money
* Transaction Details View Service  - REST API for Transaction Detail view for the particular transaction Id are whole transaction based on the account number.
* Account Details View Service  - REST API for Account Detail view for the particular account number or customer all accounts.

# Building and running the microservices

This is a Maven project.
However, you do not need to install Maven since it will be downloaded automatically.
You just need to have Java 8 installed.

Quick start
-----------
1. `mvn package`
2. `java -jar target/epayments-0.0.1-SNAPSHOT.jar`
3. `use the post man to test the below API's`
4. `base path http://localhost:8080/user`


## Resources

  Method  | Path                   |     request payload                        
|-------- |----------------------- |------------------------------------------------------------------------------  |
| POST    | /openAccount/          |     {"customerId":"cust2","description":"saving account","initialBalance":"500","customerInfo":{"phoneNumber":"123456","passportNo":"12345","dateOfBirth":"10/10/1980","name":{"title":"MR","firstName":"Kalidass","lastName":"Mahalingam"}}} |                     
| POST    | /transferAmount/       | {"fromaccountNo": "2697417013674780903","toaccountNo":"165971006424816748","description":"family expenses", "amount":"100"}                           |
| POST    | /getTransActionDetail/ |  {"customerId": "cust1","accountNo":"2697417013674780903", "transactionId":"1434501849526944895"}                           |
| POST    | /getAccountDetail/     |   {"customerId": "cust2","accountNo":"4325866734929543833"}                          |




