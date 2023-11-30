# **Framework, Libraries and Technologies**

## **HTTP Requests**

- HTTP is the protocol used by web browsers and servers to communicate and exchange information.
- An HTTP request is a message sent by a client, typically a web browser or an application, to request data from a server.
- HTTP request typically consists of the following components:

  - HTTP Method: This indicates the type of request being made, such as GET, POST, PUT, DELETE, etc. Each HTTP method has a specific purpose, such as retrieving data (GET), submitting data (POST), updating data (PUT), or deleting data (DELETE).
  - URL (Uniform Resource Locator): This specifies the web address of the resource being requested. It includes the protocol (e.g., http:// or https://), the domain name (e.g., www.example.com), and the path to the resource (e.g., /images/pic.jpg).
  - Headers: These are key-value pairs that provide additional information about the request, such as the type of data being sent, the language preference, caching settings, and more. Headers are used to convey meta-information about the request to the server.
  - Body (optional): This is the data, such as form data or JSON, that is sent as part of the request. It is typically used in POST, PUT, and DELETE requests to send data to the server.

- Once the HTTP request is sent to the server, the server processes the request and generates an HTTP response, which is sent back to the client with the requested data. The response typically contains a response status code indicating the outcome of the request (e.g., 200 OK, 404 Not Found, etc.), headers with additional information, and optionally, a response body with the requested data.

## **REST API**

- A REST API (Representational State Transfer Application Programming Interface) is a type of web API that uses HTTP requests to perform operations on data.

## **SOAP**
- SOAP, stands for Simple Object Access Protocol.
- It is a protocol for exchanging structured information in web services. 
- It is a messaging protocol that allows programs running on different operating systems to communicate with each other over a network.   
- SOAP is often used in combination with XML for the message format.

```xml
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" 
               xmlns:web="http://www.example.com/webservice">
    <soap:Header>
        <!-- Optional header information -->
    </soap:Header>
    <soap:Body>
        <web:GetStockPrice>
            <web:StockName>ABC</web:StockName>
        </web:GetStockPrice>
    </soap:Body>
</soap:Envelope>
```
- In this example, the SOAP message is a request to a web service (GetStockPrice) with a parameter (StockName). The web service would respond with a SOAP message containing the stock price information.
- The Envelope element is the root element and contains Header and Body elements.
- The Header element is optional and may contain additional information such as security details or application-specific data.
- The Body element contains the main content of the message, including the actual data being exchanged.
- Key components
  - Protocol:
SOAP is a protocol, not a programming language or platform. It defines a set of rules for structuring messages and communicating between applications.
  - Messaging Format:
SOAP messages are typically XML documents. The structure of the XML document adheres to the SOAP specification, defining elements for the header, body, and optional fault information.
  - Transport Independence:
SOAP messages can be transported using various protocols, including HTTP, SMTP, and more. The choice of transport protocol is independent of the SOAP protocol itself.
  - Language Neutrality:
SOAP is designed to be language-neutral, allowing applications written in different programming languages to communicate with each other.
  - Extensibility:
The SOAP specification is extensible, meaning that additional features can be added to meet specific requirements. Extensions are often implemented using SOAP headers.

## SOAP v/s REST
| SOAP     | REST     |
| ------------- | ------------- |
| Often used in enterprise-level applications. | Preferred for mobile and web applications due to its simplicity and scalability. |
| Suitable for scenarios requiring a high level of security and ACID-compliant transactions. | Suitable for scenarios where statelessness and simplicity are critical. |
| SOAP is a protocol, a set of rules that dictate how web services should communicate.| REST is an architectural style, not a protocol.
| It typically uses XML as the message format. | It relies on a stateless, client-server communication model. |
| SOAP can work over a variety of transport protocols, including HTTP, SMTP, and more. | REST primarily uses HTTP as the transport protocol. |

## RPC
- RPC stands for Remote Procedure Call.
- It is a protocol that allows a program to cause a procedure (subroutine) to execute in another address space (commonly on another machine).
- In an RPC, a client program initiates a procedure call that is executed on a remote server. The client and server can be written in different programming languages and can run on different operating systems. RPC abstracts the communication details between the client and the server, making it appear as if the client is calling a procedure locally.

## **Authentication v/s Authorization**

- Authentication : Authentication is the process of verifying the identity of a user, system, or entity to ensure they are who they claim to be.
- Authorization : Authorization, also known as access control, is the process of determining what actions or operations an authenticated user or entity is allowed to perform on a system or resource.

## **REST API Authentication**

- Basic Authentication:
  - Clients send a username and password with each request.
  - Typically used with HTTPS for security.
  - Simple but not the most secure option.
- Token-Based Authentication:
  - Clients receive a token (e.g., JWT) upon successful login.
  - The token is included in the request headers for subsequent API calls.
  - Tokens can carry user-related information and have expiration times.
- OAuth 2.0:
  - An authorization framework used for delegating access to a third-party application without exposing the user's credentials.
  - Provides various grant types (authorization code, client credentials, implicit, resource owner password credentials).
  - Popular for securing APIs used by mobile and web applications.
- API Keys:
  - Clients include an API key in the request headers to authenticate.
  - Simple and commonly used for rate limiting and access control.
  - Typically not suitable for user authentication.
- Bearer Token:
  - Similar to token-based authentication, but the token is referred to as a "bearer token."
  - Clients include the token in the request headers with the "Bearer" prefix.
- OpenID Connect (OIDC):
  - An extension of OAuth 2.0 that provides identity information about the user in addition to authentication.
  - Often used for single sign-on (SSO) and user identity management.
- HMAC (Hash-based Message Authentication Code):
  - Clients generate a hash of the request data and a secret key, which is included in the request headers.
  - Requires a shared secret between the client and server.
- Session-Based Authentication:
  - Clients authenticate once (e.g., using a username and password) and receive a session token.
  - The session token is stored on the server, and a session ID or cookie is sent to the client.
  - Commonly used in web applications but less common in pure REST APIs.
- Client Certificates (Mutual SSL):
  - Both the client and server have SSL certificates, and mutual authentication is performed during the SSL handshake.
  - Used in scenarios where server-to-client trust is important.
- Custom Authentication:
  - Implement custom authentication mechanisms tailored to specific application requirements.
  - Can include multi-factor authentication (MFA), biometric authentication, or any other unique methods.

## **Basic Auth in HTTP**

- Create HTTPS connection.
- Set up Basic Authentication Header
  - By encoding username and password, and add it to a Basic Authentication Header.
- Send the Authentication header as request.
- Characteristics
  - Security: Basic Authentication transmits credentials with every request, so it's crucial to use it over HTTPS to ensure the confidentiality of the credentials during transmission.
  - Statelessness: Basic Authentication is stateless. Each request should contain the necessary authentication information, and the server does not maintain session or user state between requests.
  - Efficiency: Basic Authentication is efficient for simple authentication needs but may not be suitable for more complex scenarios. For improved performance, you might consider using tokens or sessions once the user's identity is confirmed.
  - Authentication Overhead: Authenticating with each request can create additional overhead, especially if the authentication process is time-consuming or resource-intensive. Caching or using stateful sessions can help mitigate this.

## **JWT**

- JSON Web Token is a standard that defines a compact and self-contained way to transmit information between parties as a JSON object. JWTs are commonly used for authentication and authorization in web applications and APIs.
- Authentication and authorization is performed by sending them in the HTTP Authorization header of a request to an API. The JWT is then verified on the server-side to ensure that it is valid and that the user has the necessary permissions to access the requested resource.
- A JWT is composed of three parts:
  - Header: The header contains metadata about the JWT, such as the type of token and the hashing algorithm used to generate the signature.
  - Payload: The payload contains claims, which are statements about an entity (typically the user) and additional metadata. Claims can be used to provide information such as the user's identity, role, or permissions.
  - Signature: The signature is used to verify that the message has not been tampered with and that the sender is who they claim to be.
- Characteristics
  - Token-Based: JWT is a token-based authentication method. Instead of sending the username and password with each request, the server issues a JWT token to the client upon successful login. The client includes this token in the request headers for subsequent API calls.
  - Stateless or Stateful: JWT can be used in both stateless and stateful scenarios. In a stateless setup, the server can verify the token without needing to maintain session data. In a stateful setup, the server may validate the token and maintain session information on the server side.
  - Transmission: JWTs are typically transmitted over HTTPS, but the data contained within a JWT is digitally signed (and optionally encrypted) to ensure its integrity and confidentiality.
  - Versatile: JWTs can carry additional claims (metadata) about the user or client, making them versatile for various authentication and authorization scenarios. These claims can be used to convey information such as user roles, permissions, and expiration time.
  - Scalable: JWTs are commonly used in distributed and microservices architectures, as they allow for authentication across different services or applications without the need to maintain shared sessions.

## **Bearer Token**

- A bearer token is a type of access token used in OAuth 2.0 authentication. It is a security token that is used to grant access to a protected resource, such as a REST API.
- A bearer token is essentially a string of characters that is generated by the authorization server after the user has provided their credentials. The token is then sent to the client (such as a web or mobile application) and included in the header of each subsequent API request to access the protected resource.
- Bearer tokens are typically short-lived and can be invalidated by the authorization server if they are compromised or stolen.

## **Spring Boot Actuator**

- Spring Boot Actuator is a sub-project of Spring Boot that provides endpoints and tools for monitoring and managing a Spring Boot application. Spring Boot Actuator provides several features, including:
  - Health checks
  - Metrics
  - Auditing
  - Environment and configuration
  - Endpoints

## **ControllerAdvice**

- `@ControllerAdvice` is an annotation used to define global exception handlers that are applied to all controllers in an application.
- When an exception occurs during the execution of a controller method, Spring Boot looks for an appropriate exception handler to handle the exception. If no specific exception handler is found, Spring Boot looks for a global exception handler defined using the `@ControllerAdvice` annotation.
- This can be useful for handling common exceptions such as NullPointerException, IllegalArgumentException, or IllegalStateException.

  ```
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

## **OAuth 2.0**

## **OIDC**

## **IAM**

## **Keycloak**

- Keycloak is an open-source identity and access management (IAM) solution that provides authentication, authorization, and single sign-on capabilities for web applications, mobile apps, and services. It allows organizations to secure their applications and APIs by managing user identities, enforcing access policies, and handling user authentication and authorization.

## **JDBC**

JDBC (Java Database Connectivity) is a Java-based API (Application Programming Interface) for connecting and interacting with relational databases. It provides a standard interface for Java applications to connect to various relational database management systems (RDBMS) such as MySQL, PostgreSQL, Oracle, Microsoft SQL Server, and more. With JDBC, Java applications can perform database operations, including connecting to databases, executing SQL queries, and manipulating data.

## **JPA**

- JPA is a Java specification that defines a standard interface for object-relational mapping in Java applications.
  It provides a set of standard annotations and APIs for mapping Java objects to database tables and performing database operations using Java objects.

## **Hibernate**

- Hibernate is an open-source Java ORM framework that implements the JPA specification.
- Dependency
- @Entity
- @Table
- @Id
- @Column
- Mapping Annotations
- SessionFactory
- EntityManager
- hibernate.cfg.xml v/s application.properties
- JPQL
- Criteria API
- @Transactional

## **SessionFactory**

- `SessionFactory` is a critical component that serves as a factory for creating and managing Hibernate Session instances.
- It plays a key role in connecting to the database, managing the database connection, and providing a means to perform database operations.
- It is responsible for managing database connections, configuring Hibernate, and providing a way to interact with the database using objects rather than SQL.

## **Hibernate Interfaces**

## **Hibernate Caches**

- Hibernate provides several caching mechanisms to improve the performance of database operations. These caching mechanisms help reduce the number of trips to the database and minimize the time required to fetch or store data

  - First-level Cache (Session Cache): Also known as the session cache, it is the default and most basic cache provided by Hibernate. It operates at the session level and stores entities and their associated data within the context of a single Hibernate session. It helps in reducing database round trips by caching and reusing the retrieved entities during the session.

  - Second-level Cache: The second-level cache is a shared cache that operates at the session factory level. It caches objects across multiple sessions, allowing data to be shared among different sessions and reducing the need for repeated database queries. Hibernate supports various second-level cache providers, such as Ehcache, Infinispan, Hazelcast, and more.

  - Query Cache: The query cache is used to cache the results of queries. When enabled, the query results are stored in the cache based on the query parameters. Subsequent executions of the same query with the same parameters can be served from the cache without hitting the database.

  - Collection Cache: Hibernate also provides a cache for collections, such as one-to-many or many-to-many associations. It allows caching of the associated collection elements, improving the performance of fetching related entities.

## **Hibernate Locks**

## **Hibernate v/s JPA**

## **JPA Repository**

## **DispatcherServlet**

- DispatcherServlet plays a crucial role as the front controller for handling requests and managing the overall request-response workflow. It acts as a central entry point for incoming requests and delegates the request processing to specific handler components within the application.
- It provides a structured approach to handle and process web requests and promotes the separation of concerns by routing requests to appropriate handlers, integrating with view technologies, and supporting various web application features through configuration and customization.

## **Dependency Injection**

- Dependency Injection (DI) is a design pattern and a software development technique used in object-oriented programming to achieve Inversion of Control (IoC) and enhance the modularity, testability, and maintainability of software applications.
- DI involves providing an object with the dependencies it needs (i.e., other objects or services) rather than having it create or manage those dependencies itself. This inversion of control shifts the responsibility of managing dependencies from the object to an external entity (usually a DI container or framework).

## **Inversion of Control**

- Inversion of Control (IoC) is a design principle and architectural concept in software development where the control over the flow of a program's execution is shifted from the program itself to an external framework or container.
- It is a way of inverting the traditional flow of control in a software application.

## **Spring Boot**

## **Spring Security**

Spring Security is a powerful and highly customizable security framework for building secure applications in the Java ecosystem, particularly within the Spring Framework. It provides a comprehensive set of features and tools to address various aspects of application security, including authentication, authorization, protection against common security vulnerabilities, and more.

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

```
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

| Controller                                                                                                                                                                                                                                                           | RestController                                                                                                                                                                                                                                                                                                                                                                                                                     |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `@Controller` annotation is used to define a controller class in Spring MVC. Controllers are primarily used for handling traditional web-based applications where the response can be in various forms, such as HTML pages, JSON/XML responses, file downloads, etc. | `@RestController` annotation is a specialized version of the Controller annotation that combines @Controller and @ResponseBody. It is used to define controllers specifically for building RESTful APIs where the response is typically in JSON/XML format. The @ResponseBody annotation is applied to the methods within a RestController to indicate that the return value should be serialized directly into the response body. |

## **Profile in Spring Boot**

- Profiles are a feature that allows you to configure and customize your application based on different environments or deployment scenarios. Profiles provide a way to have multiple sets of configuration properties and beans within a single codebase, enabling you to switch between different configurations easily.

## **Qualifiers in Spring Boot**

- Qualifiers are used to differentiate between beans of the same type when multiple instances of a bean exist in the application context.

  ```
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

## **API Gateway**

- API Gateway is a server or service that acts as an entry point for a collection of microservices or backend services in a distributed computing environment.

## **Load Balancing in API Gateway**

## **Service Discovery**

## **Eureka Server**

## **@FeignClient**

## **Transactional**

## **Queueing Libraries**

- Queueing libraries, also known as message queuing libraries or message broker libraries, are software components or frameworks that provide functionalities for implementing message queues, message brokering, and asynchronous communication patterns in distributed systems.
- These libraries play a crucial role in building scalable, resilient, and decoupled architectures by enabling various components of a system to communicate asynchronously through messages

## **Apache Kafka**

## **Rabbit MQ**

## **MQTT/Mosquito**

## **Redis**

- Redis is an open-source, in-memory data store and caching system that can be used as a database, message broker, and cache.

## **hystrix**

## **Swagger**

## **EC2**

## **Amplify**

## **DynamoDB**

## **Lambda**

## **HTTP Requests**

## **Lazy Loading**

- Lazy loading is a technique in which related data is loaded from the database only when it is explicitly requested

## **Eager Loading**

- Eager Loading is the strategy of fetching and loading related data from the database in a single query, along with the main object, at the time the main object is retrieved.

## **Ways to prevent SQL Injection**

- <u>Use Parameterized Queries (Prepared Statements)</u>: Instead of concatenating user input directly into SQL statements, use parameterized queries or prepared statements provided by your programming language or database framework.
- <u>Input Validation and Sanitization</u>: Validate and sanitize user input to ensure it adheres to expected formats and patterns. Perform input validation both on the client side (using JavaScript or HTML input attributes) and on the server side.
- <u>Avoid Dynamic SQL</u>: Avoid dynamically constructing SQL queries using string concatenation, especially when incorporating user input. Instead, use query builders or Object-Relational Mapping (ORM) frameworks that provide safe and automated methods for building and executing SQL queries.
- <u>Least Privilege Principle</u>: Ensure that database users used by your application have the least privileges necessary to perform their tasks. Restrict the permissions granted to database accounts to only the required operations and limit access to sensitive data or system functionality.

## **MVC Pattern**
- MVC (Model-View-Controller) Pattern: Separates the application logic into three interconnected components - Model (data), View (user interface), and Controller (handles user input).


## **Microservices**
- Microservices architecture is an approach to developing software systems that emphasizes the creation of small, independent services that communicate with each other to form a complete application. 
- This architectural style aims to enhance the agility and scalability of software development.

### Principles
#### Service Independence
- Microservices are independent entities that can be developed, deployed, and scaled independently. 
- Each service is a self-contained module with its own data storage and business logic.
#### Single Responsibility
- Each microservice should have a single responsibility or function. 
- This helps maintain simplicity, clarity, and ease of development.
#### Decentralized Data Management
- Microservices often have their own database, enabling them to manage their data independently. 
- This avoids dependencies on a centralized database, enhancing scalability and isolation.
#### Inter-Process Communication
- Microservices communicate with each other through well-defined APIs, often using lightweight protocols such as HTTP/REST or message queues. 
- This allows them to work together to fulfill business requirements.
#### Resilience
- Microservices should be designed to handle failures gracefully. 
- This involves incorporating techniques such as circuit breakers, retries, and fallback mechanisms to maintain system stability.
#### Scalability
- Individual microservices can be scaled independently based on specific needs. 
- This allows for efficient resource utilization and responsiveness to varying workloads.
#### Continuous Delivery and Deployment
- Microservices are conducive to continuous integration and continuous deployment (CI/CD) practices. 
- Each service can be developed, tested, and deployed independently, enabling faster and more frequent releases.

### Practices
#### Containerization
- Microservices are often deployed within containers (e.g., Docker). 
- Containerization provides consistency across development, testing, and deployment environments, making it easier to manage dependencies.
#### Orchestration
- Tools like Kubernetes are commonly used for orchestrating and managing the deployment, scaling, and operation of microservices. 
- They automate tasks like load balancing, scaling, and rolling updates.
#### API Gateway
- An API gateway is used to aggregate and manage the APIs of various microservices.
- It provides a single entry point for clients and handles tasks such as authentication, authorization, and routing.
#### Event-Driven Architecture
- Microservices can communicate through events and asynchronous messaging. 
- This promotes loose coupling, allowing services to evolve independently.
#### Monitoring and Logging
- Comprehensive monitoring and logging are crucial for diagnosing issues, analyzing performance, and ensuring the overall health of the microservices ecosystem.
#### Automated Testing
- Automated testing, including unit tests, integration tests, and end-to-end tests, is essential for ensuring the reliability and correctness of individual microservices and their interactions.
#### Database Per Service
- Each microservice often has its own database, aligned with the service's specific data requirements. 
- This helps prevent data coupling between services.
#### DevOps Culture
- Microservices development often involves a strong DevOps culture, where development and operations teams collaborate closely. 
- Automation and collaboration are key elements in achieving successful microservices deployments.
#### Versioning and Contract Testing
- Effective versioning of APIs and contract testing are essential to manage changes in microservices without disrupting other services that depend on them.

## **Microservices Architecture**
#### Microservices:
- Pattern: Decompose the application into a set of small, independent services that can be developed, deployed, and scaled independently.
- Use Case Scenario: In an e-commerce system, separate services for user management, order processing, and inventory management.
#### Service Discovery:
- Pattern: Automatically detect and register microservices in the system, allowing them to locate and communicate with each other.
- Use Case Scenario: A new instance of a microservice registers itself with a service registry, and other microservices dynamically discover its location for communication.
#### API Gateway:
- Pattern: Use a centralized entry point to manage and route API requests to appropriate microservices. It handles tasks like authentication, authorization, and load balancing.
- Use Case Scenario: An API gateway manages incoming requests from clients and routes them to relevant microservices based on the request path.
#### Circuit Breaker:
- Pattern: Prevent cascading failures by detecting and handling faults in microservices. If a service repeatedly fails, the circuit breaker opens, redirecting traffic to a fallback mechanism.
- Use Case Scenario: In an online payment system, if the payment processing microservice consistently fails, the circuit breaker opens, and requests are redirected to a cached payment status.

## **Docker**
- Docker is a platform that enables developers to automate the deployment of applications within lightweight, portable containers. 
- Containers package an application and its dependencies, ensuring consistency across different environments, from development to testing and production.
- Docker provides tools and a platform for building, shipping, and running applications in containers, making it easier to deploy and scale applications in a consistent manner.

#### Isolation
- Principle: Containers encapsulate applications and their dependencies, providing a level of isolation from the underlying system and other containers.
- Practice: Use containers to create isolated environments, preventing conflicts between dependencies and ensuring consistency across different stages of the development lifecycle.
#### Portability:
- Principle: Containers are lightweight and portable, making it easy to run applications consistently across various environments, including different operating systems and cloud platforms.
- Practice: Develop and test applications in containers locally and deploy the same containerized application in production, reducing the "it works on my machine" problem.
#### Resource Efficiency:
- Principle: Containers share the host OS kernel, which reduces the overhead compared to traditional virtualization. This leads to more efficient resource utilization.
- Practice: Run multiple containers on a single host, optimizing resource usage and enabling better scalability.
#### Consistency Across Environments:
- Principle: Containers package an application along with its dependencies, ensuring that the application runs consistently across different environments.
- Practice: Use the same container image for development, testing, and production, minimizing the risk of issues caused by environmental differences.
#### Versioning and Reproducibility:
- Principle: Container images can be versioned, providing a way to track changes and ensuring that applications can be reproduced with the same dependencies.
- Practice: Tag container images with version numbers and use version control for Dockerfiles to track changes over time.
#### Microservices Architecture Support:
- Principle: Containers align well with microservices architecture, allowing for the development and deployment of small, independent services.
- Practice: Package each microservice into its own container, enabling easier management, scaling, and maintenance of microservices-based applications.
#### Orchestration:
- Principle: Orchestration tools, such as Kubernetes and Docker Swarm, automate the deployment, scaling, and management of containerized applications.
- Practice: Use orchestration tools to define and manage the deployment and scaling of containers, ensuring high availability and ease of management.
#### DevOps Integration:
Principle: Containers facilitate the integration of development and operations workflows, supporting the DevOps culture.
Practice: Implement CI/CD pipelines that build, test, and deploy containerized applications automatically, enabling rapid and reliable software delivery.
#### Immutable Infrastructure:
Principle: Treat containers as immutable, meaning that once a container is created, it should not be modified. Updates are handled by creating new containers.
Practice: Avoid making changes to running containers. Instead, update the container image and redeploy to ensure consistency and traceability.

## **docker-compose files**
- A Docker Compose file is a YAML configuration file used to define and configure multi-container Docker applications.
- It allows you to define the services, networks, and volumes for an application, along with their configurations and relationships.
- Docker Compose simplifies the process of managing and orchestrating multiple Docker containers that work together to form a complete application.
- Docker Compose enables you to define the entire application stack and its dependencies in a single, easy-to-read file.
- This simplifies the deployment and management of complex applications with multiple interconnected services.

#### Services:
Containers that run different components of your application. Each service is defined with its configuration, including the Docker image to use, ports to expose, environment variables, and more.
#### Networks:
Defines how containers communicate with each other. Docker Compose automatically creates a default network for your services, but you can define custom networks with specific configurations.
#### Volumes:
Manages data persistence by defining volumes to store and share data between containers. Volumes can be used to store databases, configuration files, or any other data that needs to persist beyond the lifespan of a container.
#### Environment Variables:
Allows you to set environment variables for each service, specifying configurations that can be customized without changing the application code.
#### Dependencies:
Specifies dependencies between services, ensuring that certain services start before others. This is useful when one service relies on the availability of another.

```yaml
version: '3'

services:
  web:
    image: nginx:latest
    ports:
      - "80:80"

  db:
    image: mysql:latest
    environment:
      MYSQL_ROOT_PASSWORD: examplepassword
      MYSQL_DATABASE: exampledb
```
- In this example, there are two services defined (web and db). The web service uses the Nginx image and exposes port 80. The db service uses the MySQL image and sets some environment variables for MySQL configuration. Docker Compose automatically creates a network for these services, allowing them to communicate with each other.
- To use a Docker Compose file, save it as docker-compose.yml in the project directory and run docker-compose up in the terminal. 
- This command reads the configuration from the file and starts the defined services, creating a multi-container environment for your application.

## **Kubernetes**

## **JavaEE/J2EE**
Java EE, which stands for Java Platform, Enterprise Edition, is a set of specifications that extends the Java SE (Standard Edition) platform to provide a comprehensive enterprise computing infrastructure. Originally known as J2EE (Java 2 Platform, Enterprise Edition), it underwent a rebranding and is now referred to as Jakarta EE. Jakarta EE is the latest evolution of the enterprise Java platform.

Java EE/J2EE provides a set of APIs (Application Programming Interfaces) and runtime environments for developing and running large-scale, distributed, and multi-tiered enterprise applications. These applications typically run on servers and involve components that handle various aspects of business logic, data persistence, messaging, and web presentation.

- Key components
  - Servlets and JSP (JavaServer Pages):
Servlets are Java classes that handle HTTP requests and responses.
JSP allows embedding Java code in HTML pages, making it easier to develop dynamic web applications.
  - Enterprise JavaBeans (EJB):
EJB provides a component-based architecture for building distributed enterprise applications. It includes session beans, entity beans, and message-driven beans.
  - JDBC (Java Database Connectivity):
JDBC is a Java-based API for interacting with relational databases, enabling developers to execute SQL queries and updates from Java applications.
  - JMS (Java Message Service):
JMS is a messaging API that allows Java EE applications to communicate asynchronously by sending and receiving messages.
  - JTA (Java Transaction API):
JTA is used for managing distributed transactions in Java applications, ensuring consistency and reliability across multiple operations.
  - JCA (Java Connector Architecture):
JCA provides a standard architecture for connecting the Java EE platform to heterogeneous enterprise information systems.
  - JPA (Java Persistence API):
JPA is a Java framework for managing relational data in enterprise applications, offering a standardized way to interact with databases.
  - JavaMail API:
JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications.
  - Security APIs:
Java EE includes security APIs for implementing authentication, authorization, and secure communication in enterprise applications.
  - Web Services (JAX-RS and JAX-WS):
JAX-RS is for building RESTful web services, while JAX-WS is for SOAP-based web services.
  - Annotations:
Annotations are used for metadata and configuration in Java EE applications, reducing the need for extensive XML configuration files.

## **Servlets**
- Servlets are Java classes that extend the capabilities of servers to enhance the functionality of a web server. 
- They provide a way to generate dynamic content and handle requests and responses programmatically. 
- Servlets are part of the Java EE (Enterprise Edition) specification and are commonly used for building web applications.
- Key Features
  - Server-Side Processing:
Servlets are executed on the server side, handling requests from web clients and generating responses.
  - Lifecycle:
Servlets follow a lifecycle with methods like init(), service(), and destroy() that are invoked at different stages.
  - HTTP Protocol:
Servlets are particularly designed to work with the HTTP protocol, handling HTTP requests and responses.
  - Java EE Integration:
Servlets are part of the Java EE specification and can be deployed on Java EE-compliant servers like Tomcat, Jetty, or WildFly.
  - Example Use Case:
Servlets are used to process form submissions, handle user authentication, and generate dynamic content based on user input.

```java
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.getWriter().println("Hello, Servlet!");
    }
}
```

## **JSP**
- JSP is a technology that simplifies the process of developing web pages that include dynamic content. 
- It allows embedding Java code directly into HTML pages, making it easier to create dynamic web content. 
- JSP pages are converted into servlets during runtime.
-  Key Features
    - HTML Integration:
JSP allows embedding Java code within HTML pages, providing a way to dynamically generate content within the HTML structure.
    - Extension of Servlets:
JSP is often considered an extension of servlets as JSP pages are ultimately compiled into servlets before execution.
    - Tag Libraries:
JSP provides tag libraries, such as JavaServer Pages Standard Tag Library (JSTL), to simplify common tasks like iteration and conditionals.
    - Separation of Concerns:
JSP encourages a separation of concerns by allowing designers to work on HTML structure while developers focus on Java code embedded within the pages.
    - Expression Language (EL):
JSP includes Expression Language (EL), a simplified way to access data stored in JavaBeans or other objects.
    - Example Use Case:
JSP pages are used to create dynamic web pages with mixed HTML and Java code, making it easier to generate content dynamically.

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Example</title>
</head>
<body>
    <%
        String message = "Hello, JSP!";
        out.println(message);
    %>
</body>
</html>
```
#### Integration of Servlets and JSP:
- Servlets and JSP are often used together in web applications.
- Servlets handle the logic, processing user input and managing business logic.
- JSP pages are used for the presentation layer, allowing designers to work on the HTML structure.

