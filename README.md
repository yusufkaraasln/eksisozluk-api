# Spring Boot Boilerplate

A boilerplate that can be used for monolithic and multi-layered architecture Spring Boot projects.
It includes various packages for different components such as configuration, entities, DTOs (Data Transfer Objects), enums, requests, security, services, and utilities.
This template uses PostgreSQL as the default database, but you can easily switch to a different database of your choice thanks to the flexible repository layer.

## Features

- Multi-layered architecture.
- Configuration files for easy setup.
- PostgreSQL database integration (can be changed to any other database).
- Security features using JSON Web Tokens (JWT).
- Internationalization (i18n) support for multiple languages.
- Basic error handling (exception layer can be added for global error handling).
- Three endpoints:
  - `/api/v1/auth/sign-in`: Authentication endpoint.
  - `/api/v1/auth/sign-up`: Registration endpoint.
  - `/api/v1/health/ping`: Health check endpoint for API status.
- Logging infrastructure (logging details will be added in future updates).

## Getting Started

To get started with this boilerplate, follow these steps:

1. Clone this repository.

2. Configure your database settings in the `application.properties` or `application.yml` file.

3. Build and run the application.

```bash
mvn clean install
java -jar target/your-application-name.jar
```

4. Access the API using the provided endpoints:

   - Authentication: `/api/v1/auth/sign-in` and `/api/v1/auth/sign-up`
   - Health Check: `/api/v1/health/ping`

## Contributing

We welcome contributions from the community. If you find any issues or have suggestions for improvements, please open an issue or create a pull request. Your contributions are highly appreciated.

## License

This project is licensed under the [MIT License](LICENSE).



