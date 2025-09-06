# OAuth2 Login with Springboot Practice

This project is a simple Spring Boot application that demonstrates Google OAuth2 login with pring Security and Thymeleaf views.  
It allows users to navigate between a public page and a private page, showing user details when logged in.

---

## Features

- Public Page accessible without login
- Private Page requires Google login
- Displays user attributes (first name, last name, email)
- Secure authentication via OAuth2 (Google Login)
- Logout support (redirects back to home page)
- Thymeleaf templates for rendering UI

---

## Folder Structure
```code

src/main/java/com/vipusa/oAuthPractise/  
│ 
├── config/   
│ └── SecurityConfig.java     # Spring Security + OAuth2 setup  
│  
├── controller/  
│ └── DemoController.java     # Handles routes (/, /public, /private)  
| └── resources/templates/  
|        ├── index.html       # Home page with navigation buttons  
|        ├── public.html      # Public page  
|        └── private.html     # Private page (shows user attributes + logout)     

```

---

## Dependencies

Add the following to your **Maven `pom.xml`**:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- OAuth2 Client (for Google login) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>

    <!-- Thymeleaf Templates -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>

```
Configuration
Add your Google OAuth2 Client ID and Secret in application.properties:
```bash
# OAuth2 Client Registration for Google
spring.security.oauth2.client.registration.google.client-id = YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret = YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope = profile,email

# OAuth2 Provider details for Google
spring.security.oauth2.client.provider.google.authorization-uri = https://accounts.google.com/o/oauth2/v2/auth
spring.security.oauth2.client.provider.google.token-uri = https://oauth2.googleapis.com/token
spring.security.oauth2.client.provider.google.user-info-uri = https://openidconnect.googleapis.com/v1/userinfo
spring.security.oauth2.client.provider.google.jwk-set-uri = https://www.googleapis.com/oauth2/v3/certs
spring.security.oauth2.client.provider.google.user-name-attribute = sub
``` 
How to Run

1. Clone the repository

```bash
git clone https://github.com/https://github.com/vipusrihar/oAuth-Practice.git
cd oAuthPractice/google_spring_boot
```
2. Add your Google OAuth2 credentials in application.properties

3. Run the application

```bash
mvn spring-boot:run
```  
4. Access in browser  
```bash
http://localhost:8080/ → Home Page
http://localhost:8080/public → Public Page
http://localhost:8080/private → Private Page (requires login)
```

Home Page -> Buttons to navigate between Public and Private pages.  
Public Page  -> Accessible without login.   
Private Page -> Displays user’s First Name, Last Name, Email and provides a Logout button.




---
