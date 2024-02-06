# **Spring Boot**

## Spring Boot
- Spring Boot is essentially a framework for rapid application development built on top of the Spring Framework.
- It is popular due to features such as auto-configuration and embedded application server support.
- Key features
    - Starters
    - Auto-configuration
    - Actuator
    - Security
    - Logging

## Spring v/s Spring Boot
#### Spring
- Spring Framework is a comprehensive framework for building enterprise Java applications.
- It provides support for various functionalities such as dependency injection, aspect-oriented programming, transaction management, data access, and more.
- Spring Framework requires explicit configuration through XML or Java-based configuration classes.
- Developers need to configure and manage various components such as servlets, application context, dispatcher servlets, etc., manually.

#### Spring Boot
- Spring Boot is an opinionated framework designed to simplify the process of building and deploying Spring-based applications.
- It provides defaults for configurations and automatically configures many aspects of the application based on sensible conventions.
- Developers can create standalone, production-grade Spring-based applications with minimal configuration.
- It includes embedded servers (like Tomcat, Jetty, or Undertow) by default, so there's no need to deploy the application to an external server.
- Spring Boot includes tools for building, packaging, and running Spring applications, such as the Spring Boot CLI, Spring Boot Starter projects, and Spring Boot Actuator for monitoring and managing applications.
- Spring Boot applications can be easily deployed as executable JAR files, making them easy to manage and deploy. 

## Deploying a Spring Boot Web Application
- Traditionally, we package a web application as a WAR(Web ARchive) file and then deploy it into an external server. Doing this allows us to arrange multiple applications on the same server. 
- When CPU and memory were scarce, this was a great way to save resources.
- But things have changed. Computer hardware is fairly cheap now, and the attention has turned to server configuration. A small mistake in configuring the server during deployment may lead to catastrophic consequences.
- Spring tackles this problem by providing a plugin, namely `spring-boot-maven-plugin`, to package a web application as an executable JAR. To include this plugin, just add a plugin element to `pom.xml`.

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```
- This JAR contains all the necessary dependencies, including an embedded server. So, we no longer need to worry about configuring an external server. We can then run the application just like we would an ordinary executable JAR.

## JAR v/s WAR
#### JAR (Java ARchive)
- In Spring Boot, a JAR file typically packages the entire application, including embedded servers (like Tomcat, Jetty, or Undertow) and all dependencies into a single executable file.
- Spring Boot applications packaged as JAR files are standalone and can be executed directly using the `java -jar` command.
- JAR files are suitable for microservices and standalone applications that require self-contained deployment units.
- Spring Boot encourages the use of JAR packaging for its simplicity and ease of deployment.
- JAR packaging is preferred for standalone applications.
- `mvn clean package` will generate both JAR and WAR file.

#### WAR (Web ARchive)
- A WAR file, on the other hand, is a packaging format commonly used for deploying Java web applications to servlet containers like Apache Tomcat, Jetty, or JBoss.
- Spring Boot can also package applications as WAR files for deployment to external servlet containers.
- WAR files contain web application resources such as HTML, JSP, CSS, JavaScript files, along with compiled Java classes, configuration files, and libraries.
- Unlike JAR files, WAR files are not standalone executables; they require a servlet container to deploy and run the application.
- WAR packaging is suitable for traditional web applications deployed to external servlet containers.
- `mvn clean package` will generate both JAR and WAR file.


## External Configuration
-  We can use properties files, YAML files, environment variables, system properties and command-line option arguments to specify configuration properties.
- We can then gain access to those properties using the `@Value` annotation, a bound object via the `@ConfigurationProperties` annotation, or the Environment abstraction.

## **ControllerAdvice**

- `@ControllerAdvice` is an annotation used to define global exception handlers that are applied to all controllers in an application.
- When an exception occurs during the execution of a controller method, Spring Boot looks for an appropriate exception handler to handle the exception. If no specific exception handler is found, Spring Boot looks for a global exception handler defined using the `@ControllerAdvice` annotation.
- This can be useful for handling common exceptions such as NullPointerException, IllegalArgumentException, or IllegalStateException.

  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  ```

## **Spring Stereotype annotation**
- Stereotype annotations are a set of annotations used to indicate the roles of annotated classes. 
- These annotations help Spring Boot understand the purpose of the annotated class and how it should be treated within the application context. 
- Stereotype annotations are part of the broader Spring Framework, and they provide a way to define components, services, configurations, and more.

## **DispatcherServlet**

- DispatcherServlet plays a crucial role as the front controller for handling requests and managing the overall request-response workflow. It acts as a central entry point for incoming requests and delegates the request processing to specific handler components within the application.
- It provides a structured approach to handle and process web requests and promotes the separation of concerns by routing requests to appropriate handlers, integrating with view technologies, and supporting various web application features through configuration and customization.