## **EJB**

- Enterprise JavaBeans (EJB) is a specification within the Java Platform, Enterprise Edition (Java EE).
- It defines a set of server-side, distributed components. 
- These components are designed to simplify the development of large-scale, enterprise-level applications by providing a standardized architecture and set of services.
- Key components
  - Component Model:
EJB provides a component model where business logic is encapsulated in reusable and deployable components. These components are known as Enterprise Beans.
  - Distributed Computing:
EJB supports distributed computing, allowing enterprise beans to be deployed on different machines in a network. This promotes scalability and load balancing.
  - Transaction Management:
EJB offers built-in support for transaction management. It allows developers to define methods that participate in transactions, ensuring data consistency and reliability.
  - Security:
EJB provides a security model that allows developers to define access controls and permissions for enterprise beans. This ensures that only authorized clients can access certain functionalities.
  - Concurrency Control:
EJB supports concurrency control, allowing multiple clients to access and use enterprise beans simultaneously. It manages the synchronization and locking mechanisms to prevent data corruption.
  - Persistence:
EJB supports the Java Persistence API (JPA) for database interaction. This allows enterprise beans to persist and retrieve data from databases seamlessly.
  - Lifecycle Management:
EJB components have a well-defined lifecycle, including methods like ejbCreate, ejbRemove, and others, which are invoked at different stages of the component's existence.
  - Types of Enterprise Beans:
