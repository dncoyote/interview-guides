# **Framework, Libraries and Technologies**

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

## **API Gateway**

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

