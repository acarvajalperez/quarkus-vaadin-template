package es.opplus.front.views.example.di;

import es.opplus.front.MainLayout;
import com.urosporo.quarkus.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Demoes the dependency injection of services.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("Dependency Injection Demo | Vaadin Quarkus Demo")
@Route(value = "di2", layout = MainLayout.class)
@UIScoped
public class DiRoute extends VerticalLayout {
    @Inject
    MyService myService;
    @Inject
    MySessionScopedService mySessionScopedService;
    @Inject
    MyUIScopedService myUIScopedService;
    @Inject
    MyRouteScopedService myRouteScopedService;

    @PostConstruct
    public void init() {
        add(new Paragraph("@PostConstruct-annotated method has been called correctly for this route"));
    }

    public DiRoute() {
        add(new H2("Demoes Quarkus dependency injection and various scopes"));
        add(new Span("UI instance: " + UI.getCurrent()));
        add(new Span("This route (should be UI-scoped): " + this));
        add(new Span("Warning: pressing F5 will re-create the UI, clearing both the UI-scoped and Route-scoped beans"));
        add(new Hr());
        add(new Span("Prototype-scoped; navigate away and back to get a new instance"));
        add(new Button("Say hello, prototype", e -> Notification.show(myService.sayHello())));
        add(new Span("Session-scoped; remains for the duration of the session and survives refresh via F5"));
        add(new Button("Say hello, session", e -> Notification.show(mySessionScopedService.sayHello())));
        add(new Span("UI-scoped; remains until the current browser tab is closed"));
        add(new Button("Say hello, UI", e -> Notification.show(myUIScopedService.sayHello())));
        add(new Span("Route-scoped; tied to this route (until a new UI is created)"));
        add(new Button("Say hello, route", e -> Notification.show(myRouteScopedService.sayHello())));
    }
}
