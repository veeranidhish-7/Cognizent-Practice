# spring-learn

Spring Core + Spring REST hands-on project (covers the exercises in
"1__spring-rest-handson.docx" and "2__spring-rest-handson.docx").

## What's inside

- **Spring Core (XML configuration)**
  - `date-format.xml` — a `SimpleDateFormat` bean, loaded and used in
    `SpringLearnApplication.displayDate()`
  - `country.xml` — a single `Country` bean (India), four individual country
    beans (`in`, `us`, `de`, `jp`), and a `countryList` bean assembled from
    references to them (`SpringLearnApplication.displayCountry()` /
    `displayCountries()` demonstrate singleton scope and list loading)
- **Logging** — configured in `application.properties`, `Logger`/`LoggerFactory`
  used everywhere instead of `System.out.println`
- **REST controllers**
  - `HelloController` — `GET /hello` → `Hello World!!`
  - `CountryController`
    - `GET /country` → hardcoded India bean from `country.xml`
    - `GET /countries` → all four countries (via `CountryService`)
    - `GET /countries/{code}` → single country, case-insensitive lookup,
      throws `CountryNotFoundException` (mapped to HTTP 404) when not found
- **Tests** — `SpringLearnApplicationTests` uses `MockMvc` to verify the
  controller loads and that `/country` and the not-found scenario behave as
  expected

## Requirements

- JDK 11
- Maven 3.6+
- Internet access (first build only, to download dependencies)

## Build & Run

```bash
mvn clean package
mvn spring-boot:run
```

The app starts on **port 8083** (set in `application.properties`).

## Try it out

```bash
curl http://localhost:8083/hello
curl http://localhost:8083/country
curl http://localhost:8083/countries
curl http://localhost:8083/countries/in
curl -i http://localhost:8083/countries/az   # 404 Country not found
```

## Run tests

```bash
mvn clean test
```

## Notes

- This project was **not compiled in this environment** (no Maven Central
  access here) — run `mvn clean package` locally to pull the dependencies and
  verify.
- Package name used is `com.cognizant.springlearn` (the doc's
  `com.cognizant.spring-learn` isn't a legal Java package name because of the
  hyphen, so the hyphen was dropped, matching the class references the doc
  itself uses, e.g. `com.cognizant.springlearn.Country`).
- This project is also the base for the `spring-learn-jwt` project (adds
  Spring Security + JWT authentication on top of this one).
