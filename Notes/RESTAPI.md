# **REST API**

## REST API
- REST API (Representational State Transfer Application Programming Interface) is a type of web API that uses HTTP requests to perform operations on data.
- It is commonly used in web services development to provide interoperability between different systems on the internet.
- RESTful APIs are built on top of the HTTP protocol and use standard HTTP methods (GET, POST, PUT, DELETE) to perform CRUD (Create, Read, Update, Delete) operations on resources.
- Resources are represented using standard formats such as JSON (JavaScript Object Notation) or XML (eXtensible Markup Language). Clients can request specific representations of resources based on their needs.
- RESTful APIs can include hypermedia links within resource representations to allow clients to navigate between related resources dynamically.

## **HTTP Requests**

- HTTP is the protocol used by web browsers and servers to communicate and exchange information.
- An HTTP request is a message sent by a client, typically a web browser or an application, to request data from a server.
- HTTP request typically consists of the following components:

  - HTTP Method: This indicates the type of request being made, such as GET, POST, PUT, DELETE, etc. Each HTTP method has a specific purpose, such as retrieving data (GET), submitting data (POST), updating data (PUT), or deleting data (DELETE).
    - `GET`: Retrieve a representation of a resource.
    - `POST`: Create a new resource.
    - `PUT`: Update an existing resource or create a new resource if it doesn't exist.
    - `DELETE`: Remove a resource.
    - `PATCH`: Partially update a resource.
    - `OPTIONS`: Retrieve information about the communication options available for a resource.
    - `HEAD`: Retrieve the headers of a response without the body.
  - URL (Uniform Resource Locator): This specifies the web address of the resource being requested. It includes the protocol (e.g., http:// or https://), the domain name (e.g., www.example.com), and the path to the resource (e.g., /images/pic.jpg).
  - Headers: These are key-value pairs that provide additional information about the request, such as the type of data being sent, the language preference, caching settings, and more. Headers are used to convey meta-information about the request to the server.
  - Body (optional): This is the data, such as form data or JSON, that is sent as part of the request. It is typically used in POST, PUT, and DELETE requests to send data to the server.

- Once the HTTP request is sent to the server, the server processes the request and generates an HTTP response, which is sent back to the client with the requested data. The response typically contains a response status code indicating the outcome of the request (e.g., 200 OK, 404 Not Found, etc.), headers with additional information, and optionally, a response body with the requested data.

## **Statelessness**
- RESTful APIs are stateless, meaning that each request from a client to the server must contain all the information necessary to understand and process the request. The server does not maintain any client state between requests. Statelessness makes REST APIs scalable and easy to cache.

## **API Versioning**
- API versioning is the practice of managing changes to an API by assigning unique identifiers (versions) to different iterations of the API. 
- It allows developers to introduce updates, enhancements, and changes to the API without breaking existing client applications that rely on it.

#### Types
- URI Versioning
    - `https://api.example.com/v1/resource`
- Query Parameter Versioning
    - `https://api.example.com/resource?version=1`
- Header Versioning
    - In header versioning, the version number is included as a custom header in the API request.

## **http v/s https**
#### http
- HTTP is a protocol used for transmitting data over the World Wide Web.
- It is a stateless protocol, meaning that each request from a client to a server is independent and not affected by previous requests.
- HTTP operates over TCP/IP (Transmission Control Protocol/Internet Protocol).
- It is widely used for transferring web pages, images, videos, and other resources between web servers and web browsers.
- HTTP does not provide any encryption or security mechanisms, making it vulnerable to eavesdropping, tampering, and data interception.

#### https
- HTTPS is a secure version of HTTP that uses encryption to protect the confidentiality and integrity of data transmitted over the internet.
- It is based on HTTP but adds an additional layer of security provided by SSL/TLS (Secure Sockets Layer/Transport Layer Security) protocols.
- HTTPS operates over TCP/IP, typically using port 443.
- It encrypts data transmitted between the client and server, preventing unauthorized access and tampering by third parties.

## **Perfomance of RESTful Endpoints**
#### Implement caching
- You can utilize caching mechanisms to store frequently accessed data in memory or in a distributed cache. 
- This helps reduce the need to fetch data from the database or perform expensive computations repeatedly.
- Ehcache, Caffeine, Redis, and Hazelcast.

#### Optimize database queries
- Optimize database queries by indexing frequently queried fields, avoiding unnecessary joins, and using appropriate database design techniques such as denormalization. 
- Use database profiling tools to identify and optimize slow queries.
- Ensure that your database tables are appropriately indexed based on the columns frequently used in queries. Indexes speed up data retrieval by enabling the database to locate rows more efficiently
- Craft SQL queries that retrieve only the necessary data and avoid unnecessary joins, distinct operations, subqueries, or complex aggregations.
- Implement pagination or limit the number of rows returned by queries to prevent the retrieval of large result sets. Use techniques like `LIMIT` and `OFFSET`, and the `Pageable` interface.

#### Asynchronous processing
- Performing asynchronous processing in a Spring Boot application involves executing tasks concurrently without blocking the main thread, thereby improving responsiveness and resource utilization.

#### Horizontal scaling
- Scale your application horizontally by deploying multiple instances of your application behind a load balancer. 
- This allows you to distribute incoming traffic across multiple servers and handle increased load effectively.

## **Challenges**

### Database Query Optimization
##### Scenario
- During a routine system audit, we discovered that the query performance for fetching patient medical history associated with DICOM images was degrading over time, leading to slower response times for clinicians accessing patient records during diagnosis.
- The issue was traced to inefficient database queries that lacked proper indexing and optimization strategies. As a result, fetching patient medical history alongside DICOM images was causing unnecessary database load and impacting overall system performance.
##### Solution
- Conducted a comprehensive analysis of the database schema, query execution plans, and indexing strategies using PostgreSQL's EXPLAIN command to identify slow-performing queries and potential optimization opportunities.
- Introduced appropriate indexes on key columns involved in join operations and filtering conditions to improve query execution speed.
- Rewrote complex queries using optimized SQL syntax, utilizing PostgreSQL's query planner to generate efficient execution plans and minimize unnecessary data retrieval.
- Implemented query caching at the application layer using Spring's caching annotations to cache frequently accessed patient medical history data, reducing database round-trips and improving response times for subsequent requests.
##### Scenario
- During peak hours, radiologists experienced delays when retrieving DICOM image metadata for large datasets, impacting their ability to analyze patient images efficiently and make timely diagnoses.
- The challenge stemmed from inefficient database queries that were not optimized for fetching DICOM image metadata in bulk. As a result, the application struggled to handle concurrent requests from multiple radiologists, leading to performance bottlenecks and increased response times.
##### Solution
- Identified the specific queries responsible for fetching DICOM image metadata and analyzed their execution plans and performance metrics using PostgreSQL's query profiling tools.
- Optimized query performance by restructuring queries, adding appropriate indexes, and leveraging PostgreSQL's query optimizer to improve query execution speed.
- Implemented a caching mechanism for frequently accessed DICOM image metadata, using Redis as a distributed cache to store and serve cached metadata, reducing database load and improving response times.
- Monitored cache hit rates, cache expiration policies, and cache effectiveness to ensure optimal utilization of the caching layer and minimize data retrieval from the database for improved system performance.

### Caching Strategies
##### Scenario
- During a system load test, we observed that repeated requests for DICOM image thumbnails were resulting in high server load and increased response times, impacting the user experience for clinicians and researchers accessing image previews.
- The challenge stemmed from the lack of a caching mechanism for DICOM image thumbnails, leading to repeated generation and retrieval of thumbnails for each request. This resulted in unnecessary server load and slower response times, especially during peak usage periods.
##### Solution
- Implemented a caching layer for DICOM image thumbnails using Redis as a distributed cache to store pre-generated thumbnails based on image identifiers.
- Modified the application logic to first check the cache for thumbnail availability before generating new thumbnails, reducing the computational overhead and improving response times for thumbnail requests.
- Configured cache expiration policies and eviction strategies to manage cache size and freshness, ensuring that cached thumbnails are updated periodically and invalidated when necessary.
- Monitored cache utilization metrics, cache hit rates, and cache miss rates to fine-tune caching configurations and optimize the caching layer for improved performance and scalability.
##### Scenario
- Clinicians accessing patient reports and studies frequently encountered delays when retrieving historical study data and reports, impacting their ability to make informed medical decisions in real-time.
- The issue arose from the lack of caching for historical study data and reports, leading to repeated database queries for retrieving the same data for different users. This resulted in increased server load and slower response times, particularly during peak usage hours.
##### Solution
- Implemented a caching strategy for historical study data and reports using Spring's caching annotations and an in-memory cache (e.g., ConcurrentHashMap) to store and serve cached data.
- Modified the application logic to first check the cache for historical study data and reports before querying the database, reducing the number of database round-trips and improving response times for subsequent requests.
- Configured cache expiration policies and eviction mechanisms to ensure data freshness and consistency, periodically updating cached data and invalidating outdated entries.
- Monitored cache utilization metrics, cache hit rates, and cache efficiency to optimize caching configurations and enhance the overall performance of data retrieval operations for clinicians and researchers.

### Asynchronous Processing
##### Scenario
- During peak hours, the application experienced delays in processing large DICOM image uploads, affecting the responsiveness of the system and causing user frustration.
- The challenge was due to synchronous processing of image uploads, where the application waited for each image to be fully processed before moving on to the next upload. This synchronous behavior led to blocking user requests and increased response times.
##### Solution
- Implemented asynchronous processing for DICOM image uploads using Spring's @Async annotation or CompletableFuture to offload image processing tasks to separate threads.
- Utilized a message queue system such as RabbitMQ or Kafka to decouple image processing tasks from the main application flow, allowing concurrent processing of multiple image uploads.
- Introduced a background processing service to handle image uploads asynchronously, monitoring progress, and notifying users upon completion to improve user experience and system responsiveness.
- Configured thread pool settings, concurrency limits, and task scheduling strategies to optimize resource utilization and ensure efficient handling of concurrent image processing tasks.

### Caching HTTP Responses
##### Scenario
- The application frequently served static resources such as DICOM image thumbnails, CSS files, and JavaScript libraries, resulting in increased server load and longer response times during peak usage periods.
- The challenge was to reduce server load and improve response times for static resource requests by implementing an efficient caching strategy for HTTP responses.
##### Solution
- Implemented server-side caching using NGINX or Apache HTTP Server as a reverse proxy cache to cache static resources like DICOM image thumbnails, CSS files, and JavaScript libraries.
- Configured caching directives such as Cache-Control headers (e.g., max-age, public, private), ETag headers, and Last-Modified headers to control caching behavior and cache expiration policies.
- Utilized content delivery networks (CDNs) like Amazon CloudFront or Cloudflare to cache static resources at edge locations closer to end-users, reducing latency and improving content delivery speed.

## **Debugging an issue in a legacy system**
- When debugging an issue in a legacy system, it's essential to follow a systematic approach to identify, isolate, and resolve the problem effectively
### Database Query Performance Issue
- Users report slow response times when querying patient records in the legacy system.
##### Approach
- Reproduce the Issue:
  - Identify the specific scenario or user workflow that triggers the slow response times.
  - Reproduce the issue consistently to understand its scope and impact on system performance.
- Collect Data:
  - Gather relevant data such as query execution plans, database logs, and performance metrics (CPU usage, memory usage, disk I/O) during the slow query execution.
  - Use database profiling tools (e.g., EXPLAIN command in SQL databases) to analyze query execution plans and identify inefficient query patterns.
- Analyze Code and Queries:
  - Review the application codebase and SQL queries associated with the slow-performing feature.
  - Look for potential bottlenecks, suboptimal query structures, missing indexes, or excessive data fetching that could contribute to the performance issue.
- Optimize Queries:
  - Refactor and optimize SQL queries by adding appropriate indexes, rewriting complex joins or subqueries, and reducing  unnecessary data retrieval.
  - Utilize database tuning techniques (e.g., query caching, query hints, query optimization hints) to improve query performance.
- Test and Validate:
  - Apply the optimized SQL queries to the legacy system and conduct performance testing to validate improvements.
  - Monitor performance metrics and user feedback to ensure that the issue has been resolved satisfactorily. 

### Application Crash or Error
- The legacy system frequently crashes or throws unexpected errors during specific user interactions.
##### Approach
- Replicate the Issue:
  - Identify the sequence of user actions or inputs that consistently trigger the application crash or error.
  - Replicate the issue in a controlled environment (e.g., development or staging environment) to analyze its root cause.
- Review Error Logs:
  - Access and review error logs, crash reports, stack traces, and exception messages generated by the legacy system when the issue occurs.
  - Look for common error patterns, error codes, and stack trace information to understand the nature of the problem.
- Debugging Tools:
  - Use debugging tools and techniques appropriate for the programming language and technology stack of the legacy system.
  - Utilize integrated development environments (IDEs) with debugging capabilities, logging frameworks, and debugging libraries (e.g., log4j, SLF4J) to trace code execution and identify code paths leading to errors.
- Code Inspection:
  - Inspect the relevant sections of the codebase associated with the error-prone feature or functionality.
  - Look for potential coding mistakes, logic errors, null pointer exceptions, memory leaks, or resource leaks that could cause the application to crash or behave unpredictably.
- Isolate and Test:
  - Isolate the suspected code segments or modules causing the issue and create test cases to reproduce the error in a controlled environment.
  - Apply code fixes, error handling mechanisms, and defensive programming practices to address identified issues and prevent future occurrences.
- Regression Testing:
  - Conduct regression testing to verify that the code changes or fixes have resolved the issue without introducing new bugs or regressions.
  - Validate the stability and reliability of the legacy system through thorough testing across different user scenarios and edge cases.

> "In a legacy system I worked on, there was a limitation where I couldn't directly pass data as a Hibernate response with sorting and limiting features. Instead, I had to extract the data from the database using Hibernate, process it within the backend using Java data structures, apply sorting and limiting logic programmatically, and then pass the processed data as a structured object to the front end engineer. This workaround was necessary due to the system's inability to directly handle sorting and limiting operations in the database queries."
- The data volume might be too large to handle in-memory sorting and pagination effectively without impacting system performance or causing memory issues.
- React's component-based architecture and virtual DOM rendering require structured data in a specific format (e.g., JSON objects) for efficient rendering and updating of UI components.
- The format or structure of data processed and passed from the backend (handled by Hibernate and Java data structures) might not align with the expected data format or schema in React components, leading to rendering errors or data inconsistencies.
- Differences in configuration and dependency management between J2EE and Spring Boot, requiring updates or modifications to ensure compatibility and optimal performance.
- Adapting legacy codebase's architecture, design patterns, and business logic to fit the Spring Boot framework's conventions and best practices.
- Migrating and integrating existing data access layers, ORM mappings, and persistence strategies from J2EE technologies (e.g., Hibernate) to Spring Boot's data access frameworks (e.g., Spring Data JPA).
- Handling potential compatibility issues or deprecated features between older J2EE versions and newer Spring Boot versions, requiring refactoring or rewriting code segments to align with modern standards and APIs.

- The Healthcare Imaging Project was quite challenging, especially in terms of the Health Domain specific technologies like HL7 and DICOM. 
- There were lot of challenging scenarios for me.
- One that comes to mind is when the client had assigned a task to me that involved a simple API call from legacy system done in J2EE, get the data in the modern Spring Boot application and pass it as response to the UI.
- This simple scenario became quite challenging, I had to go through multiple iterations, eventually I had to transplant the entire code flow from the J2EE legacy system to the Spring boot application as we were not allowed to do any changes to the legacy system.
- So I will explain why it was challenging, once implemented this API call, during developer testing we found out that the response from this API was not in a compatible format with the Component based REact front end.
- So we devised a solution that will take the response from the legacy system and format it into a response compatible with the UI. So this worked.
- But the sorting and pagination functionalities were not supported by the legacy system. So we went back to the code and programatically handled the sorting and pagination using java. During developer testing, all looked good, there were some edgecases but that could be handled as well.
- But when we presented this to our client, they felt that this solution would reduce the systems performance as we were sorting and paginating using in-memory.
- So that is when we presented another solution where we would transplant the entire workflow from the legacy system to the modern app. This was very challenging for me then, I mean looking back at it now, this is a simple lift and shift. But then I was maybe 3 or 4 years experienced. I had constantly go back and forth between the legacy and modern app, debug both systems.
- There were differences in configuration and dependency management between J2EE and Spring Boot, I had to handle those.
- I had to adapt the legacy codebase's architecture, design patterns, and business logic to fit the Spring Boot framework's conventions and best practices. This took me a lot of additional man hours, but eventually I pulled it off and was able to get this API running.
- There was another scenario too, where I was part of the team, our task was to find a engineering solution to handle the different time zones in our application.
- So we have customers from Sweden and customers all over North America. Sweden has only one time zone but North America has almost I think 6 or 7 time zones.
- So we had to create TimezoneHandler class with a bunch of static methods with which we can reuse the code through our system. We also had to write methods to check if a particular datetime is a daylight savings time.
- So these two were some fo the challenges that I faced in my application, luckily I was able to contribute to all of them with the help of my team.
```java
public class TimeZoneUtility {
    private static final String DEFAULT_DATE_FORMAT=  = "yyyy-MM-dd HH:mm:ss";
    public static String getCurrentDateTime(String userTimeZone) {
      //
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        //
    }

    public static String formatDateTime(LocalDateTime dateTime, String dateFormat) {
       //
    }

    public static String getCurrentUtcDateTime() {
       //
    }

    public static String convertDateTimeToTimeZone(String dateTimeStr, String sourceTimeZone, String targetTimeZone) {
       //
    }

    public static String convertDateTimeToUtc(String dateTimeStr, String sourceTimeZone) {
       //
    }

    public static boolean isDaylightSavingsTime(String dateTimeStr, String timeZone) {
      //
    }
}
```
## **Coding and Deployment Pipeline**
### Coding Pipeline
##### Feature Development:
- The development team receives a requirement to implement a DICOM image upload and retrieval feature in the healthcare application.
- A developer, let's call her Emily, starts working on this feature by creating a new branch named feature/dicom-handling.
- Emily follows best practices for Git version control, committing changes regularly with descriptive commit messages.
##### Code Reviews and Quality Check:
- After completing the feature implementation, Emily opens a pull request (PR) on GitHub for code reviews.
- Team members review Emily's code changes in the PR, focusing on DICOM image upload logic, error handling, and data security.
- Automated code analysis tools integrated with GitHub, such as SonarCloud, analyze the code for code quality, security vulnerabilities, and compliance with coding standards.
##### Build Automation:
- Once the code review process is completed and any feedback addressed, Emily's PR is merged into the main branch.
- GitHub Actions CI/CD workflows are triggered automatically on the main branch update.
- Maven build automation is used to compile the code, run unit tests, and package the application into a deployable artifact (e.g., WAR or JAR file).
### Deployment Pipeline:
##### Continuous Integration and Deployment:
- The CI/CD pipeline in GitHub Actions orchestrates the deployment process.
- Docker containers are built using Dockerfiles, containing the application code, dependencies, and environment configurations.
- The Docker image is pushed to a container registry, such as Amazon ECR, for versioning and distribution.
##### Environment Configuration:
- Terraform or AWS CloudFormation templates automate the provisioning of AWS resources required for the feature, including Amazon RDS for PostgreSQL and Amazon S3 for DICOM image storage.
- Environment-specific configurations, such as database connection strings and S3 bucket settings, are managed through environment variables.
##### Deployment Strategy:
- Blue-green deployment strategy is employed to minimize downtime and ensure reliability during deployments.
- A new version of the application, containing the DICOM image handling feature, is deployed to a separate environment (e.g., blue environment).
- Automated tests, including integration tests for DICOM image upload and retrieval, are executed against the blue environment to validate functionality and performance.
- If tests pass and the deployment is successful, traffic is switched to the blue environment, and the old version (green environment) is decommissioned.
### Pipeline Execution:
##### Development and Testing:
- Emily collaborates with the QA team to ensure thorough testing of the DICOM image handling feature.
- Automated tests cover scenarios such as uploading DICOM images, retrieving images based on patient IDs, handling errors gracefully, and ensuring data security and privacy compliance.
##### Deployment and Monitoring:
- The deployment pipeline automates the deployment of the feature to staging and production environments.
- Monitoring tools, such as AWS CloudWatch or Prometheus, monitor application performance, resource utilization, and error logs post-deployment.
- Continuous monitoring and feedback loops help identify and resolve any issues or performance bottlenecks in real-time.

## **Things to keep in mind when developing a Multi-geographical application**
#### Global Content Delivery:
- Leverage CDNs or edge caching networks to cache and deliver static content (e.g., images, CSS, JavaScript) closer to end-users in different geographical locations, reducing latency and improving content delivery speed.
- Implement dynamic content caching and edge computing strategies to optimize response times for dynamic content based on user location.
#### Regional Availability Zones:
- Deploy application components, databases, and services across multiple availability zones within each geographical region to ensure high availability, fault tolerance, and disaster recovery capabilities.
- Utilize cloud provider's regional data centers or availability zones to distribute workload and mitigate single points of failure.
#### Performance Monitoring and Optimization:
- Set up comprehensive performance monitoring and analytics tools to track application performance metrics (e.g., response times, throughput, error rates) across different geographical regions.
- Continuously optimize application performance through load testing, A/B testing, and performance tuning based on real-time monitoring data and user feedback.
#### Utility classes for time-zones and currency converter:
- You can create a utility class in Java to handle time zones efficiently, especially when dealing with customers from different regions such as Sweden and North America.
- You can also expand this utility class based on your specific requirements, such as adding additional methods for handling daylight saving time, parsing date/time strings to UTC timestamps, or performing time zone conversions with offsets.
- Handling currency in a multi-geographical application involves considerations such as currency conversion, formatting, and localization based on user preferences or detected geographic regions. 
- Modify this utility class to handle additional currency-related functionalities such as currency rounding, currency symbol placement, and error handling for unsupported currency pairs. Additionally, ensure that exchange rates are updated regularly and obtained from a trusted source in a production environment.
```java
public class TimeZoneUtility {
    private static final String DEFAULT_DATE_FORMAT=  = "yyyy-MM-dd HH:mm:ss";
    public static String getCurrentDateTime(String userTimeZone) {
      //
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        //
    }

    public static String formatDateTime(LocalDateTime dateTime, String dateFormat) {
       //
    }

    public static String getCurrentUtcDateTime() {
       //
    }

    public static String convertDateTimeToTimeZone(String dateTimeStr, String sourceTimeZone, String targetTimeZone) {
       //
    }

    public static String convertDateTimeToUtc(String dateTimeStr, String sourceTimeZone) {
       //
    }

    public static boolean isDaylightSavingsTime(String dateTimeStr, String timeZone) {
      //
    }
}
```
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
