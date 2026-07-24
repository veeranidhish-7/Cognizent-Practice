# orm-learn

Spring Data JPA + Hibernate hands-on project (covers
"1__spring-data-jpa-handson.docx").

## What's inside

- **`model/Country`** — JPA entity mapped to a `country` table
  (`co_code` primary key, `co_name`)
- **`repository/CountryRepository`** — `JpaRepository<Country, String>`, plus
  a derived query method `findByNameContainingIgnoreCase` for the
  "find countries matching a partial name" feature mentioned in the
  objectives
- **`service/CountryService`** — all five features called out in Hands on
  5-9:
  - `getAllCountries()`
  - `findCountryByCode(code)` — throws `CountryNotFoundException` if missing
  - `addCountry(country)`
  - `updateCountry(code, name)`
  - `deleteCountry(code)`
  - plus `findCountriesByPartialName(text)` (bonus)
- **`OrmLearnApplication`** — runs each of the above in sequence on startup,
  logging the results (mirrors the `testGetAllCountries()` /
  `testAddCountry()` / etc. style from the doc)
- **`CountryServiceTest`** — JUnit 5 tests covering the CRUD operations,
  running against an in-memory H2 database (`src/test/resources/application.properties`)
  so you don't need MySQL just to run the test suite
- **`src/main/resources/db/schema.sql`** and **`db/country_inserts.sql`** —
  the table-creation script and the full ~249-row world country list from
  the doc, extracted and cleaned up for you to run against MySQL directly

## Requirements

- JDK 11
- Maven 3.6+
- MySQL Server 8.0 (only needed to run the app itself — the test suite uses H2)
- Internet access (first build only)

## Set up the database

```bash
mysql -u root -p < src/main/resources/db/schema.sql
mysql -u root -p ormlearn < src/main/resources/db/country_inserts.sql
```

(Or run the two `.sql` files through MySQL Workbench against a schema named
`ormlearn`.)

`application.properties` assumes `root`/`root` on `localhost:3306` — update
`spring.datasource.username` / `spring.datasource.password` to match your
setup.

## Build & Run

```bash
mvn clean package
mvn spring-boot:run
```

Watch the console log — you'll see the full country list, then India looked
up by code, a country added/updated/deleted, and a partial-name search for
"stan" (matches Afghanistan, Kazakhstan, Pakistan, etc.), each wrapped in
Start/End debug logs as in the original hands-on.

## Run tests (no MySQL required)

```bash
mvn clean test
```

## Notes

- This project was **not compiled in this environment** — run
  `mvn clean package` locally to pull dependencies and verify.
- `spring.jpa.hibernate.ddl-auto=validate` is used as specified in the doc,
  which means Hibernate checks the table/columns exist but never creates or
  alters them — you must run `schema.sql` first. If you'd rather have
  Hibernate create the table automatically, change this to `update` in
  `application.properties`.
- Package name used is `com.cognizant.ormlearn` (the doc's
  `com.cognizant.orm-learn` isn't a legal Java package name because of the
  hyphen — same reasoning as the `spring-learn` project's package name).
