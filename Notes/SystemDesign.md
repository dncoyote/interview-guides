# **System Design**
## Table of Contents

 1. [Scaling](#Scaling)
    1. [Horizontal Scaling](#Horizontal)
    2. [Vertical Scaling](#Vertical)
 2. [Client-Server Architecture](#client-server-architecture)
 3. [Load Balancer](#load-balancer)
 4. [Caching](#caching)
   

# **Scaling**
Scaling is a fundamental concept in distributed systems. It helps systems handle increasing workloads efficiently. The two primary scaling strategies are horizontal scaling (scaling out) and vertical scaling (scaling up).
### Scalability 
## Horizontal
 - Involves adding more machines (nodes/servers) to a system to distribute the load.
 - Used in distributed architectures to handle more requests, storage, and computation power.
 - This scaling procedure involves adding more application servers, database replicas, or caching nodes.
 - It works by distributing requests across multiple machines using load balancers.
 - Each server runs a copy of the application, handling a portion of the traffic.
 - Data is often sharded or partitioned across multiple nodes in a database.
 - Horizontal scaling is ideal for distributed, fault-tolerant, and highly available systems.
 - Horizontal scaling is preferable when - 
    - When handling millions of users or high traffic (e.g., web applications, microservices).
    - When needing high availability and fault tolerance.
    - When using distributed databases (NoSQL) or cloud-based architectures.

## Advantages and Disadvantages
### Advantages
 - High Availability & Fault Tolerance(Resilient) – If one server fails, others can continue processing requests.
- Infinite Scalability – Can theoretically scale infinitely by adding more nodes.
- Improved Performance – Load is distributed, reducing bottlenecks.
- Better Cost Efficiency – Commodity hardware can be used instead of expensive high-performance machines.

### Disadvantages
- Increased Complexity – Requires load balancing, distributed data handling, and synchronization.
- Data Consistency Challenges – Databases may require replication, sharding, and eventual consistency mechanisms.
- More Networking Overhead – Communication between nodes introduces latency.

## Vertical
 - Involves increasing the capacity of a single machine (more CPU, RAM, storage).
 - The application continues running on a single, more powerful machine rather than multiple distributed servers.
 - It works by  upgrading the hardware of an existing server (e.g., add more RAM, CPUs, SSDs) and improving the software performance  (e.g., better caching, optimizing database queries).
 - Older monolithic architectures typically scale vertically.
 - Small businesses and startups(Single server applications) often use vertical scaling before moving to horizontal scaling.
 - Vertical scaling is preferable when - 
    - When dealing with low-to-medium traffic applications.
    - When keeping infrastructure simple (e.g., single-database apps).
    - When latency-sensitive workloads require low network overhead.

## Advantages and Disadvantages
### Advantages
- Simplicity – No need for load balancing, data partitioning, or distributed coordination.
- Lower Latency – No network overhead since everything is processed within a single machine.
- Easier Consistency Management – No need for complex synchronization mechanisms.

### Disadvantages
- Scalability Limits – There’s a hardware limit to CPU, RAM, and storage upgrades.
- Single Point of Failure – If the machine crashes, the entire system goes down.
- Expensive – High-end servers are costly, and upgrading becomes more expensive over time.

## Horizontal v/s Vertical
| Feature      | Horizontal      | Vertical      |
| :---  | :----:  | :----:           |
| **Method** | 	Add more machines (nodes) | Upgrade a single machine |
| **Scalability** | Virtually unlimited | Limited by hardware |
| **Cost** | 	Cheaper (commodity hardware) | Expensive (high-end servers) |
| **Complexity** | High (load balancing, sharding) | Low (simple upgrades) |
| **Performance** | 	Distributed workload | Faster for single tasks |
| **Failure Tolerance** | High (multiple nodes) | Low (single point of failure) |
| **Use Cases** | 	Cloud apps, big data, web apps | Databases, legacy systems |

## Practices
- Auto-Scaling – Use AWS Auto Scaling, Kubernetes HPA (Horizontal Pod Autoscaler), or GCP Compute Autoscaler for automatic scaling.
- Load Balancing – Use NGINX, HAProxy, AWS ELB, or Cloudflare Load Balancer for distributing traffic across servers.
- Database Partitioning & Replication – Use sharding (horizontal scaling) and read replicas (vertical scaling) for performance optimization.
- Microservices Over Monoliths – Design microservices architectures that scale independently.
- Hybrid Scaling – Combine horizontal and vertical scaling (e.g., scale up database servers but scale out application servers).

# **Client-Server Architecture**
Client-Server Architecture is a fundamental design pattern in distributed systems where clients request services, and servers provide them. The client and server communicate over a network using standard protocols like HTTP, WebSockets, or gRPC.
## Client
- A client is a program or device that initiates requests to the server for data or services like Web browsers, mobile apps, desktop applications.
-  They request data from the server, display processed data to users and maintain a session with the server (e.g., authentication tokens)
## Server
- A server is a program or system that processes client requests and sends back responses like  Web servers (NGINX, Apache), database servers (MySQL, PostgreSQL), API servers.
- They process client requests, manage business logic and, store and retrieve data from databases.
- Server is designed in a way, different types of clients can connect to it.
- Server has all the information and acts as the central management system

## Types of Client-Server Architecture
### Two-Tier Architecture
- Direct communication between client and server(A desktop application directly querying a database server).
- Simple but has scalability limitations

### Three-Tier Architecture
- This is the most common Client-Server architecture and is more scalable and secure.
- It has a client(React, Vue), application server(Backend API: Spring Boot, Express.js, Django) and database(MySQL, MongoDB).

### Multi-Tier (N-Tier) Architecture
- Large scale applications have more than three layers to fulfill caching, authentication, analytics etc.

## Advantages and Disadvantages
### Advantages
- Centralized Control - Easier to manage updates and security.
- Scalability - Can handle many clients by adding more servers.
- Data Integrity - Centralized database ensures consistency.
- Security - Servers enforce access control and authentication.

### Disadvantages
- Single Point of Failure – If the server crashes, all clients are affected.
- Network Dependency – Requires a reliable network for communication.
- Server Overload – High traffic can slow down server response times.

# **Load Balancer**
- A Load Balancer is a system component (hardware or software) that sits between clients and backend servers to distribute incoming traffic across multiple servers to improve performance, maximize availability, prevent overloading and enable fault tolerance.
- With a load balancer, traffic is evenly spread, it detects and skips unhealthy servers(Use `/actuator/health` as a reliable endpoint) and we can scale horizontally with ease. 
- When a server goes down, the load balancer identifies the clients waiting to be served by the faulty servers and assign them to healthy servers, which ensures that all clients are served.
- Simply put, it ensures that all the server's load is balanced.
## Types of Load Balancers
### Layer 4 Load Balancing
### Layer 7 Load Balancing

## Load Balancing Algorithms
### Round Robin
### Least Connections
### IP Hash
### Weighted Round Robin
### Health Check Based

## How to design a scalable backend for an e-commerce app with high user traffic?
“I’d use a Layer 7 Load Balancer like AWS ALB or Nginx to distribute incoming HTTP requests across multiple Spring Boot instances. The load balancer would perform health checks on each instance, support SSL termination, and handle path-based routing (e.g., /products to one service, /checkout to another). Behind the services, we’d use a database cluster and Redis cache, also fronted by their own load balancers where needed.”

## Tools
- Nginx - L4/L7 - Reverse proxy, L7 rules, SSL, caching
- HAProxy - L4/L7
- AWS ELB - L4/L7
- Traefik - L7 - Cloud Native, automatic Service Discovery
- Envoy Proxy - L7 - Used in Service Meshes
---

## Topics to explore
- Load Balancing – Use NGINX, HAProxy, AWS ELB to distribute client requests.
- Load Balancing Strategies (Round Robin, Least Connections, etc.)
- Reverse Proxy vs Load Balancer
- Service Discovery (Consul, Eureka, DNS-based)
- Global Load Balancing (GeoDNS, Anycast)
- Rate Limiting & Throttling
- Zero-Downtime Deployments with Load Balancers
- Load Balancer in Kubernetes (Ingress Controller)
- Cloud Auto-Scaling (AWS, GCP, Azure)
- Database Scaling (Sharding vs Replication vs Read Replicas)
- Database Replication – Avoid bottlenecks by using read replicas.
- Caching – Reduce load using Redis, Memcached, CDN caching.
- Asynchronous Communication – Use message queues (Kafka, RabbitMQ) to decouple services.
- API Security – Use OAuth, JWT, TLS encryption for secure authentication.
- Microservices vs Monolithic Architecture
- REST vs gRPC vs WebSockets
- Load Balancing Strategies
- Event-Driven Architecture
