package mypack;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/*
@Component can't be used because of outside of sub package of main spring class.
In order to use it we have to put `@ComponentScan` inside @Configuration
`@ComponentScan(basePackages = {"mypack"})` at MyConfig
 */
@Component
public class Dog {
    public void eating(){
        System.out.println("I'm dog and i'm eating food.");
    }
}
