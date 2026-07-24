# spring-learn-jwt

Spring Security + JWT authentication hands-on project (covers
"5__JWT-handson.docx"). This is the `spring-learn` project extended with:

1. HTTP Basic authentication via Spring Security (in-memory `admin`/`pwd` and
   `user`/`pwd` accounts)
2. An `/authenticate` endpoint that exchanges Basic-auth credentials for a JWT
3. A `JwtAuthorizationFilter` that validates the `Bearer <token>` on every
   subsequent request

## What's inside (in addition to spring-learn)

- `security/SecurityConfig.java` — `@EnableWebSecurity`, in-memory users,
  BCrypt password encoder, URL authorization rules, registers the JWT filter
- `security/JwtAuthorizationFilter.java` — extends `BasicAuthenticationFilter`,
  parses and validates the `Authorization: Bearer <token>` header on each
  request
- `controller/AuthenticationController.java` — `GET /authenticate`, decodes
  the Basic-auth header to get the username, then issues a signed JWT
  (HS256, 20-minute expiry, secret `"secretkey"` — hard-coded for learning
  purposes only, see Notes below)

## Requirements

- JDK 11
- Maven 3.6+
- Internet access (first build only)

## Build & Run

```bash
mvn clean package
mvn spring-boot:run
```

The app starts on **port 8090**.

## Try it out

1. **Without credentials** — rejected:
   ```bash
   curl -i http://localhost:8090/countries
   # 401 Unauthorized
   ```

2. **Get a JWT** using Basic auth (`user`/`pwd`):
   ```bash
   curl -s -u user:pwd http://localhost:8090/authenticate
   # {"token":"eyJhbGciOiJIUzI1NiJ9...."}
   ```

3. **Call a service using the JWT**:
   ```bash
   curl -s -H "Authorization: Bearer REPLACE_TOKEN_HERE" http://localhost:8090/countries
   ```

4. **Tamper with the token** and confirm you get `401 Unauthorized`.

## Run tests

```bash
mvn clean test
```

Tests cover: context loads, an unauthenticated request is rejected, a
Basic-auth request to `/country` succeeds, and `/authenticate` returns a
token.

## Notes

- This project was **not compiled in this environment** — run
  `mvn clean package` locally to pull dependencies and verify.
- **jjwt 0.9.0** (the version specified in the hands-on doc) internally uses
  `javax.xml.bind.DatatypeConverter`, which was removed from the default JDK
  modules in JDK 11+. The `pom.xml` includes `jaxb-api` and `jaxb-runtime` to
  restore it. If you still hit compile/runtime errors on your JDK version,
  the cleanest fix is to upgrade to `jjwt-api` / `jjwt-impl` / `jjwt-jackson`
  0.11.x, which don't have this dependency at all — ask if you'd like that
  version instead.
- The JWT signing key (`"secretkey"`) and 20-minute expiry are hard-coded
  as in the exercise — for anything beyond learning purposes, move the key
  to configuration/a secrets manager and consider a shorter expiry with
  refresh tokens.
- `WebSecurityConfigurerAdapter` (used here, matching the doc) is deprecated
  from Spring Security 5.7 onward in favor of a `SecurityFilterChain` bean.
  It still works fully on the Spring Boot 2.5.5 / Spring Security 5.5.x
  versions pinned in this `pom.xml`.
