# **System Design**

## **E-commerce application**
#### Search Service
- Use ElasticSearch for fast and efficient search functionality.
- Implement caching using Redis or Memcached to store frequently accessed search results and reduce search latency.
- Use a NoSQL database like MongoDB for storing product metadata and attributes.

#### Cart Service
- Utilize MySQL database to manage cart items for each user.
- Implement RESTful APIs for adding/removing items from the cart, updating quantities, and fetching cart details.
- Use Redis for caching frequently accessed cart data to improve response times.

#### Place Order Service
- Use MySQL database to store order information such as user details, products, quantities, and order status.
- Implement RESTful APIs for placing orders, updating order status, and retrieving order history.
- Integrate with the Notification Service to send email notifications for order confirmation, shipment updates, and delivery status.

#### Assign Delivery Partner Service
- Use MySQL database to store delivery partner details such as name, contact information, availability, and service areas.
- Implement APIs for assigning delivery partners to orders based on location, availability, and order size.
- Ensure synchronization with the Place Order Service to update order status and notify users about assigned delivery partners.

#### Notification Service
- Implement an email notification service using SMTP or a third-party email service provider (e.g., SendGrid, Amazon SES).
- Create templates for different notification types (order confirmation, shipment updates, delivery status) and dynamically populate user-specific details.
- Integrate with other services (Place Order, Assign Delivery Partner) to trigger email notifications based on specific events and status changes.

#### Synchronous Communication
- Use REST templates for synchronous communication between microservices within the application.
- Implement Feign clients for declarative RESTful API calls, simplifying service-to-service communication and reducing boilerplate code.

#### Asynchronous Communication (Kafka)
- Integrate Apache Kafka for asynchronous communication between components, enabling real-time event processing and data streaming.
- Use Kafka topics for publishing and subscribing to events such as order placement, status updates, and notification triggers.
- Implement Kafka consumers to process messages asynchronously and update database states or trigger actions accordingly.

#### Rate Limiter
- Implement a rate-limiting mechanism to prevent spam hits and control the number of requests allowed per user or IP address.
- Use algorithms like Token Bucket or Leaky Bucket to manage request rates and enforce rate limits at the API gateway or service level.
- Monitor and log rate-limited requests to analyze traffic patterns and adjust rate-limiting configurations as needed.

#### Other Required Components
- API Gateway: Use an API gateway (e.g., Netflix Zuul, Kong) to manage incoming requests, enforce security policies, and route traffic to appropriate microservices.
- Authentication & Authorization: Implement JWT (JSON Web Tokens) for user authentication and authorization, ensuring secure access to protected resources.
- Load Balancing: Use a load balancer (e.g., Nginx, HAProxy) to distribute incoming traffic across multiple instances of microservices for scalability and high availability.
- Monitoring & Logging: Implement logging mechanisms (e.g., ELK stack, Splunk) and monitoring tools (e.g., Prometheus, Grafana) to track system performance, detect errors, and troubleshoot issues proactively.

#### Interconnections
- Users interact with the frontend UI, which sends requests to the API Gateway.
- The API Gateway routes requests to appropriate microservices (Search, Cart, Place Order, Assign Delivery Partner).
- Microservices communicate synchronously using REST templates and Feign clients for real-time interactions (e.g., adding items to cart, placing orders).
- Asynchronous events (e.g., order placement, status updates) are published to Kafka topics for processing.
- The Notification Service subscribes to relevant Kafka topics to trigger email notifications based on events and status changes.
- Rate limiting is enforced at the API Gateway to prevent spam hits and manage request rates per user/IP address.

## **SAGA Design Pattern**
- The Saga design pattern is a pattern used in distributed systems to manage long-lived transactions that involve multiple steps across different services or databases.
- It's particularly relevant in microservices architectures where each microservice has its own database and transactions can span multiple microservices. 
- The goal of the Saga pattern is to ensure data consistency and transactional integrity in such distributed environments.

#### Scenarios in E-commerce Website:

Order Placement:

Scenario: A customer places an order for multiple items, involving inventory reservation, payment processing, and shipping initiation.
Saga Steps:
Inventory Service Step: Reserve items in the inventory.
Payment Service Step: Process payment for the order.
Shipping Service Step: Initiate shipping of the ordered items.
Compensation Actions:
If inventory reservation fails, release the reserved items.
If payment processing fails, refund the payment.
If shipping initiation fails, cancel the shipment.
Orchestration: Saga orchestrator manages the order processing steps and compensations.

Order Cancellation:

Scenario: A customer cancels an order before it's shipped, requiring reversal of inventory reservation and payment processing.
Saga Steps:
Inventory Release Step: Release the reserved items in the inventory.
Payment Refund Step: Refund the payment for the cancelled order.
Compensation Actions:
If inventory release fails, log an error for manual intervention.
If payment refund fails, log an error for manual intervention.
Orchestration: Saga orchestrator coordinates the cancellation process and compensations.

