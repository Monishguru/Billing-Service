# Getting Started

This service is to generate the DHL Billing

### Reference Documentation


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## Data Models to For the Endpoints 

http://localhost:9002/billing/generateBill

{
    "customerId": 1,
	"shipmentSource": "Bangalore",
    "shipmentDestination": "Malaysia",
    "distance": 2456,
	"shipmentWeight": 5,
    "shipmentPriority": "High"

}
