# Store Pets

### Overview
Store Pets is a study backend project using the following configuration

- Java 8
- Spring Boot 2.5.5
- Postgres Database in Docker local and SupaBase in https://supabase.io/
- Maven 3.6.3
- SonarQube in local Environment
- Junit 4

### Executing without tests
clean -DskipTests install -U spring-boot:run
Store  project has the following configuration
- Java 11
- Spring Boot 2.5.5
- Postgres Database in Docker local and SupaBase in https://supabase.io/
- Maven 3.6.3
- SonarQube in local Environment
- Junit 4

### Execute without tests
To execute project using Local database:

`$ mvn clean -DskipTests install -U spring-boot:run -P docker`

To execute project using Supa database:

`$ mvn clean -DskipTests install -U spring-boot:run -P supa`

### Execute without tests
To execute project with unit tests:

`$ mvn clean -DskipTests install -U spring-boot:run -P docker`
`

### Sonar with Coverage report
To execute SonarQube with coverage report:

`$ mvn clean install jacoco:prepare-agent test jacoco:report verify sonar:sonar \
-Dsonar.projectKey=storepets \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.login=1b61bb842e7e048b5d246941691f88dcd19da2d9`


