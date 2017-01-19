FROM java:8-jre

COPY target/zuul-server.jar /opt/service/

WORKDIR /opt/service/

ENV JAVA_MEM="-Xms64m -Xmx128m"

CMD java -jar ${JAVA_MEM} zuul-server.jar --vcap.services.eureka-service.credentials.uri=http://eureka:8761



