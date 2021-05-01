package es.opplus.front;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import es.opplus.front.services.notifications.BrowserNotifications;
import es.opplus.front.views.enlace2.Enlace2;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
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
public class MainLayout extends AppLayout {

    private final Tabs menu;
    private H1 viewTitle;

    public MainLayout() {

        menu = new Tabs();
        //setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        createMenu();
        addToDrawer(createDrawerContent());

        /*
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();

            String preferredUsername = keycloakSecurityContext.getIdToken().getPreferredUsername();

            Anchor logout = new Anchor(
                    "http://localhost:9991/auth/realms/Demo/protocol/openid-connect/logout?redirect_uri=" +
                            "http://localhost:9998/",
                    "Logout");

            setContent(new HorizontalLayout(new Span(preferredUsername), logout));
        } else {
            setContent(new Span("No Logged in User"));
        }
         */
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.add(new Avatar("Antonio Carvajal"));
        return layout;
    }

    private Component createDrawerContent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/logo.png", "OM logo"));
        logoLayout.add(new H1("OM"));
        layout.add(logoLayout, menu);
        return layout;
    }

    private void createMenu() {
        menu.setOrientation(Tabs.Orientation.VERTICAL);
        menu.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        menu.setId("tabs");
        menu.add(createMenuItems());
        menu.addSelectedChangeListener(listener -> {
            Tab tab = listener.getSelectedTab();
            if (tab != null)
                UI.getCurrent().navigate(ComponentUtil.getData(tab, Class.class));
        });
    }

    private Component[] createMenuItems() {
        return new Tab[]{
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 1", new Label("132"), Enlace1.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Enlace 2", null, Enlace2.class)/*,
                createTab(FontAwesome.Solid.CHART_AREA.create(), "Informes", new Label("132"), HelloWorldView.class),
                createTab(FontAwesome.Solid.INBOX.create(), "Operaciones", new Label("132"), OperationsView.class)*/
        };
    }

    private Tab createTab(IronIcon icon, String text, Component suffix, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();

        icon.setSize("32px");

        Label tabText = new Label(text);
        tabText.getStyle().set("margin-left", "10px");
        //tabText.setClassName("drawer-menu-label");
        tabText.setWidthFull();

        tab.add(icon, tabText);
        if (suffix != null)
            tab.add(suffix);
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }


    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        Optional<Tab> tab = getTabForComponent(getContent());
        if (tab.isPresent())
            menu.setSelectedTab(tab.get());
        else
            menu.setSelectedTab(null);

        viewTitle.setText(getCurrentPageTitle());
        //if (UI.getCurrent() != null)
            BrowserNotifications.extend(UI.getCurrent()).askForPermission();
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
