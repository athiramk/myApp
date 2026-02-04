# myApp — Spring Boot Dependency Injection (DI) Basics

This is a very small Spring Boot sample app that demonstrates the fundamentals of Dependency Injection (DI) in Spring: how the container creates and wires beans, and examples of constructor/setter/field injection patterns (with recommendations).

Project language: Java (Spring Boot)

## Quick summary
- The app is intentionally minimal and educational.
- It uses Spring's component scanning to register beans.
- A `Dev` component depends on a `Laptop` component; the `Dev` uses constructor injection to receive the `Laptop`.
- The application starts the Spring container and obtains a `Dev` bean from the ApplicationContext to demonstrate usage.

## What you will learn from this repository
- How to mark classes as Spring-managed components with `@Component`.
- How Spring injects dependencies (constructor injection is shown and recommended).
- How to fetch beans from the `ApplicationContext` for demonstration or manual wiring.
- Best-practice guidance on choosing constructor vs setter vs field injection.

## Key files
- `src/main/java/com/athira/myApp/MyAppApplication.java` — application entrypoint; starts the Spring IoC container and retrieves a bean.
- `src/main/java/com/athira/myApp/Laptop.java` — a small component that exposes a `compile()` method.
- `src/main/java/com/athira/myApp/Dev.java` — a component that depends on `Laptop` and demonstrates DI (constructor injection is used).

(See exact snippets below this README for reference.)

## How DI is used here (concrete)
- `@Component` on `Laptop` tells Spring to manage that class as a bean.
- `@Component` on `Dev` tells Spring to manage `Dev`. `Dev` declares a constructor that takes `Laptop` — Spring automatically injects the `Laptop` bean when creating `Dev`.
- The main class runs the Spring container and calls `context.getBean(Dev.class)` to obtain the managed `Dev` instance and invoke its `build()` method. This prints a short demonstration output.

## Running the app

Requirements
- Java 17+ (or the version defined in the project build files)
- Maven (or use the provided Maven wrapper `./mvnw`)

Run with Maven:
```bash
./mvnw clean spring-boot:run
# or
mvn spring-boot:run
```

Or build and run the jar:
```bash
./mvnw -DskipTests package
java -jar target/*.jar
```

Expected console output when run:
```
Compiling on laptop
Working on an awesome project
```
(Printed by `Laptop.compile()` and `Dev.build()` respectively.)

## Why constructor injection is recommended (and how this repo uses it)
- Constructor injection makes dependencies explicit and allows fields to be `final`.
- It improves testability since dependencies can be provided directly in unit tests without relying on the Spring container.
- This project demonstrates constructor injection in `Dev` for a mandatory dependency on `Laptop`.

## Notes about setter and field injection (documented in `Dev.java`)
- Setter injection is appropriate for optional dependencies.
- Field injection is simple but discouraged (hidden dependencies, harder to test).
- `Dev.java` contains inline comments that explain pros/cons and usage examples of these approaches.

## Testing
The repository includes a basic Spring Boot context-load test:
- `src/test/java/com/athira/myApp/MyAppApplicationTests.java` — ensures the Spring context starts.
