# My Social Network - Backend (Spring Boot)

This is the backend of the "My Social Network" application, developed with Spring Boot. It provides the API and business logic for user management, posts, and authentication.

## Technologies Used

- **Java** (Spring Boot, Spring Security, Spring Data JPA)
- **Database**: MySQL / PostgreSQL
- **Authentication**: JWT (JSON Web Token)
- **Swagger**: API Documentation
- **Additional Tools**: Lombok, Maven

## Installation and Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/VictorMarimon/Mi_Red_Social_Spring.git
   cd Mi_Red_Social_Spring
   ```

2. Configure the database in `application.properties` or `application.yml`.

3. Build and run the project:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Authentication and Security

- **JWT** is used for user authentication.
- Endpoints are protected with **Spring Security**.
- A valid token is required to access protected resources.

## Main Endpoints

| Method  | Endpoint          | Description |
|---------|------------------|-------------|
| POST    | `/auth/register` | User registration |
| POST    | `/auth/login`    | Login (returns JWT) |
| GET     | `/users/{id}`    | Get user profile |
| POST    | `/posts`         | Create a post |
| GET     | `/posts`         | List posts |

Full documentation available in **Swagger**: `http://localhost:8090/swagger-ui.html`

## Additional Resources

- **Documentation**: [Google Drive](https://drive.google.com/drive/folders/1QhANkOpZDCjecvZfWAJHRQeKDBZeADM4?usp=sharing)

## Frontend Repository

The frontend of this application can be found in the following repository:

[Frontend - My Social Network](https://github.com/VictorMarimon/My_Red_Social_Angular)

Latest frontend commit: `9a4bd3fde428acd358e5bc60e206f464028dc158`

`https://github.com/VictorMarimon/My_Red_Social_Angular/commit/9a4bd3fde428acd358e5bc60e206f464028dc158`

