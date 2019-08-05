# springboot-customer-service
RESTful service built with Spring Boot 2.x

A sample RESTful customer service built with Spring boot 2.0.6 , JPA and JDK 8.
It shows how to build the RESTful endpoint to manupulate with two entities Customer and Account which are connected via one-to-many relationship.

## How to start

Clone the repository to local. In customer-service folder, run mvnw spring-boot:run to start the application.
## The RESTful services

* /customers HTTP Get # Get all customers
* /customers HTTP Post # Create a new customer
* /customers/{customerId} HTTP Get # Get a customoer
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

