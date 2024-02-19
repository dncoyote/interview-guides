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
    - `https://api.example.com/resource?version=1`
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
