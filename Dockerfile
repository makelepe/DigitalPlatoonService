FROM openjdk:8-jre-alpine
COPY ./target/MMIUnitConversionProject-0.0.1-SNAPSHOT.jar /usr/src/conversion/
WORKDIR /usr/src/conversion/
EXPOSE 8080
CMD ["java", "-jar", "MMIUnitConversionProject-0.0.1-SNAPSHOT.jar"]