## **Dependency Injection**

- Dependency Injection (DI) is a design pattern and a software development technique used in object-oriented programming to achieve Inversion of Control (IoC) and enhance the modularity, testability, and maintainability of software applications.
- DI involves providing an object with the dependencies it needs (i.e., other objects or services) rather than having it create or manage those dependencies itself. This inversion of control shifts the responsibility of managing dependencies from the object to an external entity (usually a DI container or framework).

## **Inversion of Control**

- Inversion of Control (IoC) is a design principle and architectural concept in software development where the control over the flow of a program's execution is shifted from the program itself to an external framework or container.
- It is a way of inverting the traditional flow of control in a software application.

## **Beans in Spring Boot**

- In Spring Boot, beans are created using a process called "dependency injection". Dependency injection is a design pattern in which objects are passed their dependencies instead of creating them themselves. This pattern is implemented by the Spring framework, and it allows for loosely-coupled and easily testable code.
- When a Spring Boot application starts up, the Spring framework scans the project for classes that are annotated with @Component, @Service, @Controller, @Repository, or @Configuration. These annotations indicate that a class should be treated as a bean, and Spring creates an instance of the class and registers it in its container.
- In Spring Boot, you can define beans with different scopes, including Singleton and Prototype.
- These bean scopes determine how Spring manages and creates instances of those beans

## **Singleton Bean**

- Singleton bean is the default scope in Spring. It means that only one instance of the bean is created for the entire application context.
- Spring returns the same instance whenever bean is requested.
- Singleton beans are suitable for stateless services, utility classes, and beans that don't maintain state specific to individual clients or users.
- Singleton beans are cached in the Spring container and reused whenever requested.

## **Prototype Bean**

- Prototype bean scope means that a new instance of the bean is created every time it is requested.
- Prototype beans are suitable for stateful objects, where each client or user should have a unique instance of the bean.(web request handlers, user sessions, or objects that must not be shared among different clients.)
- These beans are not cached, and a new instance is created for every request.

```java
@Component
@Scope("prototype")
public class MyPrototypeBean {
    private int counter = 0;

    public int increment() {
        return ++counter;
    }
}
```

## **Controller v/s RestController**

####  Controller
- `@Controller` annotation is used to define a controller class in Spring MVC. Controllers are primarily used for handling traditional web-based applications where the response can be in various forms, such as HTML pages, JSON/XML responses, file downloads, etc. 

####  RestController
- `@RestController` annotation is a specialized version of the Controller annotation that combines `@Controller` and `@ResponseBody`. It is used to define controllers specifically for building RESTful APIs where the response is typically in JSON/XML format. The `@ResponseBody` annotation is applied to the methods within a RestController to indicate that the return value should be serialized directly into the response body.

## **Qualifiers in Spring Boot**

- Qualifiers are used to differentiate between beans of the same type when multiple instances of a bean exist in the application context.

  ```java
  @Component
  @Qualifier("fooQualifier")
  public class FooBean implements MyInterface {
      // ...
  }

  @Component
  @Qualifier("barQualifier")
  public class BarBean implements MyInterface {
      // ...
  }
  ------------
  @Service
  public class MyService {

  private final MyInterface myInterface;

  public MyService(@Qualifier("fooQualifier") MyInterface myInterface) {
      this.myInterface = myInterface;
  }
  }

  ```

## **@Autowired**

`@Autowired` annotation is used in Spring Framework to automatically inject dependencies into a Spring bean. It tells Spring's dependency injection container to provide the required dependencies (beans) to the annotated field, constructor, or method parameter. Essentially, it helps in achieving the Inversion of Control (IoC) principle by letting Spring manage and wire the dependencies for you.

## Spring Profiles
- Profiles are a feature that allows you to configure and customize your application based on different environments or deployment scenarios. Profiles provide a way to have multiple sets of configuration properties and beans within a single codebase, enabling you to switch between different configurations easily.
- When developing applications for the enterprise, we typically deal with multiple environments such as Dev, QA and Prod. The configuration properties for these environments are different.
- For example, we might be using an embedded H2 database for Dev, but Prod could have the proprietary Oracle or DB2.
- Spring has the provision of profiles to help separate the configuration for each environment. 
- Instead of maintaining this programmatically, the properties can be kept in separate files such as `application-dev.properties` and `application-prod.properties`. The default `application.properties` points to the currently active profile using `spring.profiles.active` so that the correct configuration is picked up.

