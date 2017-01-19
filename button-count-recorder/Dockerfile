FROM java:8-jre

COPY target/button-count-recorder.jar /opt/service/

WORKDIR /opt/service/

ENV JAVA_MEM="-Xms64m -Xmx128m"

CMD java -jar ${JAVA_MEM} button-count-recorder.jar --vcap.services.eureka-service.credentials.uri=http://eureka:8761 --spring.data.mongodb.host=mongodb



