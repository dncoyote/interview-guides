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

## SOAP v/s REST
| SOAP     | REST     |
| ------------- | ------------- |
| Often used in enterprise-level applications. | Preferred for mobile and web applications due to its simplicity and scalability. |
| Suitable for scenarios requiring a high level of security and ACID-compliant transactions. | Suitable for scenarios where statelessness and simplicity are critical. |
| SOAP is a protocol, a set of rules that dictate how web services should communicate.| REST is an architectural style, not a protocol.
| It typically uses XML as the message format. | It relies on a stateless, client-server communication model. |
| SOAP can work over a variety of transport protocols, including HTTP, SMTP, and more. | REST primarily uses HTTP as the transport protocol. |

## JAX-RS v/s JAX-WS
| SOAP     | REST     |
| ------------- | ------------- |
| Suitable for building lightweight, scalable, and stateless RESTful services.
 | Suitable for building more complex, enterprise-level web services. |
| Preferred for web and mobile applications where simplicity and flexibility are crucial.| Preferred in scenarios where standardized messaging, security, and transaction support are necessary. |
| SOAP is a protocol, a set of rules that dictate how web services should communicate.| REST is an architectural style, not a protocol.
| It typically uses XML as the message format. | It relies on a stateless, client-server communication model. |
| SOAP can work over a variety of transport protocols, including HTTP, SMTP, and more. | REST primarily uses HTTP as the transport protocol. |

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

## **SQL**

## **Primary key v/s Unique key v/s Foreign key**

#### Primary key

- A primary key is a column or a set of columns in a database table that uniquely identifies each row (record) in the table.
- It ensures that each row in the table is distinct, and there are no duplicate entries for the primary key values.
- Enforces the uniqueness and non-null property of the primary key columns.
  Eg: id in StudentTable

#### Unique key

- A unique key, often referred to as a unique constraint, is a set of one or more columns in a database table that must contain unique values within the table.
- Unique key does not necessarily need to be used to identify individual rows. It's primarily used to ensure that certain columns or combinations of columns have distinct values.
  eg: email in StudentTable

#### Foreign key

- A foreign key is a column or a set of columns in a table that establishes a link between data in two tables.
- Foreign keys are used to create relationships between tables, allowing you to retrieve related data from different tables through JOIN operations.
- Foreign key in a child table typically references the primary key in the parent table, it helps maintain data consistency and prevent orphaned data.
  Eg: studentId in DepartmentTable

## **GROUP BY**

- `GROUP BY` clause is used to group rows that have the same values in specified columns into summary rows.
- Data Aggregation

```
SELECT product_category, SUM(sales_amount) as total_sales
FROM sales
GROUP BY product_category;
```

- Data Summarization

```
SELECT DATE(order_date), SUM(order_total) as daily_total
FROM orders
GROUP BY DATE(order_date);
```

- Data Cleansing

```
SELECT email, COUNT(*) as count
FROM customers
GROUP BY email
HAVING count > 1;
```

- Data Segmentation

```
SELECT CASE
          WHEN total_purchases >= 10 THEN 'Frequent Buyer'
          ELSE 'Occasional Buyer'
       END as buyer_segment,
       COUNT(*) as customer_count
FROM customers
GROUP BY buyer_segment;
```

- Statistical Analysis

```
SELECT FLOOR(value/10)*10 as bin, COUNT(*) as frequency
FROM data_values
GROUP BY bin;
```

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

## **Microservices**

## **API Gateway**

- API Gateway is a server or service that acts as an entry point for a collection of microservices or backend services in a distributed computing environment.

## **Load Balancing in API Gateway**

## **Service Discovery**

## **Eureka Server**

## **@FeignClient**

## **Transactional**

## **Docker**

## **Docker file contents**

## **Kubernetes**

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

## **Microservices Architecture**

- Event driven architecture
