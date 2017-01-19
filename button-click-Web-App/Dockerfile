FROM java:8-jre

COPY target/button-click-web-app.jar /opt/service/

WORKDIR /opt/service/

ENV JAVA_MEM="-Xms64m -Xmx128m"

CMD java -jar ${JAVA_MEM} button-click-web-app.jar --vcap.services.eureka-service.credentials.uri=http://eureka:8761



