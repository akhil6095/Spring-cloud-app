FROM java:8-jre

COPY target/eureka.jar /opt/service/

WORKDIR /opt/service/

ENV JAVA_MEM="-Xms64m -Xmx128m"

CMD java -jar ${JAVA_MEM} eureka.jar