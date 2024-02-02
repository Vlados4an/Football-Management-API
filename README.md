# FootballApiUp

FootballApiUp is a RESTful API built with Spring Boot for managing football data. It provides a comprehensive platform for performing CRUD operations on various football-related entities such as Players, Teams, Areas, Contracts, and Statistics.

## Features

- **CRUD Operations**: Perform Create, Read, Update, Delete operations on Players, Teams, Areas, Contracts, and Statistics.
- **Authentication and Authorization**: Secure your data with JWT-based authentication and authorization.
- **Data Validation**: Ensure the integrity of your data with built-in data validation.
- **Exception Handling**: Gracefully handle exceptions and errors.
- **External Football API Integration**: Seamlessly integrate with external Football APIs.

## Technologies

- Java 21
- Spring Boot 3.2.1
- Spring Security
- Spring Data JPA
- PostgreSQL
- Liquibase
- MapStruct
- Lombok
- JJWT
- Docker

## Setup

1. Clone the repository: `git clone https://github.com/Vlados4an/Football-Management-API.git`
2. Install PostgreSQL and create a database named `FootballApiUp`.
3. Update `spring.datasource.username` and `spring.datasource.password` in `application.properties` with your PostgreSQL username and password.
4. Run `mvn clean install` to build the application.
5. Run `mvn spring-boot:run` to start the application.

## API Endpoints

- `/players`: GET, PUT, DELETE operations for Players.
- `/teams`: GET, PUT, DELETE operations for Teams.
- `/areas`: GET operations for Areas.
- `/contracts`: GET operations for Contracts.
- `/statistics`: GET, POST, PUT, DELETE operations for Statistics.
- `/api/auth`: POST operations for user registration and authentication.

## Running with Docker

A `docker-compose.yml` file is included in the repository. To run the application with Docker:

1. Install Docker and Docker Compose.
2. Run `docker-compose up` in the root directory of the project.

## Testing

The project includes unit tests. Run `mvn test` to execute the tests.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact me:
-ssvetlaa235@gmail.com
-telegram: @evlad03
