package es.opplus.front.views.example.di;

import javax.enterprise.context.Dependent;

/**
 * A simple prototype-scoped service.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@Dependent
public class MyService {
    public String sayHello() {
        return "Hello from " + this;
    }
}
