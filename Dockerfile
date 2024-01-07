FROM openjdk:17-jre-slim

WORKDIR /app

# install the frontend dependencies with yarn in /frontend
RUN cd frontend && yarn install && yarn build && cd ..

# copy the frontend build to /backend/src/main/resources/static
COPY frontend/dist /backend/src/main/resources/static

# maven build
RUN ./mvnw package

# copy the jar to /app
COPY backend/target/kniffel-0.0.1-SNAPSHOT.jar /app

# expose port 8080
EXPOSE 8080

# run the jar
CMD ["java", "-jar", "kniffel-0.0.1-SNAPSHOT.jar"]
