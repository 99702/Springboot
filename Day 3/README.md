# Day 3

* [Annotations](#Annotations)
* [Dependency injection](#DependencyInjection)
* [Web Annotations](#web-annotation)
* [relationship](#Relations)

# DependencyInjection


# Annotations
 - Tag that represent metadata  i.e class,interface,methods,fields to provide additional information for java compiler.
 - Examples  
     - @Override  - make sure subclass is overriding parent class.
     - @SupressWarnings  - to supress warnings to compiler 
     - @Deprecated   - to provide information about depretiation of method or class
 
 - There are three types of annotations:
   - Marker annotation : no method, eg: `@interface MyAnnotation `
   - Single Value annotation : annotation with one method ``@interface Myannotation{int value();}``
   - Multi value annotation: more than one method
 
#### Spring boot annotations
Spring boot annotation is a form of metadata that provide data about a program. Some of core spring boot 
annotations are as follow:
* @`Required`
* @`Autowired`
* @`SpringBootApplication`
* @`EnableAutoconfiguration`
* @`Component`
* @`Controller`
* @`RestController`
* @`Service`
* @`Repository`
* @`ComponentScan`
* @`Bean`

For testing we have
* @`SpringBootTest`

@`Required`
It applies the bean setter method. It indicates that the annotated bean must be populated at configuration
time with the required property, else it throw an exception `BeanInitializationException`.
Example 
```
public class Machine   
{  
private Integer cost;  
@Required  
public void setCost(Integer cost)   
{  
this.cost = cost;  
}  
public Integer getCost()   
{  
return cost;  
}     
}  
```

@`Autowired`
Autowire spring bean on setter methods, instance variables and constructor. 
When we use @Autowired annotation, the spring container autowires the bean on setter method,
instance variables and constructors.
https://stackoverflow.com/questions/3153546/how-does-autowiring-work-in-spring
```
@Controller // Defines that this class is a spring bean
@RequestMapping("/users")
public class SomeController {

    // Tells the application context to inject an instance of UserService here
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public void login(@RequestParam("username") String username,
           @RequestParam("password") String password) {

        // The UserServiceImpl is already injected and you can use it
        userService.login(username, password);
    }
}
https://stackoverflow.com/questions/3153546/how-does-autowiring-work-in-spring
```


@`SpringBootApplication`
Signifies that it is spring boot application. It is composite annotation combining
* @`SpringBootConfiguration`
* @`EnableAutoConfiguration`
* @`ComponentScan`


@`Componentscan`
Enables component scanning. This lets you declare other classes with annotations like @`Component`,
@`Controller` and @`Service` to have spring automatically discover and register them as components
in the spring application context.


@`EnableAutoConfiguration`
Enables Spring boot automatic configuration. This annotation tells Spring boot automatically configure 
any components that it thinks we'll need.

@`SpringBootConfiguration`
Designates class as configuration class . It is specialized form for ``@Configuration`` annotation.

@`Component`
It is annotation to be used so that Spring boot application automatically discovers it and create it as bean
in the `Spring application context`

@`Controller`
It is used to mark classes as Spring MVC Controller.
This annotation is just a specialized version of @Component and 
it allows the controller classes to be auto-detected based on classpath scanning.

@`RestController`
This annotation is a specialized version of @Controller which adds @Controller and @ResponseBody annotation automatically. 
so we do not have to add @ResponseBody to our mapping methods. That means @ResponseBody is default active.
It also converts the response to JSON/XML automatically as @ResponseBody makes the returned objects to something that could be in the body, e.g. JSON or XML.

@`Service`
These class files are used to write business logic. It contains a interface extending various repositories builtin such as handling crud application.
Those Service interface are implemented in different class and annotated them as `@Service` and business logic is written there.

@`Repository`
The Spring @Repository annotation is a specialization of the @Component annotation
which indicates that an annotated class is a “Repository”, which can be used as a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects



@`SpringBootTest`
The @`SpringBootTest` annotation tells Spring Boot to look for a main configuration class
(one with @`SpringBootApplication`, for instance) and use that to start a Spring application context.

@`DataJpaTest`
Test the repository layer once it is completed , Database wont be impacted.


[What's the difference between @Component, @Repository & @Service annotations in Spring?](https://lightrun.com/java/the-complete-list-of-spring-boot-annotations-you-must-know)

[the-complete-list-of-spring-boot-annotations-you-must-know](https://lightrun.com/java/the-complete-list-of-spring-boot-annotations-you-must-know)


# DependencyInjection
It is a design pattern that helps in executing the Inversion of Control.
The depth of dependency injection is for compelling the dependencies.

https://blog.knoldus.com/dependency-injection-in-spring-boot/

https://dzone.com/articles/dependency-injection-in-spring




# Web-annotation
Spring provides web annotation through `org.springframework.web.bind.annotation` package.

Some of commonly used web annotation for `RequestMapping` are

* @`RequestMapping`
* @`RequestBody`
* @`PathVariable`
* @`RequestParam`

[//]: # (needs to implement)
[//]: # (Some of commonly used response handling annotation are)

[//]: # (* @`ResponseBody`)
[//]: # (* @`ExceptionHandler`)
[//]: # (* @`ResponseStatus`)


@`RequestMapping`
To handle the mapping between web requests. It can be applied to *class* or *method* level 
in a controller.
for example

```
@Controller
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/user")
	public String getUser() {
		
	}
}

// or

@Controller
public class UserController {

	@RequestMapping("/user")
	public String getUser() {
		
	}
}
```

@`RequestBody`
RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic
deserialization . It is used to fetch body given by client into to request to the server.

@`RequestParam`
It is used to extract the query params , form params from the request.
https://www.baeldung.com/spring-request-param



@`PathVariable`
If in requestMapping , we need to send some parameter
`@GetMapping("/api/employeeswithvariable/{id}")` i.e `id`
then we use `@PathVariable` annotation to get that `id` and put it into body . For example
```
@GetMapping("/api/employeeswithvariable/{id}")
@ResponseBody
public String getEmployeesByIdWithVariableName(@PathVariable("id") String employeeId) {
    return "ID: " + employeeId;
}
// for multiple

@GetMapping("/api/employees/{id}/{name}")
@ResponseBody
public String getEmployeesByIdAndName(@PathVariable String id, @PathVariable String name) {
    return "ID: " + id + ", name: " + name;
}

```

https://www.baeldung.com/spring-pathvariable



https://www.baeldung.com/spring-requestmapping
https://www.baeldung.com/spring-new-requestmapping-shortcuts



# Relations

In spring relations are made by following annotation:
* @OnetoOne
It is used to implement one to one relationship between two tables. 

* @`OneToMany` @`ManyToOne`

* @`ManyToMany`

For defining entities we define following annotation

* @`Entity`: Spring boot recognizes it is entity class.
* @`Id` : It is given to the primary key of an entity.
* @`GeneratedValue`: It is use for generation of next autoincrement value. some of are `GenerationType.Identity`,` GenerationType.Auto`, `GenerationType.Sequence`. Where `Sequence` creates a new table of incremental value. 
if we want sequence to be in different we should have similar example as below,
```
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

```
* @`Embeddable` @`Embedded`:
If we dont want to make a class an entity in database bust still want to seperate some fields , we can do so by using these annotations. For example

```
@Embeddable: to the outside class to which to be included.
@Embeded: should be put to the column defined of parent class.

//another class
@Embeddable
class Another {
private String name ;
}

// parent class
{
.....
@Embedded
private Another another;
}

```

* @`AttributeOverrides`
If the table , rows is already defined . We can override that row by our rows using this annotation.
```
@AttributeOverrides({
        @AttributeOverride(name="name", column = @Column(name="guardian_name")),
        @AttributeOverride(name="email", column = @Column(name="guardian_email")),
        @AttributeOverride(name="mobile", column = @Column(name="guardian_mobile"))
})

// where name is `variable name defined in that class`,
         column is `that table name to be  overrided`

```



* @`Table` : It is used to provide the given entity name to be saved in to the database. For example `@Table(name="laptop_table")` creates `laptop_table` table in the database.

* @`Column`: It is used to manually specify the name of the row in the table . If not given, spring boot automatically generates the name from the variables.
example,
```
    @Column(name="email_address")
    private String emailId;
	
```


