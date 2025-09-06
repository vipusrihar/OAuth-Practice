
# Asgardeo OAuth Practice Project

This project demonstrates how to integrate **OAuth 2.0** authentication using **Asgardeo** in a Spring Boot application.  

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/vipusrihar/oAuth-Practice.git
cd oAuth-Practice
````

---

### 2. Create an Application in Asgardeo

1. Log in to [Asgardeo Console](https://console.asgardeo.io/).
2. Go to **Applications** → **New Application**.
3. Select **Traditional Web Application**.
4. Enter a name (e.g., `Spring OAuth App`).
5. Add the following to **Authorized redirect URLs**:

   ```
   http://localhost:8080/login/oauth2/code/asgardeo
   ```
6. Save the application.
7. Copy the **Client ID**, **Client Secret**, and **Issuer URI**.

---

### 3. Configure Application Properties

Update the `src/main/resources/application.properties` file:

```properties
spring.application.name=asgardeo

# === Asgardeo OIDC client registration ===
spring.security.oauth2.client.registration.asgardeo.client-name=Asgardeo
spring.security.oauth2.client.registration.asgardeo.client-id=<your-client-id>
spring.security.oauth2.client.registration.asgardeo.client-secret=<your-client-secret>

# Redirect URI (must match the one registered in Asgardeo console)
spring.security.oauth2.client.registration.asgardeo.redirect-uri=http://localhost:8080/login/oauth2/code/asgardeo

# Grant type and scopes
spring.security.oauth2.client.registration.asgardeo.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.asgardeo.scope=openid,profile,email

# Provider configuration (copy the Issuer URI from Asgardeo)
spring.security.oauth2.client.provider.asgardeo.issuer-uri=https://api.asgardeo.io/t/<org-name>/oauth2/token
```

⚠️ Replace:

* `<your-client-id>`
* `<your-client-secret>`
* `<org-name>`

---

### 4. Run the Application

Using Maven:

```bash
./mvnw spring-boot:run
```

Or using Gradle:

```bash
./gradlew bootRun
```

Default URL: [http://localhost:8080](http://localhost:8080)

---

### 5. Login with Asgardeo

1. Open the app in your browser.
2. Click **Login with Asgardeo**.
3. Sign in using your Asgardeo account.
4. You’ll be redirected back to your app with an authenticated session.

---

## 🛠 Troubleshooting

### ❌ Redirect URI Mismatch

* **Error:** `redirect_uri_mismatch`
* **Fix:** Ensure the redirect URI in Asgardeo matches exactly with:

  ```
  http://localhost:8080/login/oauth2/code/asgardeo
  ```

---

### ❌ Invalid Client ID or Secret

* **Error:** `invalid_client`
* **Fix:** Check that the values in `application.properties` match the ones in Asgardeo Console.

---

### ❌ 401 Unauthorized

* **Possible Causes:**

  * Wrong **Issuer URI** in `application.properties`
  * Using incorrect **tenant/organization name** in the URL

* **Fix:**
  Make sure `issuer-uri` is correct. Example:

  ```
  https://api.asgardeo.io/t/<org-name>/oauth2/token
  ```

---

### ❌ Session Issues

* **Fix:** Clear your browser cookies or use incognito mode if login loops happen.

---

## 🔒 Best Practices (Asgardeo Settings)

When configuring your application in the **Asgardeo Console**, follow these best practices:

1. **Disable "Skip Login Consent"**  
   - Go to your application → **Advanced Settings**.  
   - Make sure **Skip Login Consent** is **disabled**.  
   - This ensures users always see the consent screen before logging in.  

2. **Disable "Skip Logout Consent"**  
   - In the same **Advanced Settings** section, disable **Skip Logout Consent**.  
   - This prevents silent logouts and ensures users confirm before signing out.  

3. **Enable Required User Attributes**  
   - Under **User Attributes** or **Requested Attributes**, enable only the attributes your app really needs (e.g., `email`, `profile`, `phone_number`).  
   - This follows the **principle of least privilege** and protects user privacy.  

   #### Match Scopes with User Attributes
   After updating the scopes in your `application.properties`, make sure to enable only the corresponding user attributes in the Asgardeo Console:

   - **openid** → required for all OIDC logins  
   - **profile** → enable attributes like `name`, `family_name`, `given_name`
   - **email** → enable `email`

---

## Demo Video

You can watch the demo of this practice code here:  
[Click here to watch the demo video](https://drive.google.com/file/d/1Nh5Z59ZPuLmF0iW9QeBlOASwJANLyJGm/view?usp=drive_link)

---
##  References

* [Asgardeo Documentation](https://wso2.com/asgardeo/docs/)
* [Spring Security OAuth2 Login](https://docs.spring.io/spring-security/reference/servlet/oauth2/login/core.html)

