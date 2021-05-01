package es.opplus.front;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import es.opplus.front.components.ThemeComboBox;
import es.opplus.front.components.layout.NavigationBar;
import es.opplus.front.components.layout.OpplusLayout;
import es.opplus.front.services.notifications.BrowserNotifications;
import es.opplus.front.views.enlace2.Enlace2;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.PWA;
import es.opplus.front.views.enlace1.Enlace1;

import java.util.Optional;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "Operation Manager", shortName = "OM", enableInstallPrompt = false)
@CssImport("./styles/views/main/main-view.css")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css?family=Montserrat")
public class MainLayout extends OpplusLayout {
    public MainLayout() {
        super();
    }
}
