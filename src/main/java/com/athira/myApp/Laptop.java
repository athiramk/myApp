package com.athira.myApp;

import org.springframework.stereotype.Component;

/*
The @Component will specify that the Spring has to manage the instances of Laptop class, but to use the instance Dev class,
we need to inject the dependency using field, setter or constructor DI. Field and Setter DI needs/uses the keyword @Autowired
 */
@Component
public class Laptop {
    public void compile()
    {
        System.out.println("Compiling on laptop");
    }
}
