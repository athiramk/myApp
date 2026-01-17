package com.athira.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {



    /*
    Field dependency Injection - Generally avoid using this
    With field injection, @Autowired is used directly on class fields. Spring’s dependency injection container then automatically assigns these fields during the class’s instantiation. This method is straightforward but can lead to several issues.

    Pros:

    Simple to set up; requires minimal code.
    Common in older Spring applications, so it may be familiar to developers.

    Cons:

    Hidden dependencies: It’s not immediately clear what dependencies a class has, as they’re not visible in the constructor or methods.
    Weak testability: Makes it harder to create test instances without using frameworks like Mockito’s @InjectMocks.
    Impedes immutability: Dependencies cannot be marked as final, making them susceptible to accidental reassignment.
    Reliance on reflection: Uses reflection under the hood, which can impact performance and code readability.

    Recommendation: Avoid field injection when possible, as it can lead to issues with testability, immutability, and hidden dependencies.
    */

    /* USAGE
    @Autowired
    private Laptop laptop;
    */



    /*
    //Setter DI
    In setter injection, dependencies are injected via public setter methods. This method offers more flexibility than field injection, allowing dependencies to be assigned or changed after an object’s instantiation. Setter injection is useful in specific scenarios, such as optional dependencies or when a dependency may change during the object’s lifecycle.

    Pros:

    Flexibility: Useful when you have optional dependencies or need to change dependencies at runtime.
    Better readability than field injection: Dependencies are more visible than with field injection, especially when using @Autowired on the setters.

    Cons:

    Weaker immutability: Like field injection, setter injection does not support final fields.
    Unclear dependencies: It’s not immediately clear what dependencies are essential, as setters may not indicate optional vs. required dependencies.
    Risk of incomplete initialization: A class may be instantiated without all required dependencies if not properly enforced.

    Recommendation: Use setter injection for optional dependencies only, and avoid it for mandatory dependencies.
     */

    /* USAGE
    private Laptop laptop;
    @Autowired
    public void setLaptop(Laptop laptop)
    {
        this.laptop = laptop;
    }
    */


    /*
    //Constructor DI

    Constructor injection requires all dependencies to be provided at the time of object creation. This method makes dependencies explicit and enforces them at compile time, making it the preferred injection method in most cases.

    Pros

    Explicit dependencies: Constructor injection makes it immediately clear which dependencies a class requires.
    Strong immutability: Dependencies can be marked final, ensuring they’re set only once.
    Better testability: Allows easy injection of mock dependencies directly via the constructor without the need for special annotations or frameworks.
    Compile-time safety: Enforces that all required dependencies are provided when the object is created, reducing the chance of null or uninitialized fields.

    Cons:

    Less flexible for optional dependencies: For optional dependencies, you may need to create overloaded constructors or use Optional.
    Verbose constructor: With multiple dependencies, constructors can become lengthy, but this can often be managed by refactoring or grouping related dependencies.
    Recommendation: Use constructor injection for mandatory dependencies to ensure clear, immutable, and testable code.
    */


    //USAGE
    private Laptop laptop;
    public Dev(Laptop laptop)
    {
        this.laptop = laptop;
    }




    public void build()
    {
        laptop.compile();
        System.out.println("Working on an awesome project");
    }
}
