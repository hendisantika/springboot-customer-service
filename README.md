# springboot-customer-service
RESTful service built with Spring Boot 2.x

A sample RESTful customer service built with Spring boot 2.0.6 , JPA and JDK 8.
It shows how to build the RESTful endpoint to manupulate with two entities Customer and Account which are connected via one-to-many relationship.

## How to start
1. Clone the repository to local: `git clone https://github.com/hendisantika/springboot-customer-service.git`.
2. In customer-service folder: `cd springboot-customer-service`, 
3. Run the app: `mvnw clean spring-boot:run` to start the application.
## The RESTful services

* /customers HTTP Get # Get all customers
* /customers HTTP Post # Create a new customer
* /customers/{customerId} HTTP Get # Get a customer
* /customers/{customerId} HTTP Delete # Delete a customer
* /customers/{customerId} HTTP Put # Update an existing customer
* /customers/{customerId}/accounts HTTP Post #Create an account for a customer
* /customers/{customerId}/accounts HTTP Get #Get accounts from a customer
* /customers/{customerId}/accounts/{accountId} HTTP Delete # Delete an account from a customer
* /customers/{customerId}/accounts/{accountId} HTTP Put # Update an account from a customer

## RESTful service examples
### Find all customers
```
$ curl -s -G http://localhost:8080/api/customers | json_pp
{
   "sort" : {
      "unsorted" : true,
      "sorted" : false
   },
   "first" : true,
   "last" : true,
   "content" : [
      {
         "customerName" : "Uzumaki Naruto",
         "phoneNumber" : "+610452623758",
         "dateofBirth" : "1980-03-16",
         "customerId" : 1
      },
      {
         "phoneNumber" : "+610452623798",
         "customerName" : "Uchiha Sasuke",
         "customerId" : 2,
         "dateofBirth" : "1985-03-16"
      }
   ],
   "numberOfElements" : 2,
   "number" : 0,
   "totalElements" : 2,
   "pageable" : {
      "unpaged" : false,
      "pageSize" : 20,
      "paged" : true,
      "offset" : 0,
      "pageNumber" : 0,
      "sort" : {
         "unsorted" : true,
         "sorted" : false
      }
   },
   "size" : 20,
   "totalPages" : 1
}
```

### Find all customers with sorting
```
$ curl -s -G http://localhost:8080/api/customers?sort=customerId,desc | json_pp
{
   "totalElements" : 2,
   "number" : 0,
   "numberOfElements" : 2,
   "content" : [
      {
         "phoneNumber" : "+610452623798",
         "dateofBirth" : "1985-03-16",
         "customerId" : 2,
         "customerName" : "Uchiha Sasuke"
      },
      {
         "dateofBirth" : "1980-03-16",
         "phoneNumber" : "+610452623758",
         "customerId" : 1,
         "customerName" : "Uzumaki Naruto"
      }
   ],
   "size" : 20,
   "sort" : {
      "unsorted" : false,
      "sorted" : true
   },
   "totalPages" : 1,
   "last" : true,
   "first" : true,
   "pageable" : {
      "offset" : 0,
      "pageNumber" : 0,
      "pageSize" : 20,
      "paged" : true,
      "unpaged" : false,
      "sort" : {
         "sorted" : true,
         "unsorted" : false
      }
   }
}
```

### Find all accounts of one customer
```
$  curl -s -G http://localhost:8080/api/customers/1/accounts | json_pp
{
   "pageable" : {
      "offset" : 0,
      "paged" : true,
      "pageNumber" : 0,
      "sort" : {
         "unsorted" : true,
         "sorted" : false
      },
      "pageSize" : 20,
      "unpaged" : false
   },
   "content" : [
      {
         "balance" : 8000,
         "openingDate" : "2016-05-16",
         "accountNumber" : 10881061,
         "accountName" : "Sarutobi Sandaime"
      },
      {
         "accountNumber" : 10881069,
         "accountName" : "Uchiha Madara",
         "openingDate" : "2016-05-16",
         "balance" : 12000
      }
   ],
   "number" : 0,
   "sort" : {
      "sorted" : false,
      "unsorted" : true
   },
   "totalPages" : 1,
   "first" : true,
   "numberOfElements" : 2,
   "size" : 20,
   "last" : true,
   "totalElements" : 2
}
```
### Add a new customer 
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"customerName": "Haruno Sakura","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8080/api/customers/ | json_pp
{
   "dateofBirth" : "1985-03-16",
   "phoneNumber" : "+610452623738",
   "customerName" : "Haruno Sakura",
   "customerId" : 4
}
```
### Add an account of customer Sakura
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"accountNumber": 30981069,"accountName": "gold plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8080/api/customers/3/accounts | json_pp
{
   "balance" : 12000,
   "accountNumber" : 30981069,
   "accountName" : "gold plus",
   "openingDate" : "2016-05-16"
}
```

### Update the new customer Sakura
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"customerName": "Haruno Sakura","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8080/api/customers/3 | json_pp
{
   "phoneNumber" : "+610452623738",
   "customerName" : "Haruno Sakura",
   "dateofBirth" : "1985-03-16",
   "customerId" : 3
}
```
### Update the account of customer Sakura
```
$ curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"accountNumber": 30981069,"accountName": "silver plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8080/api/customers/3/accounts/30981069 | json_pp
{
   "accountName" : "silver plus",
   "openingDate" : "2016-05-16",
   "accountNumber" : 30981069,
   "balance" : 12000
}
```
### Delete the customer Iris and all linked accounts
```
$ curl -s -i -H "Content-Type: application/json;accept: application/json" -X DELETE  http://localhost:8080/api/customers/3/
HTTP/1.1 200
Content-Length: 0
Date: Fri, 23 Nov 2018 05:11:11 GMT
```
