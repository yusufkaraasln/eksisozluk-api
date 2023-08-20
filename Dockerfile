FROM eclipse-temurin
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY env.properties ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
