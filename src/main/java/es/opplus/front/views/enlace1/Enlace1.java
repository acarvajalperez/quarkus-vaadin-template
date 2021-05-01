package es.opplus.front.views.enlace1;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.router.RouteAlias;
import es.opplus.front.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Port of the "Skeleton Starter" Vaadin app on top of Quarkus+Undertow.
 * @author Martin Vysny <mavi@vaadin.com>
 */
@PageTitle("View 1")
@RouteAlias(value = "", layout = MainLayout.class)
@Route(value = "view1", layout = MainLayout.class)
public class Enlace1 extends VerticalLayout {
    public Enlace1() {
        IronIcon icon =  FontAwesome.Solid.ENVELOPE.create();
        icon.setSize("100px");
        icon.setColor("red");
        add(icon);
        add(new Span("Hola"));
    }
}
