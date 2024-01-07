FROM openjdk

COPY . /opt/build

WORKDIR /opt/build

RUN ./mvnw package

WORKDIR /opt/build/target

CMD ["java", "-jar", "kniffel-0.0.1-SNAPSHOT.jar"]