Session Beans: Represent business logic and can be stateful or stateless.
Entity Beans: Represent persistent data stored in a database.
Message-Driven Beans: Handle asynchronous messaging.

## **Beans**
-  Beans are components designed to encapsulate business logic in a distributed, scalable, and transactional manner.

## **Stateless Beans**
- No Client State: Stateless beans do not maintain any conversational state between client invocations. Each method call is independent of previous calls.
- Stateless beans are designed for maximum reuse. They can be used by multiple clients concurrently.
- Scalability: Because there is no state to maintain, stateless beans are generally more scalable and suitable for applications with a large number of clients.
- Useful when the business logic is stateless and doesn't depend on previous interactions and when scalability and performance are critical requirements.


## **Stateful Beans**
- Client State: Stateful beans maintain a conversational state with a specific client across multiple method invocations. They remember the state of the client.
- Dedicated to a Client: A stateful bean is dedicated to a specific client during its lifecycle. The state is retained between method calls for that client.
- Complex Conversations: Useful for scenarios where a sequence of method calls must be maintained in a conversation with the client.
- Useful when conversational state needs to be maintained across multiple method calls for a specific client and
the application requires complex interactions with a client.

## JAX-RS v/s JAX-WS
| SOAP     | REST     |
| ------------- | ------------- |
| Suitable for building lightweight, scalable, and stateless RESTful services.
 | Suitable for building more complex, enterprise-level web services. |
