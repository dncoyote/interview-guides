# Spring Boot Security - JWT

### AuthenticationController.java:

This is a REST controller responsible for handling registration and authentication requests.

### AuthenticationRequest.java and AuthenticationResponse.java:

These classes define the request and response structures for authentication.

### AuthenticationService.java:

- This service class handles user registration and authentication.
- It interacts with the UserRepository, PasswordEncoder, JwtService, and AuthenticationManager.
- In register, it saves a new user, encodes their password, generates a JWT token, and returns it in the response.
- In authenticate, it authenticates a user, generates a JWT token, and returns it in the response.

### RegisterRequest.java:

A data class used for registering new users.

### UserRepository.java:

A Spring Data JPA repository for managing user data.

### ApplicationConfig.java:

- This configuration class defines several beans.
- userDetailsService(): Defines a custom user details service.
- authenticationProvider(): Configures an authentication provider using DaoAuthenticationProvider.
- authenticationManager(): Creates an AuthenticationManager.
- passwordEncoder(): Configures a password encoder (BCrypt in this case).

### JwtAuthenticationFilter.java:

- This filter checks for JWT tokens in incoming requests and handles token-based authentication.
- It interacts with the JwtService and UserDetailsService.
- It validates JWT tokens, loads user details, and sets up Spring Security's Authentication object.

### JwtService.java:

- This service class is responsible for JWT token-related operations.
- It generates, validates, and extracts claims from JWT tokens.
- The generateToken method creates a token with an expiration time.
- The isTokenValid method checks if a token is valid.

### SecurityConfiguration.java:

- This configuration class is responsible for configuring Spring Security.
- It defines the SecurityFilterChain and interacts with the JwtAuthenticationFilter and AuthenticationProvider.
- It configures routes, authentication, session management, and filters.
- Routes under /api/v1/auth are permitted without authentication. All other routes require authentication.
- It sets the SessionCreationPolicy to STATELESS, ensuring no session management.
- The JwtAuthenticationFilter is applied before the standard UsernamePasswordAuthenticationFilter.

### Overall Code Flow:

- When a user registers or authenticates, the AuthenticationController delegates the work to the AuthenticationService.

- The AuthenticationService interacts with the database via the UserRepository to save or fetch user details.

- The AuthenticationService uses the PasswordEncoder to hash passwords securely.

- JWT tokens are generated and returned as part of the AuthenticationResponse.

- When a user makes a request, the JwtAuthenticationFilter checks for a JWT token in the request header.

- If a valid token is found, it uses the JwtService to validate the token and fetch user details.

- If the token is valid, it sets up Spring Security's Authentication object, allowing access to protected resources.

- The code achieves secure user authentication and authorization using JWT tokens, and it ensures that only authenticated users can access protected routes. If a user is not authenticated or provides an invalid token, they are denied access.
