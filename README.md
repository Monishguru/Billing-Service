# Billing-Service
Sample Microservice to Generate bill value and tracking id.

# For education purpose

# How to Start your application 

mvn clean install

spring-boot:run

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