| Preferred for web and mobile applications where simplicity and flexibility are crucial.| Preferred in scenarios where standardized messaging, security, and transaction support are necessary. |
| SOAP is a protocol, a set of rules that dictate how web services should communicate.| REST is an architectural style, not a protocol.
| It typically uses XML as the message format. | It relies on a stateless, client-server communication model. |
| SOAP can work over a variety of transport protocols, including HTTP, SMTP, and more. | REST primarily uses HTTP as the transport protocol. |


## JAX-RS (Java API for RESTful Web Services)
- JAX-RS is designed for building RESTful web services, where communication is based on the principles of Representational State Transfer (REST).
- Key Features:

  - Annotations such as @Path, @GET, @POST, etc., are used to define the URI paths and HTTP methods for resource endpoints.
  - Supports the creation of resource classes that represent entities in a RESTful architecture.
  - Provides support for content negotiation, allowing clients to request different representations (JSON, XML, etc.) of the same resource.

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    public String sayHello() {
        return "Hello, World!";
    }
}
```
- We have to use JAX-RS for building RESTful web services where resources are identified by URIs, and data is typically represented in formats like JSON or XML.
- JAX-RS focuses on resource-oriented architecture and uses HTTP methods for communication.
- JAX-RS allows multiple representations (JSON, XML, etc.) of the same resource.

## JAX-WS (Java API for XML Web Services)
- JAX-WS is designed for building web services that use XML as the data format for communication. It is often associated with SOAP (Simple Object Access Protocol) web services.
- Key Features:

  - Annotations such as @WebService, @WebMethod, etc., are used to define the service interface and methods.
  - Supports the generation of WSDL (Web Services Description Language) documents, which describe the service and its operations.
  - Provides a programming model for building both server-side (provider) and client-side (consumer) components of a web service.


```java
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class HelloWorldService {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
```
- We have to use JAX-WS for building SOAP-based web services that use XML for communication and provide a standardized protocol for interoperability.
- JAX-WS is often associated with RPC (Remote Procedure Call) style communication using SOAP.
- JAX-WS primarily uses XML for communication and is often associated with the WS-* stack for additional features like security and transactions.   

