# **Microservices**

## Microservices
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

## Service Discovery

## API Gateway
- API Gateway is a server or service that acts as an entry point for a collection of microservices or backend services in a distributed computing environment.

## Load Balancing in API Gateway

## Eureka Server

## Centralized Config Server

## Distributed Tracing

Distributed tracing is a method used to monitor and debug distributed systems, particularly in modern microservices architectures. It involves tracking and logging the flow of requests as they traverse through multiple services or components in a distributed system.

In a distributed tracing system, each service or component involved in processing a request generates and propagates a unique identifier known as a trace or span ID. As the request moves through various services, these identifiers are passed along, allowing the tracing system to link together all the individual spans to form a complete trace of the request's journey through the system.

## @FeignClient

How to automate deploy and monitor