## Spring Boot Embedded Servers
- In Spring Boot, embedded servers are lightweight servers that are packaged with your application. 
- These servers allow you to run your Spring Boot application as a standalone executable JAR file without needing to deploy it to a separate application server like Tomcat or Jetty.
- Spring Boot supports several embedded servers out of the box.
    - Tomcat (default) 
    - Jetty
    - Undertow
- You can choose which embedded server to use by adding the appropriate dependencies to your `pom.xml` or `build.gradle` file

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>

//or

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>

```

## **Spring Boot Actuator**
- Actuator brings Spring Boot applications to life by enabling production-ready features. These features allow us to monitor and manage applications when they’re running in production.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- It provides endpoints and tools for monitoring and managing a Spring Boot application. Spring Boot Actuator provides several features, including:
  - `env` exposes environment properties
  - `health` shows application health information
  - `httptrace` displays HTTP trace information
  - `info` displays arbitrary application information
  - `metrics` shows metrics information
  - `loggers` shows and modifies the configuration of loggers in the application
  - `mappings` displays a list of all @RequestMapping paths

## Spring Boot Security
- Spring Boot Security is a powerful module provided by the Spring framework that enables developers to easily add security features to their Spring Boot applications

- Authentication: Spring Security supports various methods of authentication, such as username/password, token-based, OAuth, and more. It allows you to integrate with different identity providers, databases, LDAP, or custom authentication mechanisms.
- Authorization: Spring Security enables you to control access to resources in your application. You can define fine-grained access rules, roles, and permissions using annotations or configuration.
- User Details Service: It allows you to customize how user information is loaded, including user details, authorities, and password handling.
- Session Management: Spring Security provides session management capabilities, allowing you to manage user sessions, including session fixation protection and concurrent session control.
- CSRF (Cross-Site Request Forgery) Protection: It helps protect your application from CSRF attacks by generating and validating CSRF tokens for each request.
- Password Storage: Spring Security provides utilities for secure password storage using hashing algorithms, salting, and password encoding.
- Security Filters: The framework includes a series of filters that handle security tasks such as authentication, authorization, CSRF protection, and more. These filters can be customized or extended as needed.
- Custom Authentication Providers: You can implement custom authentication providers for integrating with external systems or implementing specific authentication mechanisms.
- Integration with Other Frameworks: Spring Security seamlessly integrates with other Spring projects, such as Spring Boot, Spring Data, and Spring Web.
- Common Vulnerability Protection: It provides out-of-the-box protection against common web security vulnerabilities, such as SQL injection, cross-site scripting (XSS), and clickjacking.
- OAuth 2.0 Support: Spring Security simplifies the implementation of OAuth 2.0 for securing RESTful APIs and allowing third-party applications to access your resources securely.
- Single Sign-On (SSO): It supports single sign-on solutions, making it possible for users to authenticate once and access multiple, integrated applications.

### AuthenticationController.java:
- This is a REST controller responsible for handling registration and authentication requests.

### AuthenticationRequest.java and AuthenticationResponse.java:
- These classes define the request and response structures for authentication.

### AuthenticationService.java:
- This service class handles user registration and authentication.
- It interacts with the UserRepository, PasswordEncoder, JwtService, and AuthenticationManager.
- In register, it saves a new user, encodes their password, generates a JWT token, and returns it in the response.
- In authenticate, it authenticates a user, generates a JWT token, and returns it in the response.

### RegisterRequest.java:
- A data class used for registering new users.

### UserRepository.java:
- A Spring Data JPA repository for managing user data.

### ApplicationConfig.java:
- This configuration class defines several beans.
- `userDetailsService()`: Defines a custom user details service.
- `authenticationProvider()`: Configures an authentication provider using DaoAuthenticationProvider.
- `authenticationManager()`: Creates an AuthenticationManager.
- `passwordEncoder()`: Configures a password encoder (BCrypt in this case).

### JwtAuthenticationFilter.java:
- This filter checks for JWT tokens in incoming requests and handles token-based authentication.
- It interacts with the JwtService and UserDetailsService.
- It validates JWT tokens, loads user details, and sets up Spring Security's Authentication object.

### JwtService.java:
- This service class is responsible for JWT token-related operations.
- It generates, validates, and extracts claims from JWT tokens.
- The generateToken method creates a token with an expiration time.
- The `isTokenValid` method checks if a token is valid.

### SecurityConfiguration.java:
- This configuration class is responsible for configuring Spring Security.
- It defines the SecurityFilterChain and interacts with the JwtAuthenticationFilter and AuthenticationProvider.
- It configures routes, authentication, session management, and filters.
- Routes under `/api/v1/auth` are permitted without authentication. All other routes require authentication.
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