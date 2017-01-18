# Spring Cloud App
A hypothetical web app which captures username and record button click count against a user name. The entire service is developed in microservice fashion using Spring Cloud. Details of services are as follows: - 

# Prerequisite
- Java 8
- Maven 3.3.9
- MongoDB 3.2.9

##Services details

•Spring-Eureka – This service act as service discovery and is responsible for keeping a registry of all services.
•Spring-Zuul – This service act as a API gateway or proxy and forward incoming request to the designated services.
•Button-click-web-app – This is the client facing web application built using Spring web and thymeleaf, this service  registers with Eureka and can be deployed in cluster for client side load balancing.
•Button-click-writer – This service is used to capture user button click event and pass it to recorder service to store it in DB, this service registers with Eureka and can be deployed in cluster for client side load balancing.
•Button-click-recorder – This service is used to record user click event and save it to MongoDB, this service registers with Eureka and can be deployed in cluster for client side load balancing.

# Architecture diagram
![Spring-cloud-App.jpeg](https://www.dropbox.com/s/9udbcv3nmhvzifh/Spring-cloud-App.jpeg?dl=0&raw=1)

# How to run
Clone project from [here](https://github.com/akhil6095/Spring-cloud-app)

- Move to project directory.
- mvn clean package
- Start Eureka, move to Spring-Eureka folder and start it using below command
    `mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
- Start Zuul, mode to Spring-Zuul folder and start it using below command
    `mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
- Start Button-count-recorder service, move to button-count-recoder folder and use below commands to start multiple instances of recorder service.
    `SERVER_PORT=9001 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=9002 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=9003 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
- Start Button-count-writer service, move to button-count-writer folder and use below commands to start multiple instances of writer service.
    `SERVER_PORT=7001 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=7002 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=7003 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
- Start Button-click-Web-App, move to Button-click-Web-App folder and use below commands to start multiple instances of writer service.
    `SERVER_PORT=6001 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=6002 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`
    `SERVER_PORT=6003 mvn spring-boot:run -Drun.jvmArguments="-Xms64m -Xmx128m"  &`

Now open Eurka page to see all the registered service by using url : localhost:8761.
Open localhost:8080/record-count to open web application and enter your username and click on count button to record click count, open console logs to see the request served by various instances.


