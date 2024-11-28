Sequence Diagram
---
Documentation
---
### DNS Resolution Process
When a user enters a URL in the browser, the DNS resolution process is initiated to resolve 
the domain name to an IP address by querying DNS servers.

#### Steps:
1. **User Input**: The user enters a URL in the browser.
2. **Browser Cache Check**:
    - If the IP address is found in the browser cache, the content is displayed.
    - If not found, the DNS recursor is queried.
3. **DNS Recursor**:
   - The DNS recursor checks its cache for the IP address. If found, the IP address is returned to the browser.
   - If not found, the DNS recursor queries the root nameserver.
4. **Root Nameserver**:
   - The root nameserver returns the TLD nameserver (the extension) details to the DNS recursor.
5. **TLD Nameserver**:
   - The TLD nameserver returns the authoritative nameserver details (the site URL + extension) to the DNS recursor.
6. **Authoritative Nameserver**:
   - The authoritative nameserver returns the IP address to the DNS recursor.
7. **Browser**:
    - The browser receives the IP address from the DNS recursor and makes an HTTP GET request to the authoritative nameserver.
    - The authoritative nameserver returns the homepage content to the browser.
    - The browser displays the homepage content to the user.
---
### TCP Handshake
Before communicating with the server, the browser and server create a TCP connection using a three-way handshake.

#### Steps:
1. **SYN Request**: The browser sends a TCP SYN request to the server on port 80.
2. **SYN-ACK Response**: The server responds with a SYN-ACK message, where the server acknowledges that the browser wants to make a connection.
3. **ACK Response**: The browser sends an ACK message to the server, acknowledging the server's response.
4. **Homepage Request**: The browser sends an HTTP GET request to the server to retrieve the homepage.
5. **Homepage Rendering**: 
    - If the homepage is served directly by the frontend (Vue), the frontend sends the homepage content to the browser.
    - The browser renders the homepage content.
---
### User Login Sequence
The user login sequence handles the user authentication process by validating user credentials and generating a JWT token for authorized access.

#### Steps:
1. **User Input**: The user enters their username and password in the login form.
2. **Form Submission**: The browser submits the login form to the frontend (Vue).
3. **Backend Handling**:
    - The frontend sends a POST request to the backend /login endpoint.
    - The backend controller calls the service layer to handle the login logic.
    - The service layer validates the user credentials and queries the repository layer for user data.
    - The repository layer interacts with the database using Hibernate to fetch the user record.
4. **Response**:
    - If credentials are valid, a JWT token is returned.
    - If credentials are invalid, an error (401 Unauthorized) is returned.
---
### Post Creation Sequence
This process handles the submission of a new post (title and message) by the logged-in user and saves the post to the database.

#### Steps:
1. **User Input**: The user enters post details in the browser.
2. **Form Submission**: The browser submits the post form to the frontend (Vue).
3. **Backend Handling**:
    - The frontend sends a POST request to the backend /api/posts endpoint with the JWT token in the header.
    - The backend controller calls the service layer to create a new post.
    - The service layer validates the post data and saves the post to the database using the repository layer.
    - The repository layer interacts with the database to save the post entity.
4. **Response**:
    - If successful, a "201 Created" status is returned, and the user is notified.
    - If validation fails, a "400 Bad Request" status is returned.
    - If the request is unauthorized, a "401 Unauthorized" status is returned.
---
### Post Retrieval Sequence
This process retrieves all the posts from the database and displays them to the user.

#### Steps:
1. **User Action**: The user navigates to the Form page.
2. **API Request**: The browser sends a GET request to the backend /api/posts endpoint with the JWT token in the header.
3. **Backend Handling**: 
    - The backend controller calls the service layer to retrieve all posts.
    - The service layer queries the repository layer to fetch all posts from the database.
    - The repository layer interacts with the database using Hibernate to fetch all post records.
4. **Response**:
    - If posts are available, a "200 OK" status is returned with the posts.
    - If no posts are available, a "204 No Content" status is returned.

