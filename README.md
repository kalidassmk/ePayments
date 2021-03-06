# ePayments

   This is a sample money transfer application. It has highly scalable,
   asynchronous microservices with loosely coupled compenents that communicate in a non-blocking way.

# About the sample application
  This sample application provides a REST API for creating and viewing bank accounts and transferring money between them.

These are the following services: 

* Accounts Service - REST API for creating accounts
* Transactions Service - REST API for transferring money
* Transaction Details View Service - REST API for detailed view of transaction for a particular transaction Id or for all the transactions based on the account number.
* Account Details View Service - REST API for detailed view of an account for a particular account number or all accounts of a particular customer. 

# Building and running the microservices

This is a Maven project.
However, you do not need to install Maven since it will be downloaded automatically.
You just need to have Java 8 installed.

Quick start
-----------
1. `mvn package`
2. `java -jar target/epayments-0.0.1-SNAPSHOT.jar`
3. `use post man to test the below API's `
4. `Authentication using a X-Auth-Token header for REST APIs`
5. `base path http://localhost:8080`

Steps to Generate X-Auth-Token Header Value
--------------------------------------------
Step 1. `use this API /createUserSession to generate the user session`
Step 2. `once created the user session,  get the sessionId from created session and add to the X-Auth-Token header vlaue`
Step 3. `X-Auth-Token: 123456` 


## Resources

  Method  | Path                   |reqest Header                                      |     request payload                        
|-------- |----------------------- |---------------------------------------------------|------------------------------------------------------------------------------  |
| POST    | /createUserSession/    | Content-Type:application/json                     | {"customerId": "cust2","clientId":"client", "clientSecret":" hello world"} |                     
| POST    | /openAccount/          | X-Auth-Token: 123456,Content-Type:application/json| {"customerId":"cust2","description":"saving account","initialBalance":"500","currencyCode":"EURO","customerInfo":{"phoneNumber":"123456","passportNo":"12345","dateOfBirth":"10/10/1980","name":{"title":"MR","firstName":"Kalidass","lastName":"Mahalingam"}}}|                     
| POST    | /transferAmount/       | X-Auth-Token: 123456,Content-Type:application/json| {"fromaccountNo": "853156270064809678","sourceCurrencyCode":"EURO",  "toaccountNo":"7804361355257525673", "destinationCurrencyCode" :"EURO",   "description":"family expenses", "amount":"100"}|
| POST    | /getTransActionDetail/ | X-Auth-Token: 123456,Content-Type:application/json| {"customerId": "cust1","accountNo":"2697417013674780903", "transactionId":"1434501849526944895"}                           |
| POST    | /getAccountDetail/     | X-Auth-Token: 123456,Content-Type:application/json| {"customerId": "cust2","accountNo":"4325866734929543833"}                          |


## Sequence Diagram

![createUserSession](https://github.com/kalidassmk/ePayments/blob/master/design/createUserSession.png)
![openAccount](https://github.com/kalidassmk/ePayments/blob/master/design/openAccount.png)
![transferAmount](https://github.com/kalidassmk/ePayments/blob/master/design/transferAmount.png)
![getTransActionDetail](https://github.com/kalidassmk/ePayments/blob/master/design/getTransActionDetail.png)
![getAccountDetail](https://github.com/kalidassmk/ePayments/blob/master/design/getAccountDetail.png)