Inventory Replenishment:

Scenario: Inventory levels are low for certain products, triggering a replenishment process involving supplier communication and stock update.
Saga Steps:
Supplier Communication Step: Place an order with the supplier for replenishment.
Inventory Update Step: Update the inventory with the received stock.
Compensation Actions:
If supplier communication fails, retry or escalate to manual intervention.
If inventory update fails, log an error for manual intervention.
Orchestration: Saga orchestrator manages the replenishment process and compensations.

User Registration with Bonus Offer:

Scenario: A new user registers on the e-commerce platform with a bonus offer that includes account credit and discount coupons.
Saga Steps:
Account Credit Step: Add credit to the user's account as per the bonus offer.
Coupon Generation Step: Generate and allocate discount coupons to the user.
Compensation Actions:
If account credit fails, revoke the user's bonus offer.
If coupon generation fails, rollback the allocated coupons.
Orchestration: Saga orchestrator handles the user registration process and compensations.

---
- I was part of a Healthcare Imaging Platform based out of North America. This platform was used by Healthcare Institutions like Medical Diagnostic Labs and Hospitals to view and manipulate images that is received from scanning machines. The tech stack of this project was in java version 8, backend web framework was J2EE, backend database was PostgreSQL. 
- This was great learning experience for me, I got the opportunity to work Healthcare domain specific technologies like HL7 and DICOM's.
- I also got the opportunity to collaborate with the Platform team to configure the Amazon EC2 instances with our backend environment. We also used Amazon RDS for the PostgreSQL instances. I worked on integrating Amazon S3 APIs into our backend application for seamless image upload, retrieval, and processing.
- My primary role in this project was to understand the various DICOM API's present in DCM4CHE, DCM4CHE is another Healthcare Imaging Platform that is open source and out application is build on top of DCM4CHE and we reuse most of the API's. In some scenarios the client would request us to add some changes based on the filtering and searching criteria and we would do the same. I also had to perform the unit testing for these features using JUnit. I also had to work with the front end engineers to ensure that the backend API's were properly integrated.

---
As a backend developer on the Healthcare Imaging platform deployed in the AWS cloud, I played a pivotal role in integrating various AWS services to enhance scalability, reliability, and performance. Specifically, we leveraged Amazon EC2 for virtual servers hosting our Java 8 application, Amazon RDS for PostgreSQL to manage the backend database, and Amazon S3 for storing and accessing DICOM images efficiently.

To ensure seamless integration with AWS, I collaborated with the Platform Team to configure and manage these services effectively. This involved setting up EC2 instances with the necessary Java and J2EE environments, configuring security groups, and managing instance scaling for optimal performance and cost-efficiency.

For database management, we utilized Amazon RDS to easily provision, scale, and manage PostgreSQL instances, ensuring data integrity and availability. I implemented database backups, monitoring, and optimization strategies to maintain system reliability.

Additionally, we utilized Amazon S3 for storing DICOM images securely, implementing access control policies and encryption mechanisms to protect sensitive patient data. I worked on integrating S3 APIs into our backend application for seamless image upload, retrieval, and processing.

In terms of dependency management, we used Maven or Gradle as build automation tools to manage project dependencies and package our Java application for deployment. Continuous Integration/Continuous Deployment (CI/CD) pipelines were set up using tools like Jenkins or AWS CodePipeline to automate the build, test, and deployment processes, ensuring rapid and reliable delivery of updates to the AWS cloud environment.

Deploying to the AWS cloud typically involves the following steps:

AWS Account Setup: Create an AWS account and configure necessary permissions for accessing AWS services.

Infrastructure Planning: Determine the required AWS services (e.g., EC2, RDS, S3) based on application needs and scalability requirements.

Environment Setup: Configure AWS resources such as EC2 instances, RDS databases, S3 buckets, and networking settings (VPC, subnets, security groups).

Application Deployment: Deploy the Java application to EC2 instances using tools like SSH, AWS CLI, or deployment scripts. Set up application monitoring and logging using AWS CloudWatch.

Database Configuration: Set up and configure the database (e.g., PostgreSQL on RDS) including schema creation, data migration, and performance tuning.

Storage and File Management: Utilize Amazon S3 for storing and accessing files/images securely. Implement access control and encryption as needed.

Security and Compliance: Configure security settings such as IAM roles, security groups, SSL certificates, and encryption to ensure data protection and compliance with industry standards.

Scaling and Monitoring: Implement auto-scaling policies for EC2 instances based on traffic patterns. Set up monitoring and alerts using AWS CloudWatch for proactive system management.

Backup and Disaster Recovery: Implement backup and recovery strategies for both application data (RDS snapshots) and stored files (S3 versioning, cross-region replication).

Testing and Optimization: Perform thorough testing (unit, integration, performance) of the deployed application and optimize AWS resources for cost-efficiency and performance.
