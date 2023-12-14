# Notes

## Inversion of Control (IoC)

The approach of outsourcing the
construction and management of objects

## Dependency Injection

* The dependency inversion principle
* The client delegates to another object
the responsibility of providing its
dependencies

#### Recommended Injection Types

* Constructor Injection
* Setter Injection

#### Which one to use?

* Constructor Injection
  * Use this when you have required dependencies
  * Generally recommended by the `spring.io` development team as first choice
* Setter Injection
  * Use this when you have optional dependencies
  * If dependency is not provided, your app can provide reasonable default logic

#### AutoWiring

Spring will look for a class that matches by type: class or interface and inject it automatically

## @Component

* Marks the class as a Spring Bean
* Makes the bean available for dependency injection

## Scanning for Component Classes

* Spring will scan your Java classes for special annotations
* Automatically register the beans in the Spring container

@SpringBootApplication is composed of

| Annotation               |                                      Description                                      |
|--------------------------|:-------------------------------------------------------------------------------------:|
| @EnableAutoConfiguration |                   Enables Spring Boot's auto-configuration support                    |
| @ComponentScan           | Enables component scanning of current package<br/>Also recursively scans sub-packages |
| @Configuration           |     Able to register extra beans with @Bean or import other configuration classes     |

* By default, Spring Boot starts component scanning
  * From same package as your main Spring Boot application
  * Also scans sub-packages recursively
* This implicitly defines a base search package
  * Allows you to leverage default component scanning
  * No need to explicitly reference the base package name

``` java
  @SpringBootApplication(
  scanBasePackages = {"com.studies.springcoredemo",
                      "com.studies.util",
                      "org.acme.cart",
                      "edu.cmu.srs"})
  public class SpringcoredemoApplication { }
```

## Setter Injection

Inject dependencies by calling setter methods on your class

## Qualifiers


