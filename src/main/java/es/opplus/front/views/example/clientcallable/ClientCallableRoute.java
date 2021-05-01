package es.opplus.front.views.example.clientcallable;

import es.opplus.front.MainLayout;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


/**
 * Demoes {@link ClientCallable}.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("Client Callable Demo | Vaadin Quarkus Demo")
@Route(value = "cc2", layout = MainLayout.class)
public class ClientCallableRoute extends VerticalLayout {
    public ClientCallableRoute() {
        add(new Span("Pressing the button sends the string to the HelloWorldCC.getGreeting() which computes the greeting."));
        add(new HelloWorldCC());
    }
}
