# Spring Cloud App
A hypothetical web app which captures username and record button click count against a user name. The entire service is developed in microservice fashion using Spring Cloud. Details of services are as follows: - 

# Prerequisite
- Java 8
- Maven 3.3.9
- MongoDB 3.2.9
- Docker 1.10.3
- Docker-Compose 1.8.1
- Vagrant 

##Services details

- Spring-Eureka – This service act as service discovery and is responsible for keeping a registry of all services.
- Spring-Zuul – This service act as a API gateway or proxy and forward incoming request to the designated services.
- Button-click-web-app – This is the client facing web application built using Spring web and thymeleaf, this service   registers with Eureka and can be deployed in cluster for client side load balancing.
- Button-click-writer – This service is used to capture user button click event and pass it to recorder service to store it in DB, this service registers with Eureka and can be deployed in cluster for client side load balancing.
- Button-click-recorder – This service is used to record user click event and save it to MongoDB, this service registers with Eureka and can be deployed in cluster for client side load balancing.

# Architecture diagram
![Spring-cloud-App.jpeg](https://www.dropbox.com/s/9udbcv3nmhvzifh/Spring-cloud-App.jpeg?dl=0&raw=1)

Note: Please update docker-compose file to map volume for mongodb files 

# How to run (Below command will create a single instances of all the service using docker-compose)

- Move to project directory.
- vagrant up

# If you want to create multiple instances of services then

- vagrant ssh
- cd Spring-cloud-app
- docker-compose scale serviceName={no. Of Instances}
For example, if you want to scale writer service then use
- docker-compose scale writer=2

Now open Eurka page to see all the registered service by using url : localhost:8761.

Open localhost:8080/record-count to open web application and enter your username and click on count button to record click count, open console logs to see the request served by various instances.