Diagram
---
```mermaid
---
config:
  theme: neo
---
sequenceDiagram
    actor User as User
    participant Browser as Browser
    participant DNS Recursor as DNS Recursor
    participant Root nameserver as Root nameserver
    participant TLD nameserver as TLD nameserver
    participant Authoritative nameserver as Authoritative nameserver
    
    %% DNS Process    
    activate Browser
    User ->> Browser: Enter URL [site URL once deployed]
    activate User
    activate Browser
    Browser ->> Browser: Check DNS cache
    deactivate Browser
    
    alt if in cache
        Browser -->> User: Show content (homepage)
        deactivate Browser
    end

    activate DNS Recursor
    activate Browser
    Browser ->> DNS Recursor: DNS Query
    activate DNS Recursor
    DNS Recursor ->> DNS Recursor: Check DNS cache
    deactivate Browser
    deactivate DNS Recursor
        
    alt if in cache
        activate Browser
        DNS Recursor -->> Browser: IP-address from cache
        activate Authoritative nameserver
        Browser ->> Authoritative nameserver: HTTP GET Request TCP (80)
        Authoritative nameserver -->> Browser: Homepage
        deactivate Authoritative nameserver
        Browser -->> User: Show Content (homepage)
        deactivate Browser
    end
        activate Root nameserver
        DNS Recursor ->> Root nameserver: [URL] Query Root server
        Root nameserver -->> DNS Recursor: [extension] TLD nameserver details
        deactivate Root nameserver
        
        activate TLD nameserver
        DNS Recursor ->> TLD nameserver: [extension] TLD [URL] Query
        TLD nameserver -->> DNS Recursor: Authoritative nameserver details
        deactivate TLD nameserver
        
        activate Authoritative nameserver
        DNS Recursor ->> Authoritative nameserver: [URL]
        Authoritative nameserver -->> DNS Recursor: IP address
        deactivate Authoritative nameserver
        
        activate Browser
        DNS Recursor -->> Browser: Return IP address
        deactivate DNS Recursor

    participant Frontend (Vue) as Frontend (Vue)
    participant Backend Controller as Backend Controller
    participant Service Layer as Service Layer
    participant Repository Layer as Repository Layer
    participant Hibernate as Hibernate ORM
    participant Database as Database
    
    %% TCP Handshake
    activate Browser
    Browser ->> Frontend (Vue): TCP-handshake (SYN) on port 80
    activate Frontend (Vue)
    Frontend (Vue) ->> Browser: TCP-handshake (SYN ACK)
    Browser ->> Frontend (Vue): TCP-handshake (ACK)
    Browser -->> User: Display "Connecting to server..."
    Browser ->> Frontend (Vue): HTTP GET Request for "/"
    activate Frontend (Vue)
    Frontend (Vue) ->> Frontend (Vue): Serve homepage directly (no backend call)
    deactivate Frontend (Vue)
    Frontend (Vue) -->> Browser: Render homepage
    Browser -->> User: Display homepage content
    deactivate User
    
    %% Login Sequence    
    User ->> Browser: Enter credentials (username/password)
    activate User
    Browser ->> Frontend (Vue): Submit login form
    deactivate Frontend (Vue)
    deactivate Browser
    Frontend (Vue) ->> Backend Controller: POST /login
    activate Frontend (Vue)
    activate Backend Controller
    Backend Controller ->> Service Layer: loginUser()
    activate Service Layer
    Service Layer ->> Repository Layer: Query user by username
    activate Repository Layer
    Repository Layer ->> Hibernate: Execute query
    activate Hibernate
    Hibernate ->> Database: Fetch user record
    activate Database
    Database -->> Hibernate: Return user data
    deactivate Database
    Hibernate -->> Repository Layer: Return user entity
    deactivate Hibernate
    Repository Layer -->> Service Layer: Return user entity
    deactivate Repository Layer
    activate Service Layer
    Service Layer ->> Service Layer: Validate password
    deactivate Service Layer

    alt Valid credentials
        Service Layer ->> Backend Controller: Return JWT Token
        deactivate Service Layer
        Backend Controller -->> Frontend (Vue): Return 200 OK with JWT
        Frontend (Vue) -->> Browser: Save JWT Token
        activate Browser
        Browser -->> User: Display "Login successful"
        deactivate Browser
    else Invalid credentials
        activate Service Layer
        Service Layer -->> Backend Controller: Return error
        deactivate Service Layer
        Backend Controller -->> Frontend (Vue): Return 401 Unauthorized
        deactivate Backend Controller
        Frontend (Vue) -->> Browser: Display error message
        activate Browser
        deactivate Frontend (Vue)
        Browser -->> User: Display "Invalid username or password"
        deactivate User
        deactivate Browser
    end
    
    %% Post Creation Sequence   
    User ->> Browser: Enter post details (title/message)
    activate User
    activate Browser
    Browser ->> Frontend (Vue): Submit post form
    deactivate Browser
    activate Frontend (Vue)
    Frontend (Vue) ->> Backend Controller: POST api/posts (JWT included in header)
    activate Backend Controller
    Backend Controller ->> Service Layer: createPost(post)
    activate Service Layer
    
    alt Valid post
        Service Layer ->> Repository Layer: save(post)
        activate Repository Layer
        Repository Layer ->> Hibernate: Persist post entity
        activate Hibernate
        Hibernate ->> Database: Insert new record
        activate Database
        Database -->> Hibernate: Confirm insertion
        deactivate Database
        Hibernate -->> Repository Layer: Entity saved
        deactivate Hibernate
        Repository Layer -->> Service Layer: Success response
        deactivate Repository Layer
        Service Layer -->> Backend Controller: Success response
        deactivate Service Layer
        Backend Controller -->> Frontend (Vue): Return 201 Created
        Frontend (Vue) -->> Browser: Notify user
        activate Browser
        Browser -->> User: Display "Post created successfully"
        deactivate Browser
    else Validation errors
        activate Service Layer
        Service Layer -->> Backend Controller: Return 400 Bad Request
        deactivate Service Layer
        Backend Controller -->> Frontend (Vue): Return error response
        Frontend (Vue) -->> Browser: Notify user
        activate Browser
        Browser -->> User: Display "Post validation failed"
        deactivate Browser
    else Unauthorized request
        Backend Controller -->> Frontend (Vue): Return 401 Unauthorized
        deactivate Backend Controller
        Frontend (Vue) -->> Browser: Notify user
        activate Browser
        deactivate Frontend (Vue)
        Browser -->> User: Display "Unauthorized - Please log in"
        deactivate Browser
        deactivate User
    end
    
    %% Post Retrieval Sequence    
    User ->> Browser: Navigate to posts page
    activate User
    activate Browser
    Browser ->> Frontend (Vue): HTTP GET api/posts (JWT included in header)
    deactivate Browser
    activate Frontend (Vue)
    Frontend (Vue) ->> Backend Controller: GET /api/posts
    activate Backend Controller
    
    alt Posts available
        Backend Controller ->> Service Layer: getAllPosts()
        activate Service Layer
        Service Layer ->> Repository Layer: findAll()
        activate Repository Layer
        Repository Layer ->> Hibernate: Execute query
        activate Hibernate
        Hibernate ->> Database: Fetch post records
        activate Database
        Database -->> Hibernate: Return records
        deactivate Database
        Hibernate -->> Repository Layer: Return entities
        deactivate Hibernate
        Repository Layer -->> Service Layer: Return entities
        deactivate Repository Layer
        Service Layer -->> Backend Controller: Return formatted posts
        deactivate Service Layer
        Backend Controller -->> Frontend (Vue): Return 200 OK with posts
        Frontend (Vue) -->> Browser: Render posts
        activate Browser
        Browser -->> User: Display retrieved posts
        deactivate Browser
    else No posts available
        Backend Controller -->> Frontend (Vue): Return 204 No Content
        deactivate Backend Controller
        Frontend (Vue) -->> Browser: Notify user
        activate Browser
        deactivate Frontend (Vue)
        Browser -->> User: Display "No posts available"
        deactivate Browser
        deactivate User
    end
```